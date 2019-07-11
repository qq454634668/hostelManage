<template>
    <div class="page page-campus">
      <el-container>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                  <el-form :inline="true" :model="form" class="demo-form-inline left">
                      <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
                      <el-form-item>
                         <el-select v-model="form.zt" placeholder="请选择任务状态">
                           <el-option label="任务中" value="1"></el-option>
                           <el-option label="任务完成" value="2"></el-option>
                           <el-option label="任务失败" value="3"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="tableData()">查询</el-button>
                      </el-form-item>
                  </el-form>
                </el-header>
                <el-main class="border padding-0">
                   <el-table
                      :data="tableDataList"
                      max-height="300px"
                      border
                      style="width: 100%"
                      v-loading="loading">
                        <el-table-column
                          prop="task_name"
                          label="计划名称"
                          >
                        </el-table-column>
                        <el-table-column
                          prop="hfgz"
                          label="分配规则">
                        </el-table-column>
                        <el-table-column
                          prop="hfbh"
                          label="分配编号">
                        </el-table-column>
                        <el-table-column
                          prop="rwbh"
                          label="任务编号">
                        </el-table-column>
                        <el-table-column
                          prop="kssj"
                          label="开始时间">
                        </el-table-column>
                        <el-table-column
                          prop="jssj"
                          label="结束时间">
                        </el-table-column>
                      <el-table-column label="操作">
                            <template slot-scope="scope">
                              <el-button
                                size="mini"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                              <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-main>
                 
                <el-footer class="pagination">
                  <span>
                    显示第<em>{{page.startRow}}</em>到第 <em>{{page.endRow}}</em> 条记录，总共 <em>{{page.total}}</em> 条记录
                  </span>
                   <el-pagination
                      @current-change="handleCurrentChange"
                      layout="prev, pager, next,total"
                      :total="page.total" class="right"
                      :page-sizes="[100, 200, 300, 400]"
                      :page-size="5">
                    </el-pagination>
                </el-footer>
            </el-container>
            <el-dialog title="新增任务计划" :visible.sync="dialogFormVisible"
                   width="30%"
                   class="header-left">
                        <el-form label-position="right" label-width="120px" :model="add">
                                <el-form-item label="计划名称">
                                      <el-input placeholder="请输入任务名称" v-model="add.task_name"></el-input>
                                </el-form-item>
                                 <el-form-item label="划分规则">
                                  <el-select v-model="add.hfgz" placeholder="请选择划分规则" @change="hfgzChange()">
                                    <el-option v-for="(item,index) in add.hfgzSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                                  </el-select>
                                 </el-form-item>
                                 <el-form-item label="划分编号">
                                      <el-select v-model="add.hfbh" placeholder="请选择划分编号" @change="hfbhChange()">
                                         <el-option v-for="(item,index) in add.hfbhSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                                      </el-select>
                                 </el-form-item>
                                 <el-form-item label="开始时间" >
                                      <el-date-picker
                                            v-model="add.kssj"
                                            type="date"
                                            placeholder="请选择开始时间">
                                     </el-date-picker>
                                 </el-form-item>
                                  <el-form-item label="结束时间" >
                                      <el-date-picker
                                            v-model="add.jssj"
                                            type="date"
                                            placeholder="请选择结束时间">
                                     </el-date-picker>
                                 </el-form-item>
                                 <el-form-item label="人员">
                                      <el-input v-model="add.user" placeholder="请选择人员" @focus="StudentList()"></el-input>
                                 </el-form-item>
                                 
                            </el-form>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="dialogFormVisible=false">取 消</el-button>
                          <el-button type="primary" @click="addPlan()">确 定</el-button>
                        </div>
              </el-dialog>
             
              <el-dialog title="请选择人员信息" :visible.sync="tableListVisibel"
                   width="60%"
                   class="header-left">
                        <el-form :inline="true" :model="formPeople" class="demo-form-inline">
                            <el-form-item label="学院">
                              <el-select v-model="formPeople.xy" placeholder="学院" @change="DicGetZy()" style="width:180px" >
                                <el-option v-for="(item,index) in xylist" :key="index" :label="item.name" :value="item.code" ></el-option>
                              </el-select>
                            </el-form-item>
                            <el-form-item label="专业">
                              <el-select v-model="formPeople.zy" placeholder="专业" @change="DicGetNj()" style="width:180px">
                                <el-option v-for="(item,index) in zyList" :key="index" :label="item.name" :value="item.code"></el-option>
                              </el-select>
                            </el-form-item>
                            <el-form-item label="年级">
                              <el-select v-model="formPeople.nj" placeholder="年级" @change="DicGetbj()" style="width:180px">
                                <el-option v-for="(item,index) in njList" :key="index" :label="item.name" :value="item.code"></el-option>
                              </el-select>
                            </el-form-item>
                            <el-form-item label="班级">
                              <el-select v-model="formPeople.bj" placeholder="班级" style="width:180px" >
                                <el-option v-for="(item,index) in bjList" :key="index" :label="item.name" :value="item.code"></el-option>
                              </el-select>
                            </el-form-item>
                            <el-form-item>
                              <el-button type="primary" @click="onSelect">查询</el-button>
                            </el-form-item>
                        </el-form>
                        <el-table
                            ref="multipleTable"
                            :data="peopleDataList"
                            tooltip-effect="dark"
                            style="width:100%"
                            @selection-change="handleSelectionChange">
                            <el-table-column type="selection" width="100"></el-table-column>
                            <el-table-column prop="realname"  label="姓名"></el-table-column>
                            <el-table-column prop="xb"  label="性别"></el-table-column>
                            <el-table-column prop="xy"  label="学院"></el-table-column>
                            <el-table-column prop="lxdh"  label="联系电话"></el-table-column>
                             <el-table-column prop="zy"  label="专业"></el-table-column>
                            <el-table-column prop="xh"  label="学号"></el-table-column>
                        </el-table>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="tableListVisibel = false">取 消</el-button>
                          <el-button type="primary"  @click="addUser()">确 定</el-button>
                        </div>
              </el-dialog>
               <!-- <el-dialog title="删除信息" :visible.sync="deletecapmus"
                   width="30%"
                   class="header-left">
                       <span>确定要删除此校公寓信息</span>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="deletecapmus = false">取 消</el-button>
                          <el-button type="primary"  :loading="loading">确 定</el-button>
                        </div>
              </el-dialog> -->
               <!-- 
              <el-dialog title="编辑校区" :visible.sync="editVisibel"
                   width="30%"
                   class="header-left">
                        <el-form :inline="true" :model="form" class="demo-form-inline">
                              <el-form-item label="公寓区名称">
                                <el-input v-model="edit.gyname" :disabled="true"></el-input>
                              </el-form-item>
                              <el-form-item label="公寓楼名称">
                                <el-input v-model="edit.name" :disabled="true"></el-input>
                              </el-form-item>
                              <el-form-item label="修改公寓楼名称">
                                <el-input v-model="edit.new_name" placeholder="请输入公寓楼名称"></el-input>
                              </el-form-item>
                          </el-form>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="editVisibel = false">取 消</el-button>
                          <el-button type="primary"  :loading="loading">确 定</el-button>
                        </div>
              </el-dialog>
               -->
          </div>
        </el-main>
      </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { plan,BuildStatusDictionary,CampusDictionary,AllBuildDictionary,studentList,EmptyBed,DicGetS,DicNj,DicBj} from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default {
    data(){
      return{
          tableDataList:[],
          peopleDataList:[],
          page:{
             pageNum:1, 
             pageSize:5,
             startRow:0,
             endRow:0
          },
          add:{
              task_name:'',
              hfgz:'',
              hfbh:'',
              kssj:'',
              jssj:'',
              user:'',
              hfgzSelect:[],
              hfbhSelect:[],
          },
          form:{
            zt:"1",
           
          },
          loading:false,
          dialogFormVisible:false,
          tableListVisibel:false,
          studentForm:{
              lb:'',
              xy:'',
              zy:'',
              nj:'',
              bj:'',
              bedNum:[],
          },
          formPeople:{
            lb:'',
            xy:'',
            zy:'',
            nj:'',
            bj:''
          },
          xylist:[],
          zyList:[],
          njList:[],
          bjList:[],
          
      }  
    },
    methods:{
      onSubmit(){
        this.tableData();
      },
      onSelect(){
        this.StudentList();
      },
      addPlan(){

      },
      handleCurrentChange(val){
        this.page.pageNum = val;
        this.tableData()
      },
      handleSelectionChange(){

      },
      // 列表
      async tableData(){
          this.loading = true;
             var params = {
               pageNum:this.page.pageNum,
               pageSize:this.page.pageSize,
               zt:this.form.zt
             };
            var res = await plan(params);
            if(res.code == 200){
                this.loading = false;
                this.tableDataList = res.data.list;
                this.page.startRow=res.data.startRow;
                this.page.endRow=res.data.endRow;
                this.page.total = res.data.total
            }else{
              this.loading = false;
              this.$message(res.message)
            }
      },
       // 规则列表
      async hfgz(lx){
          this.loading = true;
             var params = {
               lx:lx
             };
            var res = await BuildStatusDictionary(params);
            if(res.code == 200){
              this.add.hfgzSelect = res.data
            }else{
              this.$message(res.message)
            }
      },
      hfgzChange(){
          this.add.hfbhSelect = [];
          this.add.hfbh=''
          if(this.add.hfgz == 1){
               this.apartLou();
          }else{
             this.apart();
          }
      }, 
          // 校区
      async apart(){
             var params = {};
            var res = await CampusDictionary(params);
            if(res.code == 200){
              this.add.hfbhSelect = res.data
            }else{
              this.$message(res.message)
            }
      },
         // 校区
      async apartLou(){
             var params = {};
            var res = await AllBuildDictionary(params);
            if(res.code == 200){
              this.add.hfbhSelect = res.data
            }else{
              this.$message(res.message)
            }
      },
      // 学生列表
      async StudentList(){
          if(!this.add.hfgz || !this.add.hfbh){
              this.$message('请选择划分规则及划分编号')
          }else{
              this.tableListVisibel = true;
             var params = {
                //  lb:this.studentForm.lb,
                 xy:this.studentForm.xy,
                 zy:this.studentForm.zy,
                 nj:this.studentForm.nj,
                 bj:this.studentForm.bj,
             };
            var res = await studentList(params);
            if(res.code == 200){
              this.peopleDataList = res.data;
            }else{
              this.$message(res.message)
            }
          }
            
      },
      // 学生列表
      async bedNum(){
          if(!this.add.hfgz){
              this.$message('请选择划分规则')
          }else{
             var params = {
                 hfgz:this.add.hfgz,
                 hfbh:this.add.hfbh,
             };
            var res = await EmptyBed(params);
            if(res.code == 200){
                console.log(res)
              this.bedNum = res.data;
            }else{
              this.$message(res.message)
            }
          }
            
      },
      hfbhChange(){
          this.bedNum();
      },
      async DicGetXy(){
        var params = {lx:'xy',
                      id:'0'};
        var res = await DicGetS(params);
        if(res.code == 200){
          this.xylist = res.data;
        }else{
          this.$message(res.message);
        }
      },
      async DicGetZy(){
        this.zyList = [];
        var params = {lx:'xy',
                      id:this.formPeople.xy};

        var res = await DicGetS(params);
        console.log(res);
        if(res.code == 200){
          this.zyList = res.data;
        }else{
          this.$message(res.message);
        }
      },
      async DicGetNj(){
        this.njList = [];
        var params = {xy:this.formPeople.xy,
                      zy:this.formPeople.zy
                      };
        var res = await DicNj(params);
        // console.log(res);
        if(res.code == 200){
          this.njList = res.data;
        }else{
          this.$message(res.message);
        }
      },
      async DicGetbj(){
        this.bjList = [];
        var params = {xy:this.formPeople.xy,
                      zy:this.formPeople.zy,
                      nj:this.formPeople.nj,
                      };
        var res = await DicBj(params);
        // console.log(res);
        if(res.code == 200){
          this.bjList = res.data;
        }else{
          this.$message(res.message);
        }
      },

  
    },
    mounted(){
       this.tableData();
       this.hfgz('allocation')
       this.DicGetXy();
    }
}
</script>
<style lang="stylus" scoped>
    
</style>




