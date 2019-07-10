import { RoleList,SelectMenu,AddRole} from '@/api';
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
          dataMenu:[
              {name:'suibi',code:1}
          ],
          addForm:{
                name:'',
                menu:'',
          },
          editForm:{
              name:'',
              id:'',
              menu:'',
              role_id:''
          },
          dialogFormVisible:false,
          editVisible:false,
        }
    },
    methods:{
      onSubmit(){
        this.tableData();
      },
      addJs(){
          if(this.addForm.name ==''){
              this.$message('请输入用户名');
              return
          }else if(this.addForm.menu =='' ){
            this.$message('请选择菜单');
            return
          }
          this.addForm.menu = this.addForm.menu.join(',');
          this.cjJs()
      },
      handleCurrentChange(val){
        this.page.pageNum = val;
        this.tableData();
      },
      handleSelectionChange(){

      },
      async editjs(){
        console.log(this.editForm)
      },

     async cjJs(){
        this.loading = true;
        var params = {
            role_name:this.addForm.name,
            menu_id:this.addForm.menu
        };
        var res = await AddRole(params);
        if(res.code == 200){
            this.loading = false;
            this.dataMenu= res.data;
            this.dialogFormVisible = false;
            this.tableData();
        }else{
        this.loading = false;
        this.$message(res.message)
        }
    },
      // list
      async tableData(){
          this.loading = true;
           var params = {
               pageSize:this.page.pageSize,
               pageNum:this.page.pageNum
           };
          var res = await RoleList(params);
          if(res.code == 200){
              this.loading = false;
              this.dataList= res.data;
          }else{
            this.loading = false;
            this.$message(res.message)
          }
    },
  // list
    async menuSelect(){
        this.loading = true;
        var params = {
            pageSize:this.page.pageSize,
            pageNum:this.page.pageNum
        };
        var res = await SelectMenu(params);
        if(res.code == 200){
            this.loading = false;
            this.dataMenu= res.data;
        }else{
        this.loading = false;
        this.$message(res.message)
        }
    },


    },
    mounted(){
       this.tableData();
       this.menuSelect();

    }
}
