<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  @import './style/common.css';
  @import './style/font/iconfont.css';
#app {
  font-family:  "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #333;
}
h1,h2,h3,h4,h5,h6,p,div,ul,li{
  padding:0;
  margin:0;

}
*{
  box-sizing: border-box;
}
.page{
  width:100%;
  height:100%;
  font-size:14px;
  font-family: 'Source Sans Pro','Helvetica Neue',Helvetica,Arial,sans-serif;
}
.align-left{
  text-align:left;

}

.clear{
  clear:both;
  width:100%;
  height:0
}
</style>
