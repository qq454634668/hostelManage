<template>
    <div class="page page-occupancy">
      <el-container>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                  <el-form :inline="true" :model="form" class="demo-form-inline left">
                       <el-form-item label="">
                         <el-select v-model="form.apart" placeholder="校区" @change="selectChange('apart')">
                           <el-option v-for="(item,index) in form.apartSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="">
                         <el-select v-model="form.district" placeholder="公寓区" @change="selectChange('district')">
                           <el-option v-for="(item,index) in form.districtSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="">
                         <el-select v-model="form.building" placeholder="选择公寓楼" @change="selectGet" filterable>
                           <el-option v-for="(item,index) in form.buildingSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="bedList()">查询</el-button>
                      </el-form-item>
                  </el-form>
                </el-header>
                <el-main class="border padding-0">
                        <div class="flex-box">
                             <div class="onewrap" v-for="(item,index) in tableDataList" :key="index">
                                <div class="buildShow">
                                  <!-- <span>{{form.buildName}}</span> -->
                                  <span>房间编号:{{item.fjbh}}</span>
                                </div>
                                <div class="flex-box border-right zynr">
                                      <div v-for="(tem,index2) in item.fjList" :key="index2">
                                          <div v-show="tem.zt==2"><span class="xuhao">{{index2+1}}</span>{{tem.realname}}</div>
                                          <div v-show="tem.zt==1" class="xianzhi" @click="link()"><span class="xuhao">{{index2+1}}</span>{{tem.ztname}}</div>
                                      </div>
                                      
                               </div>
                            </div>
                             <div class="onewrap" v-for="(item,index) in tableDataList" :key="index">
                                <div class="buildShow">
                                  <!-- <span>{{form.buildName}}</span> -->
                                  <span>房间编号:{{item.fjbh}}</span>
                                </div>
                                <div class="flex-box border-right zynr">
                                      <div v-for="(tem,index2) in item.fjList" :key="index2">
                                          <div v-show="tem.zt==2"><span class="xuhao">{{index2+1}}</span>{{tem.realname}}</div>
                                          <div v-show="tem.zt==1" class="xianzhi" @click="link()"><span class="xuhao">{{index2+1}}</span>{{tem.ztname}}</div>
                                      </div>
                                      
                               </div>
                            </div>
                             <div class="onewrap" v-for="(item,index) in tableDataList" :key="index">
                                <div class="buildShow">
                                  <!-- <span>{{form.buildName}}</span> -->
                                  <span>房间编号:{{item.fjbh}}</span>
                                </div>
                                <div class="flex-box border-right zynr">
                                      <div v-for="(tem,index2) in item.fjList" :key="index2">
                                          <div v-show="tem.zt==2"><span class="xuhao">{{index2+1}}</span>{{tem.realname}}</div>
                                          <div v-show="tem.zt==1" class="xianzhi"><span class="xuhao">{{index2+1}}</span>{{tem.ztname}}</div>
                                      </div>
                                      
                               </div>
                            </div>
                             <div class="onewrap" v-for="(item,index) in tableDataList" :key="index">
                                <div class="buildShow">
                                  <!-- <span>{{form.buildName}}</span> -->
                                  <span>房间编号:{{item.fjbh}}</span>
                                </div>
                                <div class="flex-box border-right zynr">
                                      <div v-for="(tem,index2) in item.fjList" :key="index2">
                                          <div v-show="tem.zt==2"><span class="xuhao">{{index2+1}}</span>{{tem.realname}}</div>
                                          <div v-show="tem.zt==1" class="xianzhi"><span class="xuhao">{{index2+1}}</span>{{tem.ztname}}</div>
                                      </div>
                                      
                               </div>
                            </div>
                            <div class="onewrap" v-for="(item,index) in tableDataList" :key="index">
                                <div class="buildShow">
                                  <!-- <span>{{form.buildName}}</span> -->
                                  <span>房间编号:{{item.fjbh}}</span>
                                </div>
                                <div class="flex-box border-right zynr">
                                      <div v-for="(tem,index2) in item.fjList" :key="index2">
                                          <div v-show="tem.zt==2"><span class="xuhao">{{index2+1}}</span>{{tem.realname}}</div>
                                          <div v-show="tem.zt==1" class="xianzhi"><span class="xuhao">{{index2+1}}</span>{{tem.ztname}}</div>
                                      </div>
                                      
                               </div>
                            </div>
                            <div class="onewrap" v-for="(item,index) in tableDataList" :key="index">
                                <div class="buildShow">
                                  <!-- <span>{{form.buildName}}</span> -->
                                  <span>房间编号:{{item.fjbh}}</span>
                                </div>
                                <div class="flex-box border-right zynr">
                                      <div v-for="(tem,index2) in item.fjList" :key="index2">
                                          <div v-show="tem.zt==2"><span class="xuhao">{{index2+1}}</span>{{tem.realname}}</div>
                                          <div v-show="tem.zt==1" class="xianzhi" @click="link()"><span class="xuhao">{{index2+1}}</span>{{tem.ztname}}</div>
                                      </div>
                                      
                               </div>
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
  import { mapMutations } from 'vuex';
  import { jquery } from '@/script/jquery-1.7.1';
  import occupancyManage from '@/script/occupancyManage.js';
export default{
  ...occupancyManage
}
</script>
<style lang="stylus" scoped>
    .page-occupancy{
      .buildShow{
            line-height:40px;
            color:#0000F6;
           
            border-bottom:1px solid #dedede;
        }
      .flex-box{
        display: -webkit-flex; 
        display: flex;
        flex-wrap: wrap
        >div{
          width:200px;
          // margin-left:20px;
          // margin-top:20px;
          
        }
        .onewrap{
           border-top:1px solid #dedede;
          border-bottom:1px solid #dedede;
          border-right:1px solid #dedede;
          margin-top:20px;
           .zynr{
             line-height:40px;
             .xianzhi{
               color:orange;
               cursor pointer;
             }
             .xuhao{
               display:inline-block;
               padding:0 10px;
             }
           }
        }
        .border-right{
          // border-right:1px solid #999;
        }
        
      }
    }
</style>




