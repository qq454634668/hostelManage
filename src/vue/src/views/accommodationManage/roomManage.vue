<template>
    <div class="page page-campus">
      <el-container>
        <el-header class="listName">
          <h3 class="left">房间管理<span>列表</span></h3>
        </el-header>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                  <el-form :inline="true" :model="form" class="demo-form-inline left">
                      <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
                      <el-form-item>
                         <el-select v-model="form.scroolPart" placeholder="校区" @change="selectChange('init')">
                           <el-option v-for="(item,index) in xqzdSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item>
                        <el-select v-model="form.gybh" placeholder="请选择公寓区" @change="gybhChange('init')">
                           <el-option v-for="(item,index) in apartSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                        <el-form-item>
                          <el-select v-model="form.loubh" placeholder="请选择楼编号" @change="gylbhChange('init')">
                              <el-option v-for="(item,index) in louSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                         </el-select>
                        </el-form-item>
                         <el-form-item>
                           <el-select v-model="form.fjbh" placeholder="请选择房间编号">
                              <el-option v-for="(item,index) in roomSelect" :key="index" :label="item.name" :value="item.code"></el-option>
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
                          prop="louname"
                          label="公寓楼名称">
                        </el-table-column>
                        <el-table-column
                          prop="loubh"
                          label="公寓楼编号">
                        </el-table-column>
                        <el-table-column
                          prop="louztname"
                          label="宿舍类别">
                        </el-table-column>
                        <el-table-column
                          prop="bh"
                          label="编码">
                        </el-table-column>
                        <el-table-column
                          prop="fjbh"
                          label="房间编号">
                        </el-table-column>
                        <el-table-column
                          prop="fjbzname"
                          label="房间类别">
                        </el-table-column>
                      <!-- <el-table-column label="操作">
                            <template slot-scope="scope">
                              <el-button
                                size="mini"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                              <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                            </template>
                        </el-table-column> -->
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
                        <el-form label-position="right" label-width="120px" :model="addForm">
                                <el-form-item label="校区">
                                      <el-select v-model="addForm.scroolPart" placeholder="校区" @change="selectChange('add')">
                                          <el-option v-for="(item,index) in xqzdSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                                      </el-select>
                                </el-form-item>
                                 <el-form-item label="公寓区">
                                  <el-select v-model="addForm.gybh" placeholder="请选择公寓区" @change="gybhChange('add')">
                                    <el-option v-for="(item,index) in addApartSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                                  </el-select>
                                 </el-form-item>
                                 <el-form-item label="公寓楼编号">
                                      <el-select v-model="addForm.loubh" placeholder="请选择公寓楼编号">
                                         <el-option v-for="(item,index) in addLou" :key="index" :label="item.name" :value="item.code"></el-option>
                                      </el-select>
                                 </el-form-item>
                                 <el-form-item label="房间编号" >
                                   <el-input v-model="addForm.fjbh" placeholder="请选择房间编号" @change="repeat()"></el-input>
                                 </el-form-item>
                                 <el-form-item label="房间标准">
                                      <el-select v-model="addForm.fjbz" placeholder="请选择房间标准">
                                         <el-option v-for="(item,index) in fjbz" :key="index" :label="item.name" :value="item.code"></el-option>
                                      </el-select>
                                 </el-form-item>
                                 
                            </el-form>
                        <div slot="footer" class="dialog-footer">
                          <el-button @click="dialogFormVisible = false">取 消</el-button>
                          <el-button type="primary" @click="roomAdd()">确 定</el-button>
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
  import { CampusDictionary,ApartDictionary,BuildDictionary,
  RoomDictionary,BuildStatusDictionary,QueryRoomList,
  AddRoom,repeatRoom,ExistRoomRz,EditRoom,DelRoom,StopRoom,} from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default {
    data(){
      return{
        form:{
          word:'',
          name:'',
          scroolPart:'',
          gybh:'',
          loubh:'',
          fjbh:''
        },
    //     * name  楼名
    //  * louzt  楼状态
    //  * xqbh  校区编号
    //  * gybh  公寓编号
        addForm:{
          xqbh:'',
          name:'',
          gybh:'',
          louzt:'',
          scroolPart:'',
          loubh:'',
          fjbh:'',
          fjbz:''
        },
        tableDataList:[],
        dialogFormVisible:false,
        deletecapmus:false,
        editVisibel:false,
        loading:false,
        xqbh:'',
        add:false,
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
          gyname:''
        },
        xqzdSelect:[],
        apartSelect:[],
        addApartSelect:[],
        louSelect:[],
        addLou:[],
        roomSelect:[],
        addRoomSelect:[],
        fjbz:[],

      }  
    },
    methods:{
      onSubmit(){
        this.tableData();
      },
      handleSizeChange(val){

      },
      handleCurrentChange(val){
        this.page.pageNum = val;
        this.tableData()
      },
      handleEdit(index,row){
        this.editVisibel=true;
        this.edit.id= row.id;
        this.edit.name = row.name;
        this.edit.gyname = row.gyname;
      },
      handleDelete(index,row){
        console.log(row.id);
        this.id = row.id;
        this.bh = row.fjbh;
        this.deletecapmus=true;
      },
      deletexx(){
        this.loading=true;
        this.ifPart();
      },
      // 增加验证规则
      addyzgz(){
        if(!this.add.xqbh){
            this.$message('校区不能为空');
            return
        }else if(!this.add.name){
            this.$message('校区不能为空');
            return
        }else if(!this.add.louzt){
          this.$message('校区不能为空');
            return
        }else if(!this.add.gybh){
          this.$message('校区不能为空');
            return
        }else{
          return true
        }
      },
      campusAdd(){
        if(addyzgz){
          this.tableadd()
        }
      },
      // 列表
      async tableData(){
          this.loading = true;
             var params = {
               pageNum:this.page.pageNum,
               pageSize:this.page.pageSize,
               xqbh:this.form.scroolPart,
               gybh:this.form.gybh,
               loubh:this.form.loubh,
               fjbh:this.form.fjbh,
             };
            var res = await QueryRoomList(params);
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
      selectChange(style){
       this.xqzdApart(style);
      },
      louChange(add){
        this.statusApart(add)
      },
      gybhChange(add){
        this.floorBh(add);
      },
      gylbhChange(add){
          this.roomBh(add)
      },
      // 判断删除
      async ifPart(){
             var params = {
              fjbh:this.bh
             };
            var res = await StopRoom(params);
            if(res.code == 200){
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
      // 修改
      async tableEdit(){
        if(this.edit.new_name){
        var params = {
               id:this.edit.id,
               name:this.edit.new_name
             };
            var res = await EditRoom(params);
            if(res.code == 200){
              this.$message('修改成功');
              this.editVisibel = false
              this.loading = false;
              this.tableData();
            }
        }else{
          this.loading = false;
          this.$message('公寓楼名称不能为空');
        }
             
      },
      async tableDelete(id){
             var params = {
               id:id
             };
            var res = await DelRoom(params);
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
      // 校区下拉
      async xqzd(){
              var params = {};
              var res = await CampusDictionary(params);
              if(res.code == 200){
                this.xqzdSelect = res.data;
              }else{
                this.$message(res.message);
              }
      },
      // 公寓下拉
      async xqzdApart(jsdz){
        var cs='';
        if(jsdz == 'init'){
          cs =this.form.scroolPart
        }else{
          cs =this.addForm.scroolPart
        }
        
            var params = {
              code:cs
            };
            var res = await ApartDictionary(params);
            if(res.code == 200){
              this.loading = false;
              this.form.gybh='';
              this.addForm.gybh='';
              if(jsdz == 'init'){
                this.apartSelect =  res.data; 
              }else if(jsdz == 'add'){
                  this.addApartSelect = res.data;
              }
               
            }else{
              this.loading = false;
              this.$message(res.message);
              return 
            }
      },
      // 房间标准下拉
      async statusApart(){
            var params = {lx:'room'};
            var res = await BuildStatusDictionary(params);
            if(res.code == 200){
                this.fjbz = res.data;
            }else{
              this.$message(res.message);
            }
      },
       // 楼编号下拉
      async floorBh(code){
        var cs = "";
            if(code == "init"){
              cs = this.form.gybh;
            }else{
              cs = this.addForm.gybh;
            };
            var params = {code:cs};
            var res = await BuildDictionary(params);
            if(res.code == 200){
              if(code == "init"){
                 this.louSelect = res.data;
                }else{
                 this.addLou = res.data;
                };
                
            }else{
              this.$message(res.message);
            }
      },
       // 房间编号下拉
      async roomBh(code){
           var cs = "";
           if(code == "init"){
              cs = this.form.loubh;
            }else{
              cs = this.addForm.loubh;
            };
            var params = {code:cs};
            var res = await RoomDictionary(params);
            console.log(res);
            if(res.code == 200){
              if(code == "init"){
               this.roomSelect = res.data;
              }else{
                 this.addRoomSelect = res.data;
              };
                
            }else{
              this.$message(res.message);
            }
      },
       // 房间编号下拉
      async repeat(){
            var params = {
                        loubh:this.addForm.loubh,
                        fjbh:this.addForm.fjbh,
                      };
            var res = await repeatRoom(params);
            if(res.code == 200){
                if(res.data == 0){
                  this.statusApart();
                }
                
            }else{
              this.$message(res.message);
            }
      },
      // 添加
      async roomAdd(){
            var params = {
              fjbh:this.addForm.fjbh,
              loubh:this.addForm.loubh,
              xqbh:this.addForm.scroolPart,
              gybh:this.addForm.gybh,
              fjbz:this.addForm.fjbz,

            };
            var res = await AddRoom(params);
            if(res.code == 200){
               this.$message(res.message);
                this.dialogFormVisible=false;
                 this.tableData();
            }else{
              this.$message(res.message);
            }
      },
    },
    mounted(){
        this.xqzd();
       this.tableData();
      //  this.statusApart()
    }
}
</script>
<style lang="stylus" scoped>
    
</style>




