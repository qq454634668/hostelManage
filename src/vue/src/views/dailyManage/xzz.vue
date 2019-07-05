<template>
    <div class="page page-occupancy">
      <el-container>
        <el-main class="padding-0">
          <div class="content">
            <el-container>
                <el-header>
                      <el-form :inline="true" :model="form" class="demo-form-inline left">
                        <el-form-item label>
                            <el-select v-model="form.apart" placeholder="校区" @change="selectChange('apart')">
                                <el-option
                                v-for="(item,index) in form.apartSelect"
                                :key="index"
                                :label="item.name"
                                :value="item.code"
                                ></el-option>
                            </el-select>
                            </el-form-item>
                            <el-form-item label>
                            <el-select
                                v-model="form.district"
                                placeholder="公寓区"
                                @change="selectChange('district')"
                            >
                                <el-option
                                v-for="(item,index) in form.districtSelect"
                                :key="index"
                                :label="item.name"
                                :value="item.code"
                                ></el-option>
                            </el-select>
                            </el-form-item>
                            <el-form-item label>
                            <el-select
                                v-model="form.building"
                                placeholder="选择公寓楼"
                                @change="selectGet"
                                filterable
                            >
                                <el-option
                                v-for="(item,index) in form.buildingSelect"
                                :key="index"
                                :label="item.name"
                                :value="item.code"
                                ></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item>
                        <el-button type="primary" @click="bedList()">查询</el-button>
                        </el-form-item>
                    </el-form>
                </el-header>
                <el-main class="padding-0">
                      <div></div>
                      <div></div>
                      <div></div>
                </el-main>
            </el-container>
          
          </div>
        </el-main>
      </el-container>
    </div>
</template>
<script>
  import { mapMutations } from 'vuex';
  import { BedListMap, AllBuildDictionary, ApartDictionary, CampusDictionary, BuildDictionary } from '@/api';
  import { jquery } from '@/script/jquery-1.7.1';
export default{
  data(){
      return{
         form: {
            apart: '',
            apartSelect: '',
            district: '',
            districtSelect: '',
            building: '',
            buildingSelect: '',
            buildName: ''
        }  
      }
  },
  methods:{
          // 校区
    async apart() {
      var params = {};
      var res = await CampusDictionary(params);
      if (res.code == 200) {
        this.form.apartSelect = res.data;
      } else {
        this.$message(res.message)
      }
    },
    // 公寓区下拉
    async districtPart(code) {
      var params = {
        code: code
      };
      var res = await ApartDictionary(params);
      if (res.code == 200) {
        this.loading = false;
        this.form.districtSelect = res.data;
      } else {
        this.loading = false;
        this.$message(res.message);
        return
      }
    },
    // 公寓楼
    async apartLou(code) {
      var params = {
        code: code
      };
      var res = await BuildDictionary(params);
      if (res.code == 200) {
        this.form.buildingSelect = res.data;
      } else {
        this.$message(res.message)
      }
    },
    // 公寓楼all
    async apartLouAll() {
      var params = {
        code: ''
      };
      var res = await AllBuildDictionary(params);
      if (res.code == 200) {
        this.form.buildingSelect = res.data;
      } else {
        this.$message(res.message)
      }
    },

  },
  mounted(){
    
  }
}
</script>
<style lang="stylus" scoped>      
      
</style>




