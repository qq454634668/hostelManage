import { BedListMap, AllBuildDictionary, ApartDictionary, CampusDictionary, BuildDictionary } from '@/api';
export default {
  data() {
    return {
      tableDataList: [],
      peopleDataList: [],
      loading: false,
      page: {
        pageNum: 1,
        pageSize: 5,
        startRow: 0,
        endRow: 0
      },
      form: {
        apart: '',
        apartSelect: '',
        district: '',
        districtSelect: '',
        building: '',
        buildingSelect: '',
        buildName: '',
      }


    }
  },
  methods: {
    onSubmit() {
      this.tableData();
    },
    //下拉框选中事件
    selectGet(vId) {//这个vId也就是value值
      let obj = {};
      obj = this.form.buildingSelect.find((item) => {//这里的userList就是上面遍历的数据源
        return item.code === vId;//筛选出匹配数据
      });
      this.form.buildName = obj.name;
    },
    selectChange(apart) {
      if (apart == 'apart') {
        this.form.district = "";
        this.form.districtSelect = [];
        this.form.building = "";
        this.form.buildingSelect = [];
        this.districtPart(this.form.apart);

      } else if (apart == "district") {
        this.form.building = "";
        this.apartLou(this.form.district)
      }
    },
    link(cwbh) {
      this.$router.push({ path: '/xzz',query:{cwbh:cwbh}});
    },
    // 床位
    async bedList() {
      this.loading = true;
      var params = {
        xqbh: this.form.apart,
        gybh: this.form.district,
        loubh: this.form.building
      };
      var res = await BedListMap(params);
      if (res.code == 200) {
        this.loading = false;
        this.tableDataList = res.data;
      } else {
        this.loading = false;
        this.$message(res.message)
      }
    },

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
        this.form.building = res.data[0].code;
        this.form.buildName = res.data[0].name;
        this.bedList();
      } else {
        this.$message(res.message)
      }
    },

  },
  mounted() {
    this.apartLouAll()
    this.apart();
  }
}