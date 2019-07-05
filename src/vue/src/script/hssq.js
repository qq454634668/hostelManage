import { applyForList,AllBuildDictionary,ApartDictionary,CampusDictionary,BuildDictionary,verifyAsk} from '@/api';
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
                {name:'申请失败',code:'3'}
            ],
            zxjgyy:'',//执行结果原因
            id:'', //编辑操作id
            sqrxh:'', //申请人学号
            ycwbh:'', //原床位编号
            sqcwbh:'',//申请床位编号
            sqlx:'',//申请类型
          },
          rzsq_cz:false,
        
          
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
      }, //操作
      cz(index,id,sqrxh,ycwbh,sqcwbh,sqlx){
        this.rzsq_cz = true;
        this.form.id=id;
        this.form.sqrxh=sqrxh;
        this.form.ycwbh=ycwbh;
        this.form.sqcwbh=sqcwbh;
        this.form.sqlx=sqlx;
      },
      //审批通过
      sptg(){
        if(this.form.zxjgyy==null || this.form.zxjgyy==""){
          this.$message("处置结果原因不能为空");
          return;
        }
        var param={
                id:this.form.id,
                sqrxh:this.form.sqrxh,
                ycwbh:this.form.ycwbh,
                sqcwbh:this.form.sqcwbh,
                sqlx:this.form.sqlx,
                zxzt:'2',
                zxjgyy:this.form.zxjgyy
              }
        this.verify_Ask(param);
        this.tableData(param);
      },
      //审批不通过
      spbtg(){
        if(this.form.zxjgyy==null || this.form.zxjgyy==""){
          this.$message("处置结果原因不能为空");
          return;
        }
        var param={
          id:this.form.id,
          zxzt:'3',
          zxjgyy:this.form.zxjgyy
        }
        this.verify_Ask(param);
        this.tableData(param);
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
                // console.log(res)
          }else{
            this.loading = false;
            this.$message(res.message)
          }
    },   
    // 审批申请-----同意/不同意申请
    async verify_Ask(param){
        var params = param;
        let res = await verifyAsk(params);
        if(res.code == 200){
          this.rzsq_cz = false;
          this.$message(res.message);
        }else{
          this.$message(res.message);
        }
    },


     
  
    },
    mounted(){
       this.tableData();
   
    }
}