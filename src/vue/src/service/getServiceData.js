/**
 * 获取登录用户信息
 */
export const login = params => {
  requestLogin(params).then(ret => {
    // console.log(ret);
  });
};
