import {applyForList,QueryUserList,EditUser,BuildStatusDictionary,RoleList,EditUserRole,DeleteUser,AddUser} from '@/api';
export default {
    data(){
      return{
          tableDataList:[],
          peopleDataList:[],
          loading:false,
          editUser_model:false,
          editRole_model:false,
          del_model:false,
          add_model:false,
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
            id:'',
            realname:'',
            lxdh:'',
            xy:'',
            role_id:'',
            xj:'',
            username:'',
            password:'',
          },
          xyList:'',
          roleList:'',
        
          
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
      async xy(){
        var params = {lx:'xy'};
        var res = await BuildStatusDictionary(params);
        if(res.code == 200){
            this.xyList = res.data;
        }else{
          this.$message(res.message);
        }
      },
      async addUser(){
        this.add_model =true;
        this.xy();
      },
      //新增用户点击事件
      async addUser_submit(){
          this.addUser_Action();
      },
       //添加用户方法
       async addUser_Action(){
        var param={username:this.form.username,
          password:this.form.password,
          realname:this.form.realname,
          lxdh:this.form.lxdh,
          xy:this.form.xy,
          nj:this.form.xj
         }
        var res = await AddUser(param);
        if(res.code == 200){
          this.add_model = false;
          this.$message(res.message)
          this.tableData();
        }else{
          this.$message(res.message)
        }
      },
      //修改用户按钮
      async editUser(index,id,realname,lxdh,xy,xj){
        this.editUser_model = true;
        var param={
          lx:'xy'
        }
        var xyList = await BuildStatusDictionary(param);
        this.xyList = xyList.data;
        this.form.xy = xy;
        this.form.id = id;
        this.form.realname = realname;
        this.form.lxdh = lxdh;
        this.form.xj = xj;
      },
      //修改用户点击事件
      editUser_submit(){
        this.editUser_Action();
      },
      //修改用户方法
      async editUser_Action(){
        var param={realname:this.form.realname,
          lxdh:this.form.lxdh,
          xy:this.form.xy,
          nj:this.form.xj,
          id:this.form.id,
         }
        var res = await EditUser(param);
        if(res.code == 200){
          this.editUser_model = false;
          this.$message(res.message)
          this.tableData();
        }else{
          this.$message(res.message)
        }
      },
      //修改用户权限
      async editRole(index,id,role_id){
        this.editRole_model = true;
        var param={
        }
        var roleList = await RoleList(param);
        this.roleList = roleList.data;
        this.form.id = id;
        this.form.role_id = role_id;
      },
      //修改用户权限点击事件
      editRole_submit(){
        this.editRole_Action();
      },
      //修改用户权限方法
      async editRole_Action(){
        var param={
          id:this.form.id,
          role_id:this.form.role_id
          }
        var res = await EditUserRole(param);
        if(res.code == 200){
          this.editRole_model = false;
          this.$message(res.message)
        }else{
          this.$message(res.message)
        }
      },
      del(index,id){
          this.del_model = true;
          this.form.id = id;
      },
      async del_submit(){
          var param ={
            id:this.form.id
          }
          var res = await DeleteUser(param);
          if(res.code == 200){
            this.del_model = false;
            this.$message(res.message);
            this.tableData();
        }else{
          this.loading = false;
          this.$message(res.message);
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