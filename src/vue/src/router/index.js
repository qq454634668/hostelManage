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
const  OccupancyManage = r => require.ensure([], () => r(require('@/views/dailyManage/occupancyManage')), 'occupancyManage'); //入住管理
const  RetirementManage = r => require.ensure([], () => r(require('@/views/dailyManage/retirementManage')), 'retirementManage'); //退宿管理
const  RelocationManage = r => require.ensure([], () => r(require('@/views/dailyManage/relocationManage')), 'relocationManage'); //换宿管理
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
                  hidden: true
                },
                {
                  path: '/campusManage',
                  name: 'campusManage',
                  component: CampusManage,
                  hidden: true
                },
                {
                  path: '/apartmentManage',
                  name: 'apartmentManage',
                  component: ApartmentManage,
                  hidden: true
                },
                {
                  path: '/buildingManage',
                  name: 'buildingManage',
                  component: BuildingManage,
                  hidden: true
                },
                {
                  path: '/roomManage',
                  name: 'roomManage',
                  component: RoomManage,
                  hidden: true
                },
                {
                  path: '/bedManage',
                  name: 'bedManage',
                  component: BedManage,
                  hidden: true
                } 
              ]
            },
            {
              path: '/accommodationManage',
              name: 'accommodationManage',
              component: AccommodationManage,
              hidden: true
            },
            {
              path: '/missionPlan',
              name: 'missionPlan',
              component: MissionPlan,
              hidden: true
            },
            {
              path: '/occupancyManage',
              name: 'occupancyManage',
              component: OccupancyManage,
              hidden: true
            },
            {
              path: '/retirementManage',
              name: 'retirementManage',
              component: RetirementManage,
              hidden: true
            },
            {
              path: '/relocationManage',
              name: 'relocationManage',
              component: RelocationManage,
              hidden: true
            }
          ]
         
        },  
        
      ]
    },
   
  ]
})
