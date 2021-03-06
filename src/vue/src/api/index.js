import formMiddlePromise from './myutil';
import axios from 'axios';
import NProgress from 'nprogress';
import Qs from 'qs';

let base = '';
// TODO
let hotelBaseUrl = 'http://localhost:8080/product'; // 天津公安appcan中连接到企业联络员津公安appcan中连接到企业联络员的地址
// process.env.NODE_ENV == 'development'
//     (base = 'localhost:8080'); //域名测试地址

// 接口地址
export { base };
export { hotelBaseUrl };
//登陆
export const requestLogin = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/user/login`, params, method);
};
//菜单
export const InitInfo = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/user/InitInfo`, params, method);
};
//校区管理tableData
export const campusList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/QueryCampusList`, params, method);
};
//校区管理新增
export const campusadd = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/AddCampus`, params, method);
};
//校区管理编辑
export const campusEdit = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/EditCampus`, params, method);
};
//校区管理删除
export const campusDelete = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/DeleteCampus`, params, method);
};
//校区管理删除
export const ifHasPart = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/ExistApartment`, params, method);
};
//公寓区列表
export const ApartmentList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/QueryApartmentList`, params, method);
};
//公寓区增加
export const ApartmentAdd = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/AddApartment`, params, method);
};
//公寓区删除
export const ApartmentDelete = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/DeleteApartment`, params, method);
};
//公寓区修改
export const ApartmentEdit = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/EditApartment`, params, method);
};
//公寓区删除判断
export const ifBuild = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/ExistFloor`, params, method);
};
//公寓楼列表
export const BuildmentList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/QueryFloorList`, params, method);
};
//公寓楼增加
export const BuildmentAdd = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/AddFloor`, params, method);
};
//公寓楼停用
export const BuildmentDelete = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/DelFloor`, params, method);
};
//公寓楼修改
export const BuildmentEdit = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/EditFloor`, params, method);
};
//公寓楼判断
export const ifRoom = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/ExistBedZtLou`, params, method);
};

//房间列表
export const QueryRoomList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/QueryRoomList`, params, method);
};
//新增房间
export const AddRoom = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/AddRoom`, params, method);
};
// 判断是否存在重复房间
export const repeatRoom = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/repeatRoom`, params, method);
};
//判断房间停用或者空置
export const ExistRoomRz = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/ExistRoomRz`, params, method);
};
//修改房间
export const EditRoom = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/EditRoom`, params, method);
};
//删除房间
export const DelRoom = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/DelRoom`, params, method);
};
//先判断房间内是否有人入住
export const StopRoom = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/StopRoom`, params, method);
};

//床位列表
export const bedList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/QueryBedList`, params, method);
};
//启用停用床位
export const stopBed = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/live/StopBed`, params, method);
};

//校区字典下拉
export const CampusDictionary = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicCampus`, params, method);
};
//公寓区字典下拉
export const ApartDictionary = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicApartment`, params, method);
};
//楼字典下拉
export const BuildDictionary = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicFloor`, params, method);
};
//楼字典下拉
export const AllBuildDictionary = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicFloorAll`, params, method);
};
//房间字典下拉
export const RoomDictionary = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicRoom`, params, method);
};
//混合字典下拉
export const BuildStatusDictionary = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicGet`, params, method);
};
//混合字典子级下拉
export const DicGetS = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicGetS`, params, method);
};
//年级下拉
export const DicNj = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicNj`, params, method);
};
//班级下拉
export const DicBj = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/dic/DicBj`, params, method);
};

// 任务计划
export const plan = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/taskPlan/taskBaseList`, params, method);
};
// 任务对应学生信息List
export const studentList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/taskPlan/ChooseStu`, params, method);
};
// 任务对应学生空床位数
export const EmptyBed = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/taskPlan/EmptyBed`, params, method);
};
// 添加任务计划
export const AddTaskPlan = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/taskPlan/AddTaskPlan`, params, method);
};
// 删除任务计划
export const DelTaskPlan = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/taskPlan/DelTaskPlan`, params, method);
};



// 日常管理
// 入住床位管理
export const BedListMap = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/daily/BedListMap`, params, method);
};


// 宿舍管理
//入住/换宿/退宿申请记录List
export const applyForList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/daily/applyForList`, params, method);
};
//审批申请-----同意/不同意申请
export const verifyAsk = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/daily/verifyAsk`, params, method);
};

// 权限管理

//增加菜单
export const AddMenu = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/AddMenu`, params, method);
};
//修改菜单
export const EditMenu = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/EditMenu`, params, method);
};
//查询菜单
export const QueryMenu = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/QueryMenu`, params, method);
};

//删除菜单
export const DeleteMenu = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/DeleteMenu`, params, method);
};
//查询用户列表
export const QueryUserList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/QueryUserList`, params, method);
};
//修改用户信息
export const EditUser = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/EditUser`, params, method);
};
//修改用户信息
export const EditUserRole = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/EditUserRole`, params, method);
};
//删除用户
export const DeleteUser = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/DeleteUser`, params, method);
};
//添加用户
export const AddUser = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/AddUser`, params, method);
};



// 入职管理学生列表
export const StudentList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/daily/StudentList`, params, method);
};
// 点击床位编号入住
export const QuitSs = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/daily/QuitSs`, params, method);
};
//点击床位入住/换宿
export const MoveInto = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/daily/MoveInto`, params, method);
};

// 角色list
export const RoleList = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/RoleList`, params, method);
};
// 可选择菜单
export const SelectMenu = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/SelectMenu`, params, method);
};
// 创建角色
export const AddRole = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/AddRole`, params, method);
};
// 修改角色
// export const EditRoleName = (params, method) => {
//   return formMiddlePromise(`${hotelBaseUrl}/purview/EditRoleName`, params, method);
// };
// 修改角色菜单
// export const EditRoleMenu = (params, method) => {
//   return formMiddlePromise(`${hotelBaseUrl}/purview/EditRoleMenu`, params, method);
// };
//修改角色
export const EditRole = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/EditRole`, params, method);
};

// 删除角色
export const DeleteRole = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/DeleteRole`, params, method);
};

// 角色是否存在关联用户
export const ExistRoleUser = (params, method) => {
  return formMiddlePromise(`${hotelBaseUrl}/purview/ExistRoleUser`, params, method);
};





