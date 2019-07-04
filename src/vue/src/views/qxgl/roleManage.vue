<template>
    <div class="page page-menu">
        <el-container>
            <el-main class="padding-0">
                 <div class="content">
                       <el-container>
                                <el-main></el-main>
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

