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
var rcgl = {
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

}
var clickFunction = function(){
    //校区管理点击菜单列表
    $('#rcgl_rzgl').click(function(){
        rcgl.tabPageInit("/daily/BedListMap", {xqbh:"",gybh:"",loubh:"020301",pageSize:10,pageNum:1},"rcgl_tableList",rcgl.zsgl_xqgl_List, 20);
        // $(".hidden_model").attr("hidden",true);
        // $("#zsgl_xqgl_model").attr("hidden",false);
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
}
$(function(){
    clickFunction();
});