<template>
    <div class="page page-login">
        <el-container>
            <el-header class="align-left" style="height:100px;">
                <img src="../image/logo.png" alt="">
            </el-header>
            <el-main>
                <div>
                    <div class="login right">
                       <h3>系统登录</h3>
                        <el-form :label-position="labelPosition" label-width="60px" :model="form">
                            <el-form-item label="账号">
                                <el-input v-model="form.username"  @keyup.enter="submitForm('form')"></el-input>
                            </el-form-item>
                            <el-form-item label="密码">
                                <el-input v-model="form.password" type="password" @keyup.enter="submitForm('form')"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="button" @click="submitForm('form')"   @keyup.enter="submitForm('form')">登录</el-button>
                            </el-form-item>
                        </el-form>
                        <p class="weibup">
                            欢迎使用Kiosk应用平台<br/>
                        </p>
                    </div>
                </div>
            </el-main>
             <el-footer style="height:280px;line-height:80px">
                Copyright © 2018 天津市第一商业学院
            </el-footer>
        </el-container>

    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { requestLogin} from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default {
    data(){
        return{
            form:{
                username:'',
                password:''
            },
            labelPosition:'right'
        }
    },
    methods:{
        submitForm(form){
            this.login()
        },
         async login(){
             var params = {
                username: this.form.username,
                password: this.form.password
            };
            var res = await requestLogin(params);
            if(res.code == 200){
                var token = res.data;
                localStorage.setItem('token',token);
                this.$router.push({ path: '/home' });
            }
         }

    },
    mounted(){

    }
}
</script>
<style lang="stylus" scoped>
    .page-login{
        .el-container{
            heightL:100%;
            width:100%;
            .el-header{
                padding:20px;
                height:80px;
                img{
                    height:100%;
                }
            }
            .el-main{
            background-image:url('../image/bg.jpg');
            background-size:100% 100%;
            padding-right:120px;
            padding-top:40px;
            >div{
                height:100%;
                .login{
                    padding:40px;
                    background-color:#fff;
                    h3{
                        padding:14.5px 0;
                        color:#797979;
                        margin-bottom: 30px;
                        font-weight: bold;
                        border-bottom:solid 1px #ebebeb;
                    }
                    .el-form{
                        border-bottom:1px solid #ebebeb;
                        .el-button{
                            width: 280px;
                            display: block;
                            text-align: center;
                            color: #fff;
                            // line-height: 38px;
                            height: 38px;
                            border-radius: 3px;
                            background-color: #eb5e00;
                            border: 0px;
                        }


                    }
                    .weibup{
                            line-height:40px;
                            color:#bbabab
                    }
                }
            }

            }
        }

    }
</style>
