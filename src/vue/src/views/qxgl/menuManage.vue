<template>
  <div class="page page-menu">
    <el-container>
      <el-main class="padding-0">
        <div class="content">
          <el-container>
            <el-main>
              <div class="left flex-box">
                <div class="Level1">
                  <ul class="border menuborder1">
                    <li class>一级菜单</li>
                    <li class>/purview/QueryUserList</li>
                  </ul>
                </div>
                <div class="line"></div>
                <div class="line2">
                  <div class="border-s"></div>
                  <div>
                        <div class="line-hs">
                          <div class="lineh"></div>
                      </div>
                      <div class="line-hs">
                        <div class="lineh"></div>
                      </div>
                      <div class="line-hs">
                        <div class="lineh"></div>
                      </div>
                  </div>
                
                </div>
                <div class="level2">
                  <ul>
                    <li>二级</li>
                    <li>二级</li>
                    <li>二级</li>
                  </ul>
                </div>
              </div>
            </el-main>
          </el-container>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import { mapMutations } from "vuex";
import { jquery } from "@/script/jquery-1.7.1";
import cdgl from "@/script/cdgl.js";
export default {
  ...cdgl
};
</script>
<style lang="stylus" scoped>
.page-menu {
  .flex-box {
    width:100%;
    display: -webkit-flex;
    display: flex;
    justify-content:center;
    align-items:center;
    .Level1 {
      flex-grow:1;
      -webkit-flex-grow:1;
      width: 0%;
      .menuborder1 {
        padding: 10px;
        background-color: blueviolet;
        color: #fff;
        position: relative;
        // height: 80px;
        line-height: 30px;
       
      }
    }
     .line {
          width: 80px;
          border: 1px solid #333;
          height:0px;
        }
        .line2{
          width:80px;
          display: -webkit-flex;
          display: flex;
          justify-content:center;
          align-items:center;
          border-left:1px solid #999;
          .border-s{
            width:0px;
            height:25px;
            border:1px solid #fff;
          }
          .line-hs{
            width:80px;
            height:50px;
            margin-bottom:20px;
              display: -webkit-flex;
              display: flex;
              justify-content:center;
              align-items:center;
            .lineh{
              width:80px;
              height:0px;
              border:1px solid #999;
            }
          }
        }
    .level2{
      flex-grow:1;
      -webkit-flex-grow:1;
      width: 0%;
      ul{
        li{
          line-height:40px;
          height:50px;
          margin-bottom:20px;
          border:1px solid #999;
        }
      }
    }
  }
}
</style>

