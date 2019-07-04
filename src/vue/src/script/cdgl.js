import { QueryMenu,EditMenu} from '@/api';
export default {
    data(){
      return{
          tableDataList:[],
          dataList:[],
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
          },
          editform:{
            name:'',
            url:'',
            px:'',
            id:'',
            icon:'',
          },
          dialogFormVisible:false,
        
          
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
      edit(item){
        this.editform.id = item.id;
        this.editform.name=item.name;
        this.editform.px=item.px;
        this.editform.icon = item.icon;
        this.editform.url = item.url;
        this.dialogFormVisible = true
      },
      async addFunction(){
          var params = this.editform;
          var res = await EditMenu(params);
          if(res.code == 200){
            console.log(res)
          }else{
            this.$message(res.message)
          }

      },
      // list
      async tableData(){
          this.loading = true;
           var params = {};
          var res = await QueryMenu(params);
          if(res.code == 200){
              this.loading = false;
              this.dataList= res.data;
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