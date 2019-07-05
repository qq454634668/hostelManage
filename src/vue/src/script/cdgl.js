import { QueryMenu,EditMenu,AddMenu,DeleteMenu} from '@/api';
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
          addform:{
            name:'',
            url:'',
            px:'',
            parent_id:0,
            icon:'',
          },
          dialogFormVisible:false,
          dialogAdd:false,    
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
          var params = this.addform;
          var res = await AddMenu(params);
          if(res.code == 200){
            this.dialogAdd = false;
            this.tableData();
          }else{
            this.$message(res.message)
          }
      },
      async editFunction(){
        var params = this.editform;
        var res = await EditMenu(params);
        if(res.code == 200){
          this.dialogFormVisible = false;
          this.tableData();
        }else{
          this.$message(res.message)
        }
    },
     deleteFunc(item){
      this.$confirm('确认删除？','删除',{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
       var  id = item.id;
        this.deletefunction(id);
       
        
      }).catch(() => {

      });
     
      
    },

    async deletefunction(id){
      var params={id:id};
      var res = await DeleteMenu(params);
      if(res.code == 200){
        this.tableData();
      }
    },
      up(list,index){
        if(index == 0){
          return this.$message('已是排到最高')
        }else{
            var obj = list[index-1];
            list[index-1] = list[index];
            list[index] = obj;
            this.dataList = list;
        }
        

      },
      add(item,id){
        this.dialogAdd = true;
        this.addform.parent_id = id;
        console.log(item);
        if(item == undefined){
           this.addform.px = 1
        }else{
          this.addform.px = parseInt(item.px)+1;
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