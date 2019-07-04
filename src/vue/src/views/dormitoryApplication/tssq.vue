<template>
    <div class="page page-campus">
      <el-container>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                  <el-form :inline="true" :model="form" class="demo-form-inline left">
                       <!-- <el-form-item label="">
                         <el-select v-model="form.apart" placeholder="校区" @change="selectChange('apart')">
                           <el-option v-for="(item,index) in form.apartSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="">
                         <el-select v-model="form.district" placeholder="公寓区" @change="selectChange('district')">
                           <el-option v-for="(item,index) in form.districtSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="">
                         <el-select v-model="form.building" placeholder="选择公寓楼" >
                           <el-option v-for="(item,index) in form.buildingSelect" :key="index" :label="item.name" :value="item.code"></el-option>
                        </el-select>
                      </el-form-item> -->
                       <el-form-item label="">
                         <el-select v-model="form.rzsq" placeholder="申请状态" >
                           <el-option v-for="(item,index) in form.rzsqSelect" :key="index" :label="item.name" :value="item.code"></el-option>
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
                        <el-table-column prop="task_name"  label="姓名" > </el-table-column>
                        <el-table-column  prop="hfgz"  label="学号"> </el-table-column>
                        <el-table-column  prop="hfbh" label="申请流程"> </el-table-column>
                        <el-table-column  prop="rwbh" label="联系方式"> </el-table-column>
                        <el-table-column  prop="kssj" label="申请时间"> </el-table-column>
                        <el-table-column  prop="jssj"  label="审批状态">   </el-table-column>
                        <el-table-column  prop="jssj"  label="审批结果">   </el-table-column>
                      <el-table-column label="操作">
                            <template slot-scope="scope">
                              <el-button  size="mini"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                              <el-button size="mini"
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
          
          </div>
        </el-main>
      </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { jquery } from '@/script/jquery-1.7.1';
  import tssq from '@/script/tssq.js';
export default{
  ...tssq
}
</script>
<style lang="stylus" scoped>
    
</style>




