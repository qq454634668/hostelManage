<template>
    <div class="page page-campus">
      <el-container>
       
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                  <el-form :inline="true" :model="form" class="demo-form-inline left">
                      <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
                      <!-- <el-form-item label="">
                        <el-input v-model="form.word" placeholder="请输入关键字"></el-input>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="onSubmit">查询</el-button>
                      </el-form-item> -->
                  </el-form>
                </el-header>
                <el-main class="border padding-0">
                   <el-table
                      :data="tableDataList"
                      max-height="300px"
                      border
                      style="width: 100%">
                        <el-table-column
                          prop="louname"
                          label="校区名称"
                          >
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
                      layout="prev, pager, next"
                      :total="page.total" class="right">
                    </el-pagination>
                </el-footer>
            </el-container>
            <el-dialog title="新增校区" :visible.sync="dialogFormVisible"
                   width="30%"
                   class="header-left">
                        <el-form :inline="true" :model="form" class="demo-form-inline">
                              <el-form-item label="校区名称">
                                <el-input v-model="form.name" placeholder="请输入校区名称"></el-input>
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
                       <span>确定要删除此校区信息</span>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="deletecapmus = false">取 消</el-button>
                          <el-button type="primary" @click="deletexx()" :loading="loading">确 定</el-button>
                        </div>
              </el-dialog>
              <el-dialog title="编辑校区" :visible.sync="editVisibel"
                   width="30%"
                   class="header-left">
                        <el-form :inline="true" :model="form" class="demo-form-inline">
                              <el-form-item label="原校区名称">
                                <el-input v-model="edit.name" :disabled="true"></el-input>
                              </el-form-item>
                              <el-form-item label="新校区名称">
                                <el-input v-model="edit.new_name" placeholder="请输入新校区名称"></el-input>
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
  import { campusList,campusadd,campusEdit,campusDelete,ifHasPart} from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default {
    data(){
      return{
        form:{
          word:'',
          name:'',
        },
         tableDataList:[
            
        ],
        dialogFormVisible:false,
        deletecapmus:false,
        editVisibel:false,
        loading:false,
        page:{
          startRow:0,
          endRow:0,
          firstPage:1,
          total:0,
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
        }
      }  
    },
    methods:{
      handleSizeChange(){

      },
      // 翻页
      handleCurrentChange(val){
        this.pageNum = val;
        this.tableData()
      },
      // 修改
      handleEdit(index,row){
        this.editVisibel=true;
        this.edit.id= row.id;
        this.edit.name = row.louname;
      },
      // 删除
      handleDelete(index,row){
        console.log(row.id);
        this.id = row.id;
        this.bh = row.bh;
        this.deletecapmus=true;
      },
      // 删除判断
      deletexx(){
        this.loading=true;
        this.ifPart();
      },
      // 添加
      campusAdd(){
        if(!this.form.name){
          this.$message('校区名称不能为空');
        }else{
          this.tableadd()
        }
      },
      // 表格list
      async tableData(){
             var params = {
               pageNum:this.page.pageNum,
               pageSize:this.page.pageSize,
             };
            var res = await campusList(params);
            if(res.code == 200){
                this.tableDataList = res.data.list;
                this.page.startRow=res.data.startRow;
                this.page.endRow=res.data.endRow;
            }
      },
      // 添加方法
      async tableadd(){
             var params = {
              name:this.form.name
             };
            var res = await campusadd(params);
            if(res.code == 200){
              this.$message(res.message);
              this.dialogFormVisible=false;
              this.tableData();
            }else{
              this.$message(res.message);
            }
      },
      // 判断是否可删除
      async ifPart(){
             var params = {
              bh:this.bh
             };
            var res = await ifHasPart(params);
            if(res.code == 200){
              if(res.data == 0){
                 this.tableDelete(this.id);
              }else{
              this.$message('此校区公寓已分配,不能删除');
              this.deletecapmus = false
              }
             
              
            }else{
              this.$message(res.message);
               this.loading=false;
            }
      },
      // 修改方法
      async tableEdit(){
             var params = {
               id:this.edit.id,
               name:this.edit.new_name
             };
            var res = await campusEdit(params);
            if(res.code == 200){
              this.$message('修改成功');
              this.editVisibel = false
              this.loading = false;
              this.tableData();
            }
      },
      // 删除
      async tableDelete(id){
             var params = {
               id:id
             };
            var res = await campusDelete(params);
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
      }

    },
    mounted(){
        this.tableData();
    }
}
</script>
<style lang="stylus" scoped>
    
</style>




