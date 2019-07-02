<template>
    <el-container class="page page-home">
        <el-header class="home-header">
                <h1>学生请假系统</h1>
                <h3 class="iconfont icon-menu-two" @click="menu(right)"  v-if="isCollapse==false"></h3>
                <h3 class="iconfont icon-menu-two" @click="menu(left)" v-if="isCollapse==true"></h3>
                <div class="right userInfor">
                    <i class="iconfont icon-ren3"></i>
                    <em>{{userName}}</em>
                </div>
        </el-header>
        <el-container>
            <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse" :router="true">
                <div class="user">
                    <p :class="font"><i class="iconfont icon-ren3"></i></p>
                    <p v-if="isCollapse == false">
                        <span>admin</span>
                        <span>在线</span>
                    </p>
                </div>
                    <el-submenu v-for="(item,j) in menuData" :key="j" :index="String(item.id)">
                        <template slot="title">
                        <i class="iconfont icon-xinxiguanli1"></i>
                            <span slot="title">{{item.mainMenu.name}}</span>
                        </template>
                        <el-menu-item v-for="(child,i) in item.UnderMenu" :key="i" :index="String(child.url)"><i class="iconfont icon-daohang"></i>{{child.name}}</el-menu-item>
                    </el-submenu>
               
            </el-menu>
            <el-main class="contain padding-0">
                <el-container>
                    <el-main>
                        <router-view></router-view>
                    </el-main>
                    <el-footer class="line-60"><strong>Copyright © 2019.All rights reserved.</strong></el-footer>
                </el-container>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { InitInfo} from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default {
    data(){
        return{
            left:true,
            right:false,
            isCollapse:false,
            label:true,
            font:"",
            userName:'',
            menuData:'',
            index:''

        }
    },
    methods:{
        menu(flag){
            if(flag==false){
                this.isCollapse =true;
                this.font = 'bigfont'
            }else if(flag==true){
                this.isCollapse =false;
                this.font = ''
            }
        },
        handleOpen(){

        },
        handleClose(){

        },
        async menuList(){
             var params = {};
            var res = await InitInfo(params);
            if(res.code == 200){
                this.menuData = res.data.menuInfo;
            }
         }

    },
    mounted(){
        this.menuList();
    }
}
</script>
<style lang="stylus">
    .page-home{
        width:100%;
        height:100vh;
        background-color:#ECF0F5;
        .el-menu-vertical-demo:not(.el-menu--collapse) {
            width: 200px;
            min-height: 400px;
            
        }
        .home-header{
            height:60px;
            background-color:#3C8DBC;
            text-align:left;
            line-height:60px;
            color:#fff;
            h1{
                font-weight:700;
                display:inline-block;
                width:200px;
            }
            h3{
                display:inline-block;
            }
            .userInfor{
                em{
                    font-style:normal;
                }
                .iconfont{
                    font-size:36px;
                    color:#333;
                }
            }

        }
        .el-menu{
             background-color:#fff;
             border-right:1px solid #dcdcdc;
             height:100%;
            .user{
                p{
                    display:inline-block;
                    height:50px;
                    >.iconfont{
                        font-size:50px;   
                    }
                    span{
                        display:block;
                        height:25px;
                        line-height:20px;
                        font-size:14px;
                        color:#444444;
                        font-weight:600;
                    }
                }
                p.bigfont{
                >.iconfont{
                        font-size:40px;   
                    } 
                } 
            }
               
            .el-menu-item{
                height:40px;
                line-height:40px;
                text-align:left;
                i{
                    display:inline-block;
                    width:20px;
                    font-size:16px;
                    padding-right:10px;
                    color:#444444;
                }
            }
            .el-submenu__title{
                text-align:left;
                height:40px;
                line-height:40px;
            }
        }
        .contain{
            height:100%;
            .el-container{
                width:100%;
                height:100%;
            }
            .line-60{
                background-color:#fff;
                line-height:60px;
            }
        }
    }
</style>
    