import axios from 'axios';
import NProgress from 'nprogress';
import Qs from 'qs';
import Vue from 'vue';
// import { Toast } from 'mint-ui';

//添加请求拦截器
axios.interceptors.request.use(
  function(config) {
    //在发送请求之前做某事

    return config;
  },
  function(error) {
    //请求错误时做些事
    return Promise.reject(error);
  }
);

//添加响应拦截器
axios.interceptors.response.use(
  function(response) {
    //对响应数据做些事
    return response;
  },
  function(error) {
    //请求错误时做些事
    return Promise.reject(error);
  }
);

export const formatFileParams = data => {
  var formData = new FormData(); // FormData 对象
  var params = {};

  if (data && !data.hasOwnProperty('values')) {
    params['values'] = Object.assign({}, data);
  } else {
    params['values'] = Object.assign({}, data.values);
  }
  for (let item in params) {
    if (item === 'values') {
      // 普通参数
      for (let name in params[item]) {
        if (Object.prototype.toString.call(params[item][name]) === '[object Array]') {
          params[item][name] = JSON.stringify(params[item][name]);
        }
        formData.append(name, params[item][name]);
      }
    } else if (item === 'files') {
      // 文件参数
      for (let name in params[item]) {
        let fileList = params[item][name];
        for (let i = 0; i < fileList.length; i++) {
          formData.append(name, fileList[i]);
        }
      }
    }
  }
  return formData;
};

// 防止多次ajax请求
const requesting = {};
export default function formMiddlePromise(url, params, method = 'post') {
  // console.log(url);
  // console.log(localStorage.getItem('appid'));
  // console.log(localStorage.getItem('accesstoken'));
  // console.log(params);
  var formdata = formatFileParams(params);
  method = method.toUpperCase();
  let uid = url + method + (!!~+[] + {});

  // if (requesting[uid]) {
  //   console.warn('请勿重复点击');
  //   return;
  // }
  requesting[uid] = true;
  return new Promise((resolve, reject) => {
    NProgress.start();
    axios({
      method: method,
      url: url,
      timeout: 60000,
      data: formdata,
      // This is only applicable for request methods 'PUT', 'POST', and 'PATCH'
      // The last function in the array must return a string or an instance of Buffer, ArrayBuffer,
      transformRequest: [
        function(data, headers) {
          return data;
        }
      ],
      headers: {
        'Content-Type': 'text/html; charset=UTF-8',
        uid: localStorage.getItem('appid'),
        token:localStorage.getItem('token')
      }
    })
      .then(
        response => {
          NProgress.done();
          resolve(response.data);
          requesting[uid] = false;
        },
        err => {
          NProgress.done();
          // console.log(JSON.stringify(err));
          if (err && err.response) {
            switch (err.response.status) {
              case 400:
                err.message = '请求错误';
                alert('请求错误');
                break;

              case 401:
                err.message = '未授权，请登录';
                alert('未授权，请登录');
                break;

              case 403:
                err.message = '拒绝访问';
                alert('拒绝访问');
                break;

              case 404:
                err.message = `请求地址出错: ${err.response.config.url}`;
                alert('请求地址出错: ${err.response.config.url}');
                break;

              case 408:
                err.message = '请求超时';
                alert('请求超时');
                break;

              case 500:
                err.message = '服务器内部错误';
                alert('服务器内部错误');
                break;

              case 501:
                err.message = '服务未实现';
                alert('服务未实现');
                break;

              case 502:
                err.message = '网关错误';
                alert('网关错误');
                break;

              case 503:
                err.message = '服务不可用';
                alert('服务不可用');
                break;

              case 504:
                err.message = '网关超时';
                alert('网关超时');
                break;

              case 505:
                err.message = 'HTTP版本不受支持';
                alert('HTTP版本不受支持');
                break;

              default:
            }
          }
          // if (err.response.status == 500) {
          //   alert('服务器内部错误');
          // } else {
          //   alert('网络请求失败，请检查网络');
          // }
          reject(err);
        }
      )
      .catch(thrown => {
        NProgress.done();
        alert(thrown);
        // this.$message(thrown);
        // Toast(thrown);
      });
  });
}
