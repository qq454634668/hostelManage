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
                        <el-table-column prop="sqrxm"  label="姓名" > </el-table-column>
                        <el-table-column  prop="sqrxh"  label="学号"> </el-table-column>
                        <el-table-column  prop="sqcwbh" label="申请床位编号"> </el-table-column>
                        <el-table-column  prop="ycwbh"  label="原床位编号">   </el-table-column>
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
          <el-dialog
          title="换宿申请--操作"
          :visible.sync="rzsq_cz"
          width="30%" class="align-left">
          <div>   
              <span>处置结果原因:</span><el-input v-model="form.zxjgyy"></el-input>
          </div>
          <span slot="footer" class="dialog-footer">
              <el-button @click="rzsq_cz =false">取 消</el-button>
              <el-button type="primary" @click="sptg()">审批通过</el-button>
              <el-button type="primary" @click="spbtg()">审批不通过</el-button>
          </span>
        </el-dialog>
        </el-main>
      </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { jquery } from '@/script/jquery-1.7.1';
  import hssq from '@/script/hssq.js';
export default{
  ...hssq
}
</script>
<style lang="stylus" scoped>
    
</style>




