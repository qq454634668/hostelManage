import Vue from 'vue';
import Router from 'vue-router';
import App from '@/App';
import Home from '@/views/home';
const  Work = r => require.ensure([], () => r(require('@/views/work/work')), 'work'); //工作视窗
const  Login = r => require.ensure([], () => r(require('@/views/login')), 'login'); //登录
const  AccommodationManage = r => require.ensure([], () => r(require('@/views/accommodationManage/accommodationManage')), 'accommodationManage'); //住宿管理
const  CampusManage = r => require.ensure([], () => r(require('@/views/accommodationManage/campusManage')), 'campusManage'); //校区管理
const  ApartmentManage = r => require.ensure([], () => r(require('@/views/accommodationManage/apartmentManage')), 'apartmentManage'); //公寓区管理
const  BuildingManage = r => require.ensure([], () => r(require('@/views/accommodationManage/buildingManage')), 'buildingManage'); //楼栋管理
const  RoomManage = r => require.ensure([], () => r(require('@/views/accommodationManage/roomManage')), 'roomManage'); //房间管理
const  BedManage = r => require.ensure([], () => r(require('@/views/accommodationManage/bedManage')), 'bedManage'); //床位管理
const  MissionPlan = r => require.ensure([], () => r(require('@/views/missionPlan/missionPlan')), 'missionPlan'); //任务计划
const  DailyManage = r => require.ensure([], () => r(require('@/views/dailyManage/dailyManage')), 'dailyManage'); //日常管理
const  OccupancyManage = r => require.ensure([], () => r(require('@/views/dailyManage/occupancyManage')), 'occupancyManage'); //入住管理
const  RetirementManage = r => require.ensure([], () => r(require('@/views/dailyManage/retirementManage')), 'retirementManage'); //退宿管理
const  RelocationManage = r => require.ensure([], () => r(require('@/views/dailyManage/relocationManage')), 'relocationManage'); //换宿管理
const  Rzsq = r => require.ensure([], () => r(require('@/views/dormitoryApplication/rzsq')), 'rzsq'); //入住申请
const  Hssq = r => require.ensure([], () => r(require('@/views/dormitoryApplication/Hssq')), 'Hssq'); //换宿申请
const  Tssq = r => require.ensure([], () => r(require('@/views/dormitoryApplication/tssq')), 'tssq'); //退宿申请
const  UserManage = r => require.ensure([], () => r(require('@/views/qxgl/userManage')), 'userManage'); //用户管理
const  RoleManage = r => require.ensure([], () => r(require('@/views/qxgl/roleManage')), 'roleManage'); //角色管理
const  MenuManage = r => require.ensure([], () => r(require('@/views/qxgl/menuManage')), 'menuManage'); //角色管理
Vue.use(Router)

export default new Router({
  routes: [
    // { path: '*', component: page404 },
    {
      path: '/',
      component: App, 
      
      children:[
        {
          path: '',
          redirect: '/login'
        },
        {
          path: '/login',
          name: 'login',
          component: Login,
          hidden: true
        },
        {
          path: '/home',
          name: 'home',
          component: Home,
          children:[
            {
              path: '',
              name: 'accommodationManage',
              component: AccommodationManage,
              children:[
                {
                  path: '',
                  name: 'campusManage',
                  component: CampusManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"住宿管理",
                    breadcrumb: '校区住宿'
                  }
                },
                {
                  path: '/campusManage',
                  name: 'campusManage',
                  component: CampusManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"住宿管理",
                    breadcrumb: '校区住宿'
                  }
                },
                {
                  path: '/apartmentManage',
                  name: 'apartmentManage',
                  component: ApartmentManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"住宿管理",
                    breadcrumb: '公寓区管理'
                  }
                },
                {
                  path: '/buildingManage',
                  name: 'buildingManage',
                  component: BuildingManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"住宿管理",
                    breadcrumb: '楼栋管理'
                  }
                },
                {
                  path: '/roomManage',
                  name: 'roomManage',
                  component: RoomManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"住宿管理",
                    breadcrumb: '房间管理'
                  }
                },
                {
                  path: '/bedManage',
                  name: 'bedManage',
                  component: BedManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"住宿管理",
                    breadcrumb: '床位管理'
                  }
                },
                {
                  path: '/missionPlan',
                  name: 'missionPlan',
                  component: MissionPlan,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"任务计划",
                    breadcrumb: '自动计划'
                },
              },
                {
                  path: '/occupancyManage',
                  name: 'occupancyManage',
                  component: OccupancyManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"日常管理",
                    breadcrumb: '入住管理'
                }
              },
                {
                  path: '/retirementManage',
                  name: 'retirementManage',
                  component: RetirementManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"日常管理",
                    breadcrumb: '退宿管理'
                }
              },
                {
                  path: '/relocationManage',
                  name: 'relocationManage',
                  component: RelocationManage,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"日常管理",
                    breadcrumb: '换宿管理'
                  },
                },
                {
                  path: '/rzsq',
                  name: 'rzsq',
                  component: Rzsq,
                  meta: {
                    requireAuth: true,
                    breadcrumbparent:"宿舍申请",
                    breadcrumb: '入住申请'
                  },
                },
                {
                path: '/hssq',
                name: 'hssq',
                component: Hssq,
                meta: {
                  requireAuth: true,
                  breadcrumbparent:"宿舍申请",
                  breadcrumb: '换宿申请'
                },
              },
              {
                path: '/tssq',
                name: 'tssq',
                component: Tssq,
                meta: {
                  requireAuth: true,
                  breadcrumbparent:"宿舍申请",
                  breadcrumb: '退宿申请'
                },
              },
              {
                path: '/userManage',
                name: 'userManage',
                component: UserManage,
                meta: {
                  requireAuth: true,
                  breadcrumbparent:"权限管理",
                  breadcrumb: '用户管理'
                },
              },
              {
                path: '/menuManage',
                name: 'menuManage',
                component: MenuManage,
                meta: {
                  requireAuth: true,
                  breadcrumbparent:"权限管理",
                  breadcrumb: '菜单管理'
                },
              },
              {
                path: '/roleManage',
                name: 'roleManage',
                component: RoleManage,
                meta: {
                  requireAuth: true,
                  breadcrumbparent:"权限管理",
                  breadcrumb: '角色管理'
                },
              }

              ]
            },
            {
              path: '/accommodationManage',
              name: 'accommodationManage',
              component: AccommodationManage,
              hidden: true
            },

            
          ]
         
        },  
        
      ]
    },
   
  ]
})
