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
                                      <el-table-column prop="sqrxm"  label="姓名" > </el-table-column>
                                      <el-table-column  prop="sqrxh"  label="学号"> </el-table-column>
                                      <el-table-column  prop="sqcwbh" label="申请床位编号"> </el-table-column>
                                      <!-- <el-table-column  prop="ycwbh"  label="原床位编号">   </el-table-column> -->
                                      <el-table-column  prop="zxzt" label="执行状态"> </el-table-column>
                                      <el-table-column  prop="sqyy"  label="申请原因">   </el-table-column>
                                      <el-table-column  prop="sqsj"  label="申请时间">   </el-table-column>
                                      <el-table-column  prop="zxjgyy"  label="执行结果原因">   </el-table-column>
                                      <el-table-column  prop="spsj"  label="审批时间">   </el-table-column>
                                    <el-table-column label="操作">
                                          <template slot-scope="scope">
                                            <el-button  size="mini"
                                              @click="cz(scope.$index, scope.row.id,scope.row.sqrxh,scope.row.ycwbh,scope.row.sqcwbh,scope.row.sqlx_code)">操作</el-button>
                                            <!-- <el-button size="mini"
                                              type="danger"
                                              @click="handleDelete(scope.$index, scope.row)">不同意</el-button> -->
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
            </el-main>
        </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { jquery } from '@/script/jquery-1.7.1';
  import cdgl from '@/script/cdgl.js';
export default{
  ...cdgl
}
</script>
<style lang="stylus" scoped>
    
</style>

