<template>
    <div class="page page-menu">
        <el-container>
            <el-main class="padding-0">
                 <div class="content">
                       <el-container>
                              <el-header>
                                <el-form :inline="true" :model="form" class="demo-form-inline left">
                                    <el-form-item label="">
                                        <el-input  v-model="form.key"></el-input>
                                    </el-form-item>
                                    <el-form-item>
                                      <el-button type="primary" @click="tableData()">查询</el-button>
                                    </el-form-item>
                                </el-form>
                              </el-header>
                                <el-main>
                                  <el-table
                                    :data="tableDataList"
                                    max-height="300px"
                                    border
                                    style="width: 100%"
                                    v-loading="loading">
                                      <el-table-column prop="username"  label="用户名" > </el-table-column>
                                      <el-table-column  prop="realname"  label="真实姓名"> </el-table-column>
                                      <el-table-column  prop="lxdh" label="联系电话"> </el-table-column>
                                      <el-table-column  prop="nj" label="年级"> </el-table-column>
                                      <el-table-column  prop="xy"  label="学院">   </el-table-column>
                                      <el-table-column  prop="role_name"  label="权限">   </el-table-column>
                                      <el-table-column label="操作" width="300">
                                          <template slot-scope="scope">
                                            <el-button  size="mini"
                                              @click="editUser(scope.$index, scope.row.id,scope.row.realname,scope.row.lxdh,scope.row.xycode)">修改信息
                                            </el-button>
                                            <el-button  size="mini"
                                              @click="editRole(scope.$index, scope.row.id,scope.xy.role_id)">修改权限
                                            </el-button>
                                            <el-button  size="mini"
                                              @click="del(scope.$index, scope.row.id)">删除用户
                                            </el-button>
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
                      
                 </div>
                  <el-dialog
                    title="修改信息--操作"
                    :visible.sync="editUser_model"
                    width="30%" class="align-left">
                    <div>   
                      <span>真实姓名:</span><el-input v-model="form.realname"></el-input>
                      <span>联系电话:</span><el-input v-model="form.lxdh"></el-input>
                      <span>学院:</span><el-input v-model="form.xy"></el-input>
                    </div>
                  <span slot="footer" class="dialog-footer">
                      <el-button @click="editUser_model =false">取 消</el-button>
                      <el-button type="primary" @click="editUser_submit()">确定</el-button>
                  </span>
              </el-dialog>
            </el-main>
        </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { jquery } from '@/script/jquery-1.7.1';
  import cdgl from '@/script/yhgl.js';
export default{
  ...cdgl
}
</script>
<style lang="stylus" scoped>
    
</style>

