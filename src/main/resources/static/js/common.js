$('.close-tck').click(function(){
    $(this).parent().parent().parent().hide()
})
var ajax_Object = function(type,url,data,callback){
	$.ajax({
		type 	: 	type,    // get/post
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
var common = {
    tabPageInit: function (url, param, tabId, columnData,pageSize) {
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
                    "total": res.total,
                    "rows": res.list
                };
            },
            sortable: false,//禁止所有列排序
            columns: columnData
        });
    },
    tabInit: function (tabId, columnData, Tdata) {
        $('#' + tabId).bootstrapTable('destroy');
        $('#' + tabId).bootstrapTable({
            method: 'get',
            //contentType: "application/x-www-form-urlencoded",//必须要有！！！！
            contentType: 'json',
            // url:"tb.json",//要请求数据的文件路径
            //height:tableHeight(),//高度调整
            // toolbar: '#toolbar',//指定工具�
            striped: false, //是否显示行间隔色
            //dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
            //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定�
            //rows�记录集合 键值可以修� dataField 自己定义成自己想要的就好
            pageNumber: 1, //初始化加载第一页，默认第一�
            pagination: false,//是否分页
            queryParamsType: 'limit',//查询参数组织方式
            //queryParams:queryParams,//请求服务器时所传的参数
            //sidePagination:'server',//指定服务器端分页
            pageSize: 4,//单页记录�
            pageList: [5, 10, 20, 30],//分页步进�
            //showRefresh:true,//刷新按钮
            //showColumns:true,
            clickToSelect: true,//是否启用点击选中�
            toolbarAlign: 'right',//工具栏对齐方�
            buttonsAlign: 'right',//按钮对齐方式
            //toolbar:'#toolbar',//指定工作�
            sortable: false,//禁止所有列排序
            /*rowStyle:function (row,index) {
             var classes=['success','info'];
             if(index % 2 === 0){
             return {classes:classes[0]};
             }else{
             return {classes:classes[1]};
             }
             },*/
            columns: columnData,
            data: Tdata
        });
    },
    columnYjxx: [
        {
            field: 'ROW_ID',
            title: '序号',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return row.ROW_ID;
            }
        },
        {
            field: 'name',
            title: '网吧上网信息',
            align: 'center',
            valign: 'middle',

        }, {
            field: 'yjjbzh',
            title: '预警等级',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                var color=''
                if(row.zt == 0){
                    return "<i class='fa yjjjPd'  yjjb = '"+row.yjjb+"' style='color:#fff'>&nbsp;-</i>"
                }else{
                    if(row.yjjb == 1){
                        color ='red'
                    }else if(row.yjjb == 2){
                        color ='orange'
                    }else if(row.yjjb == 4){
                        color ='yellow'
                    }else{
                        color ='#0084D4'
                    }
                    return "<i class='fa fa-square yjjjPd'  yjjb = '"+row.yjjb+"' style='color:"+color+"'>&nbsp;"+row.yjjbzh+"</i>"
                }

            }
        },
        {
            field: 'bdlx',
            title: '比对类型',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'zt',
            title: '状态',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                if (value == '0') {
                    return "<i class='fa' style='color: #fff;'>未触发</i>"
                } else if (value == '1') {
                    return "<i class='fa' style='color: #F2C640;'>已触发</i>"
                }
            }
        },
        {
            field: 'jjzt',
            title: '解决状态',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                if (value == '0') {
                    return "<i class='fa' style='color: #ff0000;'>未解决</i>"
                } else if (value == '1') {
                    return "<i class='fa' style='color: #fff;'>已解决</i>"
                }
            }
        },
        {
            title: '查看详情',
            align: 'center',
            valign: 'middle',
            width: '100px',
            formatter: function (value, row, index) {
                return '<a onclick="common.getZdryCurrentYearYjxx(\''+row.xq+'\',\''+row.bdlx+'\')" style="color:#2293C4;cursor: pointer">查看详情</a>'

            }
        },
        // {
        //     title: '操作',
        //     align: 'center',
        //     valign: 'middle',
        //     formatter:function(value,row){
        //         var zrr ='';
        //         var  jjsj='';
        //         var  jjfa='';
        //         var zt ='';
        //         if(row.hasOwnProperty('zrr')){
        //             zrr = row.zrr;
        //         }else{
        //             zrr='';
        //         };
        //         if(row.hasOwnProperty('jjsj')){
        //             jjsj = row.jjsj;
        //         }else{
        //             jjsj='';
        //         };
        //         if(row.hasOwnProperty('zt')){
        //             zt = row.zt;
        //         }else{
        //             zt='';
        //         }
        //         if(row.hasOwnProperty('jjfa')){
        //             jjfa = row.jjfa;
        //         }else{
        //             jjfa='';
        //         }
        //         return '<i class="fa" style="color:orangered;cursor: pointer" csid="'+row.id+'" onclick="common.ywsjClick(\''+row.id+'\',\''+zrr+'\',\''+jjsj+'\',\''+jjfa+'\',\''+zt+'\')">操作</i>'
        //     }
        // }
    ],
    ywsjClick:function(id,zrr,jjsj,jjfa,zt){
        $('.tck-ywsh').show();
        $('.sure-tck').html('提交');
        $('#ywWrite').attr('idfs',id);
        $('#ywWrite').attr('djsj','true');
        $('#zrr').val(zrr);
        $('#jjsj').val(jjsj);
        $('#jjfa').val(jjfa);
        if(zrr.length == 0){
            $("input[name ='zt'][value=1]").attr('checked',true);
        }else{
            if(zt == 1){
                $("input[name ='zt'][value=1]").attr('checked',true);
            }else if(zt == 0){
                $("input[name ='zt'][value=0]").attr('checked',true);
            }
        };

    },
    ywsjClick2:function (id,zrr,jjsj,jjfa,zt) {
        $('.tck-ywsh').show();
        $('.sure-tck').html('提交');
        $('#ywWrite').attr('idfs',id);
        $('#ywWrite').attr('djsj','false');
        $('#zrr').val(zrr);
        $('#jjsj').val(jjsj);
        $('#jjfa').val(jjfa);
        if(zrr.length == 0){
            $("input[name ='zt'][value=1]").attr('checked',true);
        }else{
            if(zt == 1){
                $("input[name ='zt'][value=1]").attr('checked',true);
            }else if(zt == 0){
                $("input[name ='zt'][value=0]").attr('checked',true);
            }
        };

    },
    ywnrwh:[
        {
            field: 'ROW_ID',
            title: '序号',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return row.ROW_ID;
            }
        },
        {
            field: 'name',
            title: '资源名称',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'ywsj',
            title: '问题描述',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'bdlx',
            title: '比对类型',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'gxsj',
            title: '发生时间',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'zt',
            title: '状态',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                console.log(value)
                if(value == 0){
                    return '<i class="fa" style="color:#ff0000;">未解决</i>'
                }else if(value == 1){
                    return '<i class="fa">已解决</i>'
                }

            }
        },
        {
            // field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                var zrr ='';
                var  jjsj='';
                var  jjfa='';
                var zt ='';
                if(row.hasOwnProperty('zrr')){
                    zrr = row.zrr;
                }else{
                    zrr='';
                };
                if(row.hasOwnProperty('jjsj')){
                    jjsj = row.jjsj;
                }else{
                    jjsj='';
                };
                if(row.hasOwnProperty('zt')){
                    zt = row.zt;
                }else{
                    zt='';
                }
                if(row.hasOwnProperty('jjfa')){
                    jjfa = row.jjfa;
                }else{
                    jjfa='';
                }
                return '<i class="fa" style="color:orangered;cursor: pointer" csid="'+row.id+'" onclick="common.ywsjClick(\''+row.id+'\',\''+zrr+'\',\''+jjsj+'\',\''+jjfa+'\',\''+zt+'\')">操作</i>'
            }
        },

    ],
    ywnrwh2:[
        {
            field: 'ROW_ID',
            title: '序号',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return row.ROW_ID;
            }
        },
        {
            field: 'name',
            title: '资源名称',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'ywsj',
            title: '问题描述',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'bdlx',
            title: '比对类型',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'gxsj',
            title: '发生时间',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'zt',
            title: '状态',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                console.log(value)
                if(value == 0){
                    return '<i class="fa" style="color:#ff0000;">未解决</i>'
                }else if(value == 1){
                    return '<i class="fa">已解决</i>'
                }

            }
        },
        {
            // field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                var zrr ='';
                var  jjsj='';
                var  jjfa='';
                var zt ='';
                if(row.hasOwnProperty('zrr')){
                    zrr = row.zrr;
                }else{
                    zrr='';
                };
                if(row.hasOwnProperty('jjsj')){
                    jjsj = row.jjsj;
                }else{
                    jjsj='';
                };
                if(row.hasOwnProperty('zt')){
                    zt = row.zt;
                }else{
                    zt='';
                }
                if(row.hasOwnProperty('jjfa')){
                    jjfa = row.jjfa;
                }else{
                    jjfa='';
                }
                return '<i class="fa" style="color:orangered;cursor: pointer" csid="'+row.id+'" onclick="common.ywsjClick2(\''+row.id+'\',\''+zrr+'\',\''+jjsj+'\',\''+jjfa+'\',\''+zt+'\')">操作</i>'
            }
        },

    ],
    getZdryCurrentYearYjxx:function(xq,bdlx){
        var list = '';
        $('.tck1').show();
        var str = xq.replace("{","");
        str= str.replace("}","");
        var arr = str.split(',');
        var html ="";
        var length = arr.length;
        if(bdlx == '表空间'){
            list = sjzljk.listBkj;
        }else if(bdlx=="数据更新情况"){
            list = sjzljk.listSjzy;
        }else if(bdlx=="硬件"){
            list = sjzljk.listYj;
            length = length-1;
        }

        for(var i=0;i<length;i++){
            var map = arr[i].trim();
            var mapArr = map.split('=');
            console.log(mapArr);
            html = html +"<div><span>"+list[i]+":</span><span>"+mapArr[1]+"</span></div>";
        }
        var div = '<div class="sjckxq">'+html+'</div>';
        $('#tck-body').html(div);
    },
}
$('.timeDate').datetimepicker({
    format:'yyyy-mm-dd hh:mm:ss',
    todayBtn:true,
    language:'zh-cn',
    autoclose:true
    // startView:1,
    // minView:0,
});


// 根据屏幕大小确定rem大小开始
var fun = function (doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            //这里是假设在640px宽度设计稿的情况下，1rem = 20px；
            //可以根据实际需要修改
            docEl.style.fontSize = 5 * (clientWidth / 640) + 'px';
        };
    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
}
fun(document, window);
// 根据屏幕大小确定rem大小结束