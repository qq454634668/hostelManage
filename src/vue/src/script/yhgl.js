import { applyForList,QueryUserList} from '@/api';
export default {
    data(){
      return{
          tableDataList:[],
          peopleDataList:[],
          loading:false,
          rzsq_cz:false,
          page:{
             pageNum:1, 
             pageSize:5,
             startRow:0,
             endRow:0
          },
          form:{
            apart:'',
            apartSelect:'',
            district:'',
            districtSelect:'',
            building:'',
            buildingSelect:'',
            rzsq:'',
            rzsqSelect:[
                {name:'申请中',code:'1'},
                {name:'申请成功',code:'2'},
                {name:'申请失败',code:'3'}
            ],
            key:'',
          }
        
          
      }  
    },
    methods:{
      onSubmit(){
        this.tableData();
      },
      handleCurrentChange(val){
        this.page.pageNum = val;
        this.tableData();
      },
      handleSelectionChange(){

      },
      selectChange(apart){
           if(apart == 'apart'){
               this.form.district="";
               this.form.districtSelect = [];
               this.form.building="";
               this.form.buildingSelect = [];
               this.districtPart(this.form.apart);
               
           }else if(apart == "district"){
                this.form.building="";
                this.apartLou(this.form.district)
           }
      }, 
      //审批通过
      sptg(){
        var param={
                
              }
      },
      //审批不通过
      spbtg(){
        var param={
        }
      },
      // list
      async tableData(){
          this.loading = true;
           var params = {
            key:this.form.key,
            pageSize:10,
            pageNum:this.page.pageNum
           };
          var res = await QueryUserList(params);
          if(res.code == 200){
              this.loading = false;
              this.tableDataList = res.data.list;
              this.startRow = res.data.isFirstPage;
              this.endRow = res.data.isLastPage;
              console.log(res)
          }else{
            this.loading = false;
            this.$message(res.message)
          }
    }, 



     
  
    },
    mounted(){
       this.tableData();
    }
}