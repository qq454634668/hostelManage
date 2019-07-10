import { RoleList,SelectMenu,AddRole,EditRole,DeleteRole} from '@/api';
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
      delForm:{
        id:'',
      },
      addRole_model:false,
      editRole_model:false,
      delRole_model:false,
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
      console.log(this.addForm.menu);
      this.addForm.menu = this.addForm.menu.join(',')
      this.cjJs()
    },
    handleCurrentChange(val){
      this.page.pageNum = val;
      this.tableData();
    },
    handleSelectionChange(){

    },
    async editjs(){
  if(this.editForm.name ==''){
    this.$message('请输入用户名');
    return
  }else if(this.editForm.menu =='' ){
    this.$message('请选择菜单');
    return
  }
  this.xgJs();
},
editRole(id,role_name,menu_id){
  this.editRole_model = true;
  this.editForm.id = id;
  this.editForm.name = role_name;
  var menuString = menu_id;
  var menuStringList = menuString.split(',');

  var intList = [];
  for(var i=0;i<menuStringList.length;i++){
    var a = parseInt(menuStringList[i]);
    intList.push(a);
  }
  this.editForm.menu = intList;
},
delRole(id){
  this.delRole_model = true;
  this.delForm.id = id;
},
deljs(){
  this.del();
},
async del(){
  var params = {
    id:this.delForm.id
  };
  var res = await DeleteRole(params);
  if(res.code == 200){
    this.delRole_model = false;
    this.tableData();
    this.$message(res.message);
  }else{
    this.delRole_model = false;
    this.$message(res.message)
  }
},
async cjJs(){
  this.loading = true;
  var params = {
    role_name:this.addForm.name,
    menu_id:this.addForm.menu
  };
  var res = await AddRole(params);
  if(res.code == 200){
    this.addRole_model = false;
    this.tableData();
    this.$message(res.message);
  }else{
    this.addRole_model = false;
    this.$message(res.message)
  }
},
async xgJs(){
  this.loading = true;
  var params={
    role_id:this.editForm.id,
    menu_id:this.editForm.menu.join(','),
    role_name:this.editForm.name
  };
  var res = await EditRole(params);
  if(res.code == 200){
    this.editRole_model = false;
    // this.dataMenu= res.data;
    this.tableData();
    this.$message(res.message);
  }else{
    this.editRole_model = false;
    this.$message(res.message);
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
  // console.log(res);
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
