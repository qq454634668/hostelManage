<template>
    <el-container class="page page-work pagebackk">
        <el-header  class="introduct" height="150px">
            <h2>工作视窗</h2>
            <h6>workstation</h6>
            <el-row :gutter="40" class="numbershow">
                <el-col :span="8">
                    <div class="grid-content bg-purple">
                        <h3 style="background-color:#00C0EF">
                            <i class="iconfont icon-menu2"></i>
                        </h3>
                        <h4>
                            <p>请假人次</p>
                            <h5>198677</h5>
                        </h4>
                    </div>
                </el-col>
                <el-col :span="8">
                    <div class="grid-content bg-purple">
                        <h3 style="background-color:#00A65A">
                            <i class="iconfont icon-diannao1"></i>
                        </h3>
                        <h4>
                            <p>未审批请假</p>
                            <h5>198677</h5>
                        </h4>
                    </div>
                </el-col>
                <el-col :span="8">
                    <div class="grid-content bg-purple">
                        <h3 style="background-color:#DD4B39">
                            <i class="iconfont icon-shenhe"></i>
                        </h3>
                        <h4>
                            <p>已审批请假</p>
                            <h5>198677</h5>
                        </h4>
                    </div>
                </el-col>
            </el-row>
        </el-header>
        <el-main>
           <div>
               <el-tabs type="border-card">
                    <el-tab-pane label="请假申请">
                        <el-form :inline="true" :model="formInline" class="demo-form-inline">
                            <el-form-item label="">
                                <el-input v-model="formInline.gjc" placeholder="请输入学号 或姓名"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit">查询</el-button>
                            </el-form-item>
                        </el-form>
                         <div class="right" style="text-align:right">
                            <el-popover ref="popover2"  placement="bottom" title=""  width="100" trigger="click">
                                <el-checkbox-group v-model="checkList" :min="1">
                                    <el-checkbox label="sqr"  @change="checkinlist(1)">申请人</el-checkbox>
                                    <el-checkbox label="xh"  @change="checkinlist(2)">学号</el-checkbox>
                                    <el-checkbox label="splb"  @change="checkinlist(3)">申请类别</el-checkbox>
                                    <el-checkbox label="time"  @change="checkinlist(4)">申请时间</el-checkbox>
                                    <el-checkbox label="dqbz"  @change="checkinlist(5)">当前步骤</el-checkbox>
                                    <el-checkbox label="dshr"  @change="checkinlist(6)">申请类别</el-checkbox>
                                    <el-checkbox label="cz"  @change="checkinlist(7)">操作</el-checkbox>
                                </el-checkbox-group>
                            </el-popover>
                            <el-button v-popover:popover2><i class="iconfont icon-liucheng4"></i></el-button>
                            <el-popover ref="popover3"  placement="bottom" title=""   trigger="click">
                                <el-checkbox-group v-model="checkList">
                                    <el-button type="text">导出excel</el-button>
                                    <el-button type="text">导出word</el-button>
                                </el-checkbox-group>
                            </el-popover>
                            <el-button v-popover:popover3><i class="iconfont icon-daoru3"></i></el-button>
                        </div>
                    </el-tab-pane>
                </el-tabs>
                <el-table :data="tableData"  style="width:100%" >
                    <el-table-column  prop="sqr" label="日期"  width="180" v-model="headshow[0].header"> </el-table-column>
                    <el-table-column  prop="xh" label="姓名"  width="180" v-model="headshow[1].header"> </el-table-column>
                    <el-table-column prop="splb"  label="地址"></el-table-column>
                    <el-table-column  prop="time" label="日期"  width="180"> </el-table-column>
                    <el-table-column  prop="dqbz" label="姓名"  width="180"> </el-table-column>
                    <el-table-column prop="dshr"  label="地址"></el-table-column>
                    <el-table-column prop="cz"  label="操作">
                        <template>
                            <button>审核</button>
                        </template>
                    </el-table-column>
                </el-table>
                
           </div>
            
        </el-main>
        
    </el-container>
</template>
<script>
export default {
    data(){
        return{
            left:true,
            isCollapse:false,
            label:true,
            formInline:{
                gjc:''
            },
            checkList: ['sqr','xh','splb','time','dqbz','dshr','cz'],
            tableData:[
                {sqr:'某某',xh:'111843057',splb:'sdd',time:'21019',dqbz:'当前步骤',dshr:'待审核人'}
            ],
            
            tableHead:[
                    {name:'申请人',zf:'sqr'},
                    {name:'学号',zf:'xh'},
                    {name:'审批类别',zf:'splb'},
                    {name:'申请时间',zf:'time'},
                    {name:'当前步骤',zf:'dqbz'},
                    {name:'待审核人',zf:'dshr'},
                    {name:'操作',zf:'cz'}
                ],
                headshow:[
                    {header:false},
                    {header:true}
                ],
                    
            
        }
    },
    methods:{
        menu(){
           this.isCollapse =true;

        },
        onSubmit(){

        },
        tottgle(pd){
            console.log(pd)
            if(pd == true){
                 pd = false;
            }else if(pd == false){
               pd = true
            }
        },
        checkinlist(num){
         this.tottgle(this.headshow[num].header);
         console.log(this.headshow[num].header)

        },
        handleOpen(){

        },
        handleClose(){

        }

    },
    mounted(){

    }
}
</script>
<style lang="stylus" scoped>
    .page-work{
        text-align:left;
        .introduct{
            padding-top:20px;
            padding-bottom:20px;
            height:200px; 
            h2,h6{
                display:inline-block;
                padding-bottom:20px;
            }
            .numbershow{
                .grid-content{
                    background-color:#fff;
                    height:90px;
                    h3{
                        width:90px;
                        height:100%;
                        float:left;
                        line-height 90px;
                        text-align:center;
                        color:#fff;
                        .iconfont{
                            font-size:40px;
                        }
                    }
                    h4{
                        float:left;
                        padding:20px;
                        h5{
                            font-weight:bold;
                            padding-top:10px;
                            font-size:16px;
                        }
                    }
                }
            }
        }
        .el-main{
            >div{
                border:1px solid #d2d6de;
                border-top:3px solid #00C0EF;
                .el-form{
                    float:left; 
                }
                     
            }
            
        }
    }
    .el-button--text{
        display:block;
        color:#333;
    }
    .el-button+.el-button{
        margin-left:0px;
    }
    .el-checkbox+.el-checkbox{
        margin-left:0px;
    }
    .el-checkbox, .el-checkbox__input{
        display:block;
    }
</style>
    