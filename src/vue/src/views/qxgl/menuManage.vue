<template>
  <div class="page page-menu">
    <el-container>
      <el-main class="padding-0">
        <div class="content">
          <el-container>
            <el-main>
              <div class="align-left">
                <el-button type="warning" @click="add(dataList[dataList.length-1].parentMenu,dataList[dataList.length-1].parentMenu.parent_id)">增加一级菜单</el-button>
              </div>
              <div class="left flex-box menuMange" v-for="(item,index) in dataList" :key="index">
                <div class="Level1">
                  <ul class="border menuborder1">
                    <li>{{item.parentMenu.name}}</li>
                    <li>{{item.parentMenu.url}}</li>
                    <div class="setMenu">
                       <i class="iconfont icon-xiugai2" @click="edit(item.parentMenu)"></i>
                         <i class="iconfont icon-shanchu3" @click="deleteFunc(item.parentMenu)"></i>
                       <!-- <i class="iconfont" @click="up(dataList,index)">上移</i>
                       <i class="iconfont" @click="down(dataList,index)">下移</i> -->
                    </div>
                  </ul>
                </div>
                <div class="line"></div>
                <div class="line-boder-s">
                    <ul>
                      <li v-for="(item,index2) in item.sonMenu" :key="index2"></li>
                      <li></li>
                    </ul>
                </div>
                <div class="line2">
                  <div>
                       <div class="line-hs" v-for="(item,index2) in item.sonMenu" :key="index2">
                          <div class="lineh"></div>
                       </div>
                       <div class="line-hs">
                          <div class="lineh"></div>
                       </div>
                  </div>
                
                </div>
                <div class="level2">
                  <ul>
                    <li v-for="(item,index2) in item.sonMenu" :key="index2">
                           <span>{{item.name}} {{item.url}} </span> 
                           <div class="setMenu">
                                <i class="iconfont icon-xiugai2" @click="edit(item)"></i>
                                <i class="iconfont icon-shanchu3" @click="deleteFunc(item)"></i>
                                <!-- <i class="iconfont" @click="up(dataList,index)">上移</i>
                                <i class="iconfont" @click="down(dataList,index)">下移</i> -->
                          </div>
                    </li>
                    <li @click="add(item.sonMenu[item.sonMenu.length-1],item.parentMenu.id)">
                      <i class="iconfont">+</i>
                    </li>
                  </ul>
                </div>
              </div>
              <el-dialog title="修改" :visible.sync="dialogFormVisible" width="30%">
                  <el-form :model="editform" label-width="80px">
                    <el-form-item label="名称" >
                      <el-input v-model="editform.name" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="地址">
                       <el-input v-model="editform.url" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="图标" >
                       <el-input v-model="editform.icon" auto-complete="off"></el-input>
                    </el-form-item>
                 </el-form>
                   <div slot="footer" class="dialog-footer">
                      <el-button @click="dialogFormVisible = false">取 消</el-button>
                      <el-button type="primary" @click="editFunction">确 定</el-button>
                    </div>
              </el-dialog>
              <el-dialog title="增加" :visible.sync="dialogAdd" width="30%">
                  <el-form :model="addform" label-width="80px">
                    <el-form-item label="名称" >
                      <el-input v-model="addform.name" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="地址">
                       <el-input v-model="addform.url" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="图标" >
                       <el-input v-model="addform.icon" auto-complete="off"></el-input>
                    </el-form-item>
                 </el-form>
                   <div slot="footer" class="dialog-footer">
                      <el-button @click="dialogAdd = false">取 消</el-button>
                      <el-button type="primary" @click="addFunction()">确 定</el-button>
                    </div>
              </el-dialog>
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
        min-height:50px;
        background-color: #3D6DD1;
        color: #fff;
        position: relative;
        // height: 80px;
        line-height: 30px;
        position:relative;
        .setMenu{
          position:absolute;
          right:20px;
          color:#fff;
          top:10px;
          >i{
            cursor pointer;
            display:inline-block;
                padding:0px 5px;
          }
        }
       
      }
    }
     .line {
          width: 80px;
          border: 1px solid #999;
          height:0px;
      }
      .line-boder-s{
          width: 0px;
          padding:25px 0px;
          ul{
             border: 1px solid #999;
          }
          li{
            height:50px;
            margin-bottom:20px;
           
          }
          li:first-child{
            height:25px;
          }
          li:last-child{
            height:25px;
            margin-bottom:0px;
          }
      }
        .line2{
          width:80px;
          display: -webkit-flex;
          display: flex;
          justify-content:center;
          align-items:center;
          // border-left:1px solid #999;
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
          .line-hs:last-child{
            margin-bottom:0px;
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
          position:relative;
          //  background-color:#6497FF;
           border-radius:4px;
          border:1px solid #999;
          .setMenu{
              position:absolute;
              right:20px;
              color:#333;
              top:10px;
              >i{
                cursor pointer;
                display:inline-block;
                padding:0px 5px;
              }
            }
            i{
              cursor pointer;
            }
        }
         li:last-child{
            margin-bottom:0px;
          }
      }
    }
  }
  .menuMange{
    margin-bottom:40px;
  }
}
</style>

