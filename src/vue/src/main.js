// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import ElementUi from 'element-ui';
import Vuex from 'vuex';
import 'element-ui/lib/theme-chalk/index.css';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import echarts from 'echarts';
Vue.prototype.$echarts = echarts;
Vue.use(ElementUi);
Vue.use(Vuex);
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

router.beforeEach((to, from, next) => {
  if (to.path == '/login') {
    localStorage.removeItem('token');
  }
  var token = localStorage.getItem('token');
  // console.log(user)
  if (!token) {
      next({ path: '/login' });
    //未登录时
    // if (to.path == '/login') {
    //   next();
    // } else {
    //   //若不为登录页或使用说明页，转到登录页
    //   next({ path: '/login' });
    // }
  } else {
    //已经登录
    // if (!beginExam && (to.path == '/resgister' || to.path == '/finishExam')) {
    //   next({ path: '/onlineExam' });
    // } else {
    //   next();
    // }
    next();
  }
    // next();
});
// 为浏览器环境添加全局变量
if (process.env.NODE_ENV == 'development') {
  window.NODE_ENV = 'development';
} else {
  window.NODE_ENV = 'production';
}