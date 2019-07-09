<template>
    <div class="page page-menu">
        <el-container>
            <el-main class="padding-0">
                 <div class="content">
                       <el-container>
                              <el-header>
                                <el-form :inline="true" :model="form" class="demo-form-inline left">
                                    <el-button type="primary" @click="addUser()">新增</el-button>
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
                                      <el-table-column  prop="nj" label="学级"> </el-table-column>
                                      <el-table-column  prop="xy"  label="学院">   </el-table-column>
                                      <el-table-column  prop="role_name"  label="权限">   </el-table-column>
                                      <el-table-column label="操作" width="300">
                                          <template slot-scope="scope">
                                            <el-button  size="mini"
                                              @click="editUser(scope.$index, scope.row.id,scope.row.realname,scope.row.lxdh,scope.row.xycode,scope.row.nj)">修改信息
                                            </el-button>
                                            <el-button  size="mini"
                                              @click="editRole(scope.$index,scope.row.id,scope.row.role_id)">修改权限
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
                      <span>学院选择:</span>
                      <el-select v-model="form.xy" placeholder="学院">
                        <!-- <el-option label="全部" value=""></el-option> -->
                        <el-option v-for="(item,index) in xyList" :key="index" :label="item.name" :value="item.code"></el-option>
                      </el-select>
                      <span>学级:</span><el-input v-model="form.xj"></el-input>
                    </div>
                  <span slot="footer" class="dialog-footer">
                      <el-button @click="editUser_model =false">取 消</el-button>
                      <el-button type="primary" @click="editUser_submit()">确定</el-button>
                  </span>
                  </el-dialog>
                <el-dialog
                    title="修改权限--操作"
                    :visible.sync="editRole_model"
                    width="30%" class="align-left">
                    <div>
                      <span>权限选择:</span>
                      <el-select v-model="form.role_id" placeholder="权限">
                        <el-option v-for="(item,index) in roleList" :key="index" :label="item.role_name" :value="item.id"></el-option>
                      </el-select>
                    </div>
                  <span slot="footer" class="dialog-footer">
                      <el-button @click="editRole_model =false">取 消</el-button>
                      <el-button type="primary" @click="editRole_submit()">确定</el-button>
                  </span>
              </el-dialog>
              <el-dialog
                    title="删除用户--操作"
                    :visible.sync="del_model"
                    width="30%" class="align-left">
                  <span slot="footer" class="dialog-footer">
                      <el-button @click="del_model =false">取 消</el-button>
                      <el-button type="primary" @click="del_submit()">确定</el-button>
                  </span>
              </el-dialog>
              <el-dialog
                    title="新增用户--操作"
                    :visible.sync="add_model"
                    width="30%" class="align-left">
                    <div>
                      <span>用户名:</span><el-input v-model="form.username"></el-input>
                      <span>密  码:</span><el-input v-model="form.password"></el-input>
                      <span>真实姓名:</span><el-input v-model="form.realname"></el-input>
                      <span>联系电话:</span><el-input v-model="form.lxdh"></el-input>
                      <span>学院选择:</span>
                      <el-select v-model="form.xy" placeholder="学院">
                        <el-option v-for="(item,index) in xyList" :key="index" :label="item.name" :value="item.code"></el-option>
                      </el-select>
                      <span>学级:</span><el-input v-model="form.xj"></el-input>
                    </div>
                  <span slot="footer" class="dialog-footer">
                      <el-button @click="add_model =false">取 消</el-button>
                      <el-button type="primary" @click="addUser_submit()">确定</el-button>
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

