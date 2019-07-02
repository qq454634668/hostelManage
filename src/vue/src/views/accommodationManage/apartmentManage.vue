<template>
    <div class="page page-campus">
      <el-container>
        <el-header class="listName">
          <h3 class="left">公寓区管理<span>列表</span></h3>
        </el-header>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                  <el-form :inline="true" :model="form" class="demo-form-inline left">
                      <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
                      <el-form-item>
                         <el-select v-model="form.scroolPart" placeholder="校区">
                           <el-option label="全部" value=""></el-option>
                           <el-option v-for="(item,index) in xqzdSelect" :key="index" :label="item.name" :value="item.code"></el-option>
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
                          prop="xqname"
                          label="校区名称"
                          >
                        </el-table-column>
                        <el-table-column
                          prop="gyname"
                          label="公寓区">
                        </el-table-column>
                        <el-table-column
                          prop="bh"
                          label="编码">
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
                      @size-change="handleSizeChange"
                      @current-change="handleCurrentChange"
                      layout="prev, pager, next,total"
                      :total="page.total" class="right"
                      :page-sizes="[100, 200, 300, 400]"
                      :page-size="5">
                    </el-pagination>
                </el-footer>
            </el-container>
            <el-dialog title="新增公寓区" :visible.sync="dialogFormVisible"
                   width="30%"
                   class="header-left">
                        <el-form label-position="right" label-width="80px" :model="add">
                                    <el-form-item label="选择校区">
                                     <el-select v-model="add.xqbh" placeholder="校区">
                                          <el-option v-for="(item,index) in xqzdSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                                      </el-select>
                                    </el-form-item>
                                    <el-form-item label="公寓名称">
                                      <el-input v-model="add.name"></el-input>
                                    </el-form-item>
                            </el-form>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="dialogFormVisible = false">取 消</el-button>
                          <el-button type="primary" @click="campusAdd()">确 定</el-button>
                        </div>
              </el-dialog>
              <el-dialog title="删除信息" :visible.sync="deletecapmus"
                   width="30%"
                   class="header-left">
                       <span>确定要删除此校公寓信息</span>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="deletecapmus = false">取 消</el-button>
                          <el-button type="primary" @click="deletexx()" :loading="loading">确 定</el-button>
                        </div>
              </el-dialog>
              <el-dialog title="编辑校区" :visible.sync="editVisibel"
                   width="30%"
                   class="header-left">
                        <el-form :inline="true" :model="form" class="demo-form-inline">
                              <el-form-item label="原公寓名称">
                                <el-input v-model="edit.name" :disabled="true"></el-input>
                              </el-form-item>
                              <el-form-item label="新公寓名称">
                                <el-input v-model="edit.new_name" placeholder="请输入新公寓名称"></el-input>
                              </el-form-item>
                          </el-form>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="editVisibel = false">取 消</el-button>
                          <el-button type="primary" @click="tableEdit()" :loading="loading">确 定</el-button>
                        </div>
              </el-dialog>
              
          </div>
        </el-main>
      </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { CampusDictionary,ApartmentList,BuildStatusDictionary,ApartmentAdd,ApartmentEdit,ApartmentDelete,ifBuild} from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default {
    data(){
      return{
        form:{
          word:'',
          name:'',
          scroolPart:'',
        },
        add:{
          xqbh:'',
          name:'',
        },
        tableDataList:[],
        dialogFormVisible:false,
        deletecapmus:false,
        editVisibel:false,
        loading:false,
        xqbh:'',
        page:{
          startRow:0,
          endRow:0,
          firstPage:1,
          total:10,
          pageNum:1,
          pageSize:5,
        },
        currentPage:1,
        id:'',
        bh:'',
        edit:{
          id:'',
          name:'',
          new_name:'',
        },
        xqzdSelect:[]
      }  
    },
    methods:{
      onSubmit(){
        this.tableData();
      },
      handleSizeChange(){

      },
      handleCurrentChange(val){
        this.page.pageNum = val;
        this.tableData()
      },
      handleEdit(index,row){
        this.editVisibel=true;
        this.edit.id= row.id;
        this.edit.name = row.gyname;
        console.log(row)
      },
      handleDelete(index,row){
        console.log(row.id);
        this.id = row.id;
        this.bh = row.bh;
        this.deletecapmus=true;
      },
      deletexx(){
        this.loading=true;
        this.ifPart();
      },
      campusAdd(){
        if(!this.add.name){
          this.$message('公寓名称不能为空');
        }else{
          this.tableadd()
        }
      },
      // 列表
      async tableData(){
        this.loading = true;
             var params = {
               pageNum:this.page.pageNum,
               pageSize:this.page.pageSize,
               xqbh:this.form.scroolPart
             };
            var res = await ApartmentList(params);
            if(res.code == 200){
              console.log(res)
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
      // 添加
      async tableadd(){
             var params = {
               xqbh:this.add.xqbh,
               name:this.add.name
             };
            var res = await ApartmentAdd(params);
            if(res.code == 200){
              console.log(res)
              this.$message(res.message);
              this.dialogFormVisible=false;
              this.tableData();
            }else{
              this.$message(res.message);
            }
      },
      // 判断删除
      async ifPart(){
             var params = {
              gybh:this.bh
             };
            var res = await ifBuild(params);
            if(res.code == 200){
               console.log(res)
              if(res.data == 0){
                 this.tableDelete(this.id);
              }else{
                  this.$message('此校区公寓下有楼栋，不能删除');
                  this.loading = false;
                  this.deletecapmus = false;
              }
             
              
            }else{
              this.$message(res.message);
               this.loading=false;
            }
      },
      // 公寓区修改
      async tableEdit(){
             var params = {
               id:this.edit.id,
               name:this.edit.new_name
             };
            var res = await ApartmentEdit(params);
            if(res.code == 200){
              this.$message('修改成功');
              this.editVisibel = false
              this.loading = false;
              this.tableData();
            }
      },
      async tableDelete(id){
             var params = {
               id:id
             };
            var res = await ApartmentDelete(params);
            console.log(res)
            if(res.code == 200){

              this.$message('删除成功');
              this.deletecapmus = false;
              this.tableData();
              this.loading=false;
            }else{
              this.$message(res.message);
              this.loading=false;
            }
      },
      async xqzd(){
              var params = {};
              var res = await CampusDictionary(params);
              console.log(res)
              if(res.code == 200){
                  this.xqzdSelect = res.data;
              }else{
                this.$message(res.message);
              }
        }
    },
    mounted(){
        this.tableData();
        this.xqzd()
    }
}
</script>
<style lang="stylus" scoped>
    
</style>




