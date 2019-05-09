var ajax_Object = function(url,data,callback){
    $.ajax({
        type 	: 	"post",    // get/post
        url 	: 	url,
        data 	: 	data,
        dataType: 	"json",
        cache 	: 	false,
        async   :    false,
        success : 	function (data) {
            callback(data);
        }
    });
};
var zsgl = {
    tabPageInit: function (url, param, tabId, columnData, pageSize) {
        $('#' + tabId).bootstrapTable('destroy');
        $('#' + tabId).bootstrapTable({
            method: 'get',
            contentType: "application/x-www-form-urlencoded",//必须要有！！！！
            url: url,//要请求数据的文件路径
            //height:tableHeight(),//高度调整
            // toolbar: '#toolbar',//指定工具�
            //dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
            //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定�
            //rows�记录集合 键值可以修� dataField 自己定义成自己想要的就好
            pageNumber: 1, //初始化加载第一页，默认第一�
            pagination: true,//是否分页
            //queryParams:queryParams,//请求服务器时所传的参数
            //sidePagination:'server',//指定服务器端分页
            pageSize: pageSize,//单页记录�
            sidePagination: "server",
            // showRefresh:true,
            queryParamsType: 'aaa', // undefined
            queryParams: function (params) {
                param.pageNum = params.pageNumber;
                param.pageSize = params.pageSize;
                return param;
            },

            responseHandler: function (res) {
                return {
                    "total": res.data.total,
                    "rows": res.data.list
                };
            },
            sortable: false,//禁止所有列排序
            columns: columnData
        });
    },
    zsgl_xqgl_List:[
        // {
        //     field: 'ROW_ID',
        //     title: '序号',
        //     align: 'center',
        //     valign: 'middle',
        //     formatter: function (value, row, index) {
        //         return row.ROW_ID;
        //     }
        // },
        {
            field: 'louname',
            title: '校区名称',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'rksj',
            title: '入库时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    zsgl_gyqgl_List:[
        // {
        //     field: 'ROW_ID',
        //     title: '序号',
        //     align: 'center',
        //     valign: 'middle',
        //     formatter: function (value, row, index) {
        //         return row.ROW_ID;
        //     }
        // },
        {
            field: 'gyname',
            title: '公寓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'xqname',
            title: '校区名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'rksj',
            title: '入库时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    zsgl_ldgl_List:[
        // {
        //     field: 'ROW_ID',
        //     title: '序号',
        //     align: 'center',
        //     valign: 'middle',
        //     formatter: function (value, row, index) {
        //         return row.ROW_ID;
        //     }
        // },
        {
            field: 'xqname',
            title: '公寓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'gyname',
            title: '校区名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'name',
            title: '楼栋名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'louztname',
            title: '男/女',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'rksj',
            title: '入库时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    zsgl_fjgl_List:[
        // {
        //     field: 'ROW_ID',
        //     title: '序号',
        //     align: 'center',
        //     valign: 'middle',
        //     formatter: function (value, row, index) {
        //         return row.ROW_ID;
        //     }
        // },
        {
            field: 'xqname',
            title: '公寓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'gyname',
            title: '校区名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'louname',
            title: '楼栋名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'fjbh',
            title: '房间编号',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'fjbzname',
            title: '房间标准',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'louztname',
            title: '男/女',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'rksj',
            title: '入库时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    zsgl_cwgl_List:[
        // {
        //     field: 'ROW_ID',
        //     title: '序号',
        //     align: 'center',
        //     valign: 'middle',
        //     formatter: function (value, row, index) {
        //         return row.ROW_ID;
        //     }
        // },
        {
            field: 'xqname',
            title: '公寓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'gyname',
            title: '校区名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'louname',
            title: '楼栋名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'fjbh',
            title: '房间编号',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'fjbzname',
            title: '房间标准',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'louztname',
            title: '男/女',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'cwbh',
            title: '床位编号',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'rksj',
            title: '入库时间',
            align: 'center',
            valign: 'middle'
        }
    ],
}
var clickFunction = function(){
    //校区管理点击菜单列表
    $('#zsgl_xqgl').click(function(){
        zsgl.tabPageInit("/live/QueryCampusList", {pageSize:10,pageNum:1},"tableList",zsgl.zsgl_xqgl_List, 20);
        $(".hidden_model").attr("hidden",true);
        $("#zsgl_xqgl_model").attr("hidden",false);
    });
    //公寓区管理点击菜单列表
    $('#zsgl_gyqgl').click(function(){
        zsgl.tabPageInit("/live/QueryApartmentList", {pageSize:10,pageNum:1},"tableList",zsgl.zsgl_gyqgl_List, 20);
        $(".hidden_model").attr("hidden",true);
        ajax_Object('/dic/DicCampus',{},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择校区</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#gyqgl_xqname').html(option);
        });
        $("#zsgl_gyqgl_model").attr("hidden",false);
    });
    //楼栋管理点击菜单列表
    $('#zsgl_ldgl').click(function(){
        zsgl.tabPageInit("/live/QueryFloorList", {pageSize:10,pageNum:1},"tableList",zsgl.zsgl_ldgl_List, 20);
        $(".hidden_model").attr("hidden",true);
        ajax_Object('/dic/DicCampus',{},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择校区</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#ldgl_xqname').html(option);
        });
        ajax_Object('/dic/DicApartment',{code:"02"},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择公寓区</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#ldgl_gyname').html(option);
        });
        ajax_Object('/dic/DicGet',{lx:"xb"},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">男/女</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#ldgl_louzt').html(option);
        });
        $("#zsgl_ldgl_model").attr("hidden",false);
    });
    //房间管理点击菜单列表
    $('#zsgl_fjgl').click(function(){
        zsgl.tabPageInit("/live/QueryRoomList", {pageSize:10,pageNum:1},"tableList",zsgl.zsgl_fjgl_List, 20);
        $(".hidden_model").attr("hidden",true);
        ajax_Object('/dic/DicCampus',{},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择校区</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#fjgl_xqname').html(option);
        });
        ajax_Object('/dic/DicApartment',{code:"02"},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择公寓区</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#fjgl_gyname').html(option);
        });
        ajax_Object('/dic/DicFloor',{code:"0203"},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择楼栋</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#fjgl_loubh').html(option);
        });
        ajax_Object('/dic/DicGet',{lx:"room"},function(data){
            var data = data.data;
            console.log(data);
            var option = '<option value="">请选择房间标准</option>';
            for (var i = 0;i<data.length;i++){
                // if(type == data[i].dm){
                //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
                // }else{
                option +=   '<option value="'+data[i].code+'">'+data[i].name+'</option>'
                // }
            };
            $('#fjgl_fjbz').html(option);
        });
        $("#zsgl_fjgl_model").attr("hidden",false);
    });
    //床位管理点击菜单列表
    $('#zsgl_cwgl').click(function(){
        $(".hidden_model").attr("hidden",true);
        zsgl.tabPageInit("/live/QueryBedList", {pageSize:10,pageNum:1},"tableList",zsgl.zsgl_cwgl_List, 20);
    });
    //校区管理新建创建
    $('#xqgl_insert_button').click(function(){
        var xqgl_name=$("#xqgl_name").val();
        ajax_Object(
            '/live/AddCampus',
            {name:xqgl_name},
            function(data){
            alert(data.message);
        });
    });
    //公寓区管理新建创建时间
    $('#gyqgl_insert_button').click(function(){
        var gyqgl_xqname=$("#gyqgl_xqname").val();
        var gyqgl_gyname=$("#gyqgl_gyname").val();
        alert(gyqgl_xqname);
        alert(gyqgl_gyname);
        ajax_Object(
            '/live/AddApartment',
            {xqbh:gyqgl_xqname, name:gyqgl_gyname},
            function(data){
            alert(data.message);
        });
    });
    //楼栋管理新建创建时间
    $('#ldgl_insert_button').click(function(){
        var ldgl_xqname=$("#ldgl_xqname").val();
        var ldgl_gyname=$("#ldgl_gyname").val();
        var ldgl_louname=$("#ldgl_louname").val();
        var ldgl_louzt=$("#ldgl_louzt").val();
        ajax_Object(
            '/live/AddFloor',
            {name:ldgl_louname, louzt:ldgl_louzt,xqbh:ldgl_xqname,gybh:ldgl_gyname},
            function(data){
            alert(data.message);
        });
    });
    //房间管理新建创建时间
    $('#fjgl_insert_button').click(function(){
        var fjgl_xqname=$("#fjgl_xqname").val();
        var fjgl_gyname=$("#fjgl_gyname").val();
        var fjgl_loubh=$("#fjgl_loubh").val();
        var fjgl_fjbh=$("#fjgl_fjbh").val();
        var fjgl_fjbz=$("#fjgl_fjbz").val();
        ajax_Object(
            '/live/AddRoom',
            {xqbh:fjgl_xqname, gybh:fjgl_gyname,loubh:fjgl_loubh,fjbh:fjgl_fjbh,fjbz:fjgl_fjbz},
            function(data){
                alert(data.message);
            });
    });
}
$(function(){
    clickFunction();
});