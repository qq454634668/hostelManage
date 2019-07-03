<template>
    <div class="page page-campus">
      <el-container>
        <el-header class="listName" height="40px">
          <h3 class="left">{{$route.meta.breadcrumb}}<span>列表</span></h3>
          <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>{{$route.meta.breadcrumbparent}}</el-breadcrumb-item>
              <el-breadcrumb-item>{{$route.meta.breadcrumb}}</el-breadcrumb-item>
            </el-breadcrumb>
        </el-header>
         <el-main>
           <router-view></router-view>
         </el-main>
      </el-container>
      
      
    </div>
</template>
<script>

export default {
    data(){
      return{

      }  
    },
    methods:{

    },
    mounted(){
    }
}
</script>
<style lang="stylus" scoped>
    .page-campus{
      .listName{
        line-height:40px;
         .el-breadcrumb{
           float:right;
           line-height:40px;
         } 
      }
    }
</style>




