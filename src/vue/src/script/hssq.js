import { applyForList,AllBuildDictionary,ApartDictionary,CampusDictionary,BuildDictionary} from '@/api';
export default {
    data(){
      return{
          tableDataList:[],
          peopleDataList:[],
          loading:false,
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
                {name:'申请失败',code:'3'},
            ],
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
      // list
      async tableData(){
          this.loading = true;
           var params = {
            zxzt:this.form.rzsq,
            sqlx:2,
            pageSize:10,
            pageNum:this.page.pageNum
           };
          var res = await applyForList(params);
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