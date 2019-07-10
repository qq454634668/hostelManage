<template>
    <div class="page page-menu">
        <el-container>
            <el-main class="padding-0">
                 <div class="content">
                       <el-container>
                            <el-main>
                              <div class="align-left">
                                <el-button type="warning" @click="addRole_model=true"> 添加角色</el-button>
                              </div>
                               <el-table :data="dataList" style="width: 100%">
                                  <el-table-column label="角色"  prop="role_name"></el-table-column>
                                  <el-table-column label="操作" >
                                          <template slot-scope="scope">
                                              <el-button @click="editRole(scope.row.id,scope.row.role_name,scope.row.menu_id)" type="success">修改</el-button>
                                              <el-button @click="delRole(scope.row.id)" type="info">删除</el-button>
                                          </template>
                                  </el-table-column>
                                </el-table>
                            </el-main>
                            <el-footer class="pagination">
                              <span>
                                显示第<em>{{page.startRow}}</em>到第 <em>{{page.endRow}}</em> 条记录，总共 <em>{{page.total}}</em> 条记录
                            </span>
                            <el-pagination @current-change="handleCurrentChange" layout="prev, pager, next,total"
                                :total="page.total" class="right"
                                :page-sizes="[100, 200, 300, 400]"
                                :page-size="5">
                            </el-pagination>
                        </el-footer>

                        <el-dialog title="创建角色" :visible.sync="addRole_model">
                            <el-form :model="addForm">
                              <el-form-item label="角色名称">
                                <el-input v-model="addForm.name" auto-complete="off"></el-input>
                              </el-form-item>
                              <el-form-item label="选择菜单" >
                                 <el-select
                                    v-model="addForm.menu"
                                    :multiple="true"
                                    :multiple-limit="0"
                                    placeholder="请选择文章标签">
                                    <el-option  v-for="(item,index) in dataMenu" :key="index" 
                                      :label="item.name"
                                      :value="item.id">
                                    </el-option>
                                  </el-select>

                              </el-form-item>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                              <el-button @click="addRole_model = false">取 消</el-button>
                              <el-button type="primary" @click="addJs()">确 定</el-button>
                            </div>
                          </el-dialog>
                          <el-dialog title="修改角色" :visible.sync="editRole_model">
                            <el-form :model="addForm">
                              <el-form-item label="角色名称">
                                <el-input v-model="editForm.name" auto-complete="off"></el-input>
                              </el-form-item>
                             <el-form-item label="选择菜单" >
                                 <el-select
                                    v-model="editForm.menu"
                                    :multiple="true"
                                    :multiple-limit="0"
                                    placeholder="请选择文章标签">
                                    <el-option  v-for="(item,index) in dataMenu" :key="index" 
                                      :label="item.name"
                                      :value="item.id">
                                    </el-option>
                                  </el-select>

                              </el-form-item>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                              <el-button @click="editRole_model = false">取 消</el-button>
                              <el-button type="primary" @click="editjs()">确 定</el-button>
                            </div>
                          </el-dialog>
                          <el-dialog title="删除角色" :visible.sync="delRole_model">
                            <!-- <div slot="footer" class="dialog-footer"> -->
                              <el-button @click="delRole_model = false">取 消</el-button>
                              <el-button type="primary" @click="deljs()">确 定</el-button>
                            <!-- </div> -->
                          </el-dialog>
                       </el-container>
                      
                 </div>
            </el-main>
        </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { jquery } from '@/script/jquery-1.7.1';
  import jsgl from '@/script/jsgl.js';
export default{
  ...jsgl
}
</script>
<style lang="stylus" scoped>
    
</style>

