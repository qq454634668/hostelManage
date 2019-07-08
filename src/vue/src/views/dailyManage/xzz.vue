<template>
    <div class="page page-occupancy">
      <el-container>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                      <el-form :inline="true" :model="form" class="demo-form-inline left" label-position="left">
                        <el-form-item label="学院">
                            <el-select v-model="form.xy" placeholder="学院" @change="selectChange('xy')">
                                <el-option v-for="(item,index) in form.xySelect" :key="index"
                                :label="item.name"
                                :value="item.code"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="专业">
                            <el-select v-model="form.zy" placeholder="专业" @change="selectChange('zy')">
                                <el-option v-for="(item,index) in form.zySelect" :key="index"
                                :label="item.name"
                                :value="item.code"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="年级">
                            <el-select v-model="form.nj" placeholder="年级" @change="selectChange('nj')">
                                <el-option v-for="(item,index) in form.njSelect" :key="index"
                                :label="item.nj"
                                :value="item.nj"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="班级">
                            <el-select v-model="form.bj" placeholder="班级">
                                <el-option v-for="(item,index) in form.bjSelect" :key="index"
                                :label="item.bj"
                                :value="item.bj"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item>
                             <el-button type="primary" @click="tableData()">查询</el-button>
                        </el-form-item>
                    </el-form>
                </el-header>
                <el-main class="padding-0">
                      <el-table :data="tableList" style="width: 100%">
                        <el-table-column label="姓名"  prop="realname"></el-table-column>
                        <el-table-column label="学院"  prop="xy"></el-table-column>
                        <el-table-column label="类别"  prop="lb"></el-table-column>
                        <el-table-column label="专业"  prop="zy"></el-table-column>
                        <el-table-column label="性别"  prop="xb"></el-table-column>
                        <el-table-column label="入住状态"  prop="zsztname"></el-table-column>
                        <el-table-column label="学院" >
                                 <template slot-scope="scope">
                                    <el-button @click="anpairz(scope.row)" type="success">安排入住</el-button>
                                </template>
                        </el-table-column>
                      </el-table>
                </el-main>
            </el-container>
          
          </div>
        </el-main>
      </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { BuildStatusDictionary,DicGetS,DicNj,DicBj,StudentList,MoveInto } from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default{
  data(){
      return{
          tableList:[],
         form: {
            xy: '',
            xySelect: [],
            zy: '',
            zySelect: [],
            nj:'',
            njSelect:[],
            bj:'',
            bjSelect:[]

        },

      }
  },
  methods:{
    selectChange(xy){
        if(xy == 'xy'){
            this.form.zy='';
            this.form.zySelect=[];
            this.form.nj='';
            this.form.njSelect=[];
            this.form.bj='';
            this.form.bjSelect=[];
            var  params = {
                lx:'zy',
                id:this.form.xy
            }
            this.zyxz(params)
        }else if(xy=="zy"){
            this.form.nj='';
            this.form.njSelect=[];
            this.form.bj='';
            this.form.bjSelect=[];
            this.njxz();
        }else if(xy=="nj"){
            this.form.bj='';
            this.form.bjSelect=[];
            this.bjxz();
        }
    },
   
    // 点击安排入住
    async anpairz(row) {
        var  params = {
            xh:row.xh,
            cwbh:this.$route.query.cwbh,
        }
      var res = await MoveInto(params);
      if (res.code == 200) {
         this.tableData()
      } else {
        this.$message(res.message)
      }
    },
    // 学生列表
    async tableData(params) {
        var  params = {
            zszt:1,
            xy:this.form.xy,
            zy:this.form.zy,
            nj:this.form.nj,
            bj:this.form.bj,
        }
      var res = await StudentList(params);
      if (res.code == 200) {
          console.log(res)
        this.tableList =  res.data; 
      } else {
        this.$message(res.message)
      }
    },
    // 公共字典查询学院和专业
    async apart(params,select) {
      var res = await BuildStatusDictionary(params);
      if (res.code == 200) {
        this.form.xySelect =  res.data; 
      } else {
        this.$message(res.message)
      }
    },
    // 专业选择
     async zyxz(params) {
      var res = await DicGetS(params);
      if (res.code == 200) {
           this.form.zySelect =  res.data;
        
         
      } else {
        this.$message(res.message)
      }
    },
     // 年级选择
     async njxz() {
          var  params = {
                    xy:this.form.xy,
                    zy:this.form.zy
        }
      var res = await DicNj(params);
      if (res.code == 200) {
           this.form.njSelect =  res.data;
        
         
      } else {
        this.$message(res.message)
      }
    },
       // 班级选择
     async bjxz() {
        this.form.bj='';
        this.form.bjSelect=[];
         var  params = {
                    xy:this.form.xy,
                    zy:this.form.zy,
                    nj:this.form.nj
            }
      var res = await DicBj(params);
      if (res.code == 200) {
            console.log(res);
            this.form.bjSelect =  res.data;
        
         
      } else {
        this.$message(res.message)
      }
    },
   
    

  },
  mounted(){
      var params = {
          lx:'xy'
      }
   this.apart(params,'xy');
   this.tableData();
    
  }
}
</script>
<style lang="stylus" scoped>      
      
</style>




