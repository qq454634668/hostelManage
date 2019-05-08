// 左标题点击事件
$(".fuhao").click(function(){
	$(this).parent('.mainTitle').siblings().toggle();
	var dataYs = $(this).attr('datays');
	
	if(dataYs == 'true'){
		$(this).html('<i class="fa fa-sort-desc" aria-hidden="true"></i>');
		$(this).attr('datays','false')
	}else{
		$(this).html('<i class="fa fa-sort-asc" aria-hidden="true" style="display:inline-block;padding-top:15px;"></i>');
		$(this).attr('datays','true')
	}
});
var log = {
    insertOrUpdate:'insert',
	logType:'loginLog',
	loginLog:[
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
            field: 'visit_unit_name',
            title: '单位名称',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'visit_ip',
            title: 'IP地址',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'visit_idcard',
            title: '身份证号码',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'enter_time',
            title: '登录时间',
            align: 'center',
            valign: 'middle'
        }
	],
    czLog:[
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
            field: 'OPERATE_USER',
            title: '用户姓名',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'OPERATE_UNIT_CODE',
            title: '单位名称',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'OPERATE_TYPE',
            title: '操作类型',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'ip',
            title: '登录IP',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'OPERATE_ID',
            title: '操作日志编号',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'OPERATE_UNIT_CODE',
            title: '登录编码',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'OPERATE_TIME',
            title: '操作时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    cxLog:[
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
            field: 'username',
            title: '用户姓名',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'dwmc',
            title: '单位名称',
            align: 'center',
            valign: 'middle'
        },{
            field: 'idcard',
            title: '身份证号',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'ip',
            title: '登录IP',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'querykey',
            title: '查询条件',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'time',
            title: '查询时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    jksyLog:[
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
            field: 'xm',
            title: '用户姓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'sfzh',
            title: '身份证号',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'ip',
            title: '登录IP',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'key',
            title: '查询条件',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'jczmc',
            title: '检查站名称',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'jh',
            title: '警号',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'rksj',
            title: '查询时间',
            align: 'center',
            valign: 'middle'
        }
    ],
    fwqLoginLog:[
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
            field: 'fwqip',
            title: '服务器IP',
            align: 'center',
            valign: 'middle'

        }, {

            field: 'username',
            title: '用户名',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'dlip',
            title: '登录IP',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'rksj',
            title: '入库时间',
            align: 'center',
            valign: 'middle'
        }
    ],
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
            title: '情报种类',
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
            title: '数据业务评估运算模型',
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
                var jszc ='';
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
                if(row.hasOwnProperty('jszc')){
                    jszc = row.jszc;
                }else{
                    jszc='';
                }
                return '<i class="fa aqjg_ywnrwh_cz" style="color:orangered;cursor: pointer" csid="'+row.id+'" onclick="log.ywsjClick(\''+row.id+'\',\''+zrr+'\',\''+jjsj+'\',\''+jjfa+'\',\''+zt+'\',\''+jszc+'\')">操作</i>'
            }
        },

    ],
    fwqList:[
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
            field: 'host',
            title: '主机名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'itemname',
            title: '监控项',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'itemkey',
            title: '监控内容',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'hostid',
            title: '主机ID',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'itemid',
            title: 'itemid',
            align: 'center',
            valign: 'middle'
        }

    ],
    khcontent:[
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
            field: 'real_name',
            title: '姓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'idcard',
            title: '身份证号',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'unitname',
            title: '单位名称',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'id',
            title: 'ID',
            align: 'center',
            valign: 'middle'
        },
        {
            // field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                return '<i class="fa" style="color:orangered;cursor: pointer;color:#F19149" csid="'+row.id+'" onclick="log.khClick(\''+row.id+'\',\''+row.real_name+'\',\''+row.unit_id+'\',\''+row.idcard+'\')">考核</i>'
            }
        },

    ],
    khResult:[
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
            field: 'real_name',
            title: '姓名',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'idcard',
            title: '身份证号',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'unit_zh',
            title: '单位名称',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'one',
            title: '一月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }

            }
        },
        {
            field: 'two',
            title: '二月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },
        {
            field: 'three',
            title: '三月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }

            }
        },{
            field: 'four',
            title: '四月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'five',
            title: '五月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'six',
            title: '六月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'seven',
            title: '七月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'eight',
            title: '八月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'nine',
            title: '九月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'ten',
            title: '十月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'eleven',
            title: '十一月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        },{
            field: 'twelve',
            title: '十二月',
            align: 'center',
            valign: 'middle',
            formatter:function(value,row){
                if(value>80 ){
                    return '<i class="iconfont icon-taiyang2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <= 80 && value > 60 || value == 60){
                    return '<i class="iconfont icon-yueliang"  aria-hidden="true" style="color:#ffd700"></i>'
                }else if(value <60 && value>0){
                    // class="fa fa-square"
                    return '<i class="iconfont icon-xingxing2"  aria-hidden="true" style="color:#ffd700"></i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#fff"> - </i>'
                }
            }
        }
    ],
    yjfzList:[
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
            title: '情报种类',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'typezh',
            title: '数据业务评估运算模型',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'ip',
            title: 'IP地址',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'yjjb',
            title: '事件等级',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'yjjbzh',
            title: '事件等级名称',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'yz',
            title: '评价权重',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'yzlx',
            title: '评估运算模型类型',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'yxx',
            title: '启用状态',
            align: 'center',
            valign: 'middle',
            formatter:function(value, row,index){
                if(value == '0' ){
                    return '<i class="fa" aria-hidden="true" style="color:#5CB85C">&nbsp;已启用</i>'
                }else{
                    return '<i class="fa" aria-hidden="true" style="color:#ff0f1e">&nbsp;已禁用</i>'
                }
            }
        },
        {
            field: 'yxx',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter:function(value, row,index){
                if(value == '0'){
                    return '<span class="aqjg_yjfzsz_cz"  id="yjjbClicksj" onclick="yjjnset( \''+row.id+'\',\''+row.name+'\',\''+row.type+'\',\''+row.yz+'\',\''+row.yzlx+'\',\''+row.yjjb+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;<span id="yjjbClicksj2" onclick="qyjyFz( \''+row.id+'\',\''+row.yxx+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#ff0000">&nbsp; </i>禁用</span>';
                }else{
                    return '<span class=""  id="yjjbClicksj" onclick="yjjnset( \''+row.id+'\',\''+row.name+'\',\''+row.type+'\',\''+row.yz+'\',\''+row.yzlx+'\',\''+row.yjjb+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;<span id="yjjbClicksj2" onclick="qyjyFz( \''+row.id+'\',\''+row.yxx+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#ff0000">&nbsp; </i>启用</span>';
                }

            }
        }

    ],
    usersList:[
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
            field: 'user_name',
            title: '用户名',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'idcard',
            title: '身份证号',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'real_name',
            title: '真实姓名',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'role_name',
            title: '权限',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'yxx',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter:function(value, row,index){
                // return '<span id="yjjbClicksj" onclick="yjjnset( \''+row.id+'\',\''+row.name+'\',\''+row.type+'\',\''+row.yz+'\',\''+row.yzlx+'\',\''+row.yjjb+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;<span id="yjjbClicksj2" onclick="qyjyFz( \''+row.id+'\',\''+row.yxx+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#ff0000">&nbsp; </i>禁用</span>';
                return '<span id="xg" onclick="userUpdate(\''+row.id+'\',\''+row.user_name+'\',\''+row.idcard+'\',\''+row.real_name+'\',\''+row.role_id+'\',\''+row.password+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;<span id="sc" onclick="userDelete( \''+row.id+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#ff0e05">&nbsp; </i>删除</span>';
            }
        }

    ],
    roleList:[
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
            title: '角色名',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'purview_name',
            title: '角色权限',
            align: 'center',
            valign: 'middle'

        },
        {
            field: 'yxx',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter:function(value, row,index){
                // return '<span id="yjjbClicksj" onclick="yjjnset( \''+row.id+'\',\''+row.name+'\',\''+row.type+'\',\''+row.yz+'\',\''+row.yzlx+'\',\''+row.yjjb+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;<span id="yjjbClicksj2" onclick="qyjyFz( \''+row.id+'\',\''+row.yxx+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#ff0000">&nbsp; </i>禁用</span>';
                return '<span id="xg" onclick="roleUpdate(\''+row.id+'\',\''+row.name+'\',\''+row.purview_id+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;';
                // return '<span id="xg" onclick="roleUpdate(\''+row.id+'\',\''+row.name+'\',\''+row.purview_id+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#22aaff">&nbsp; </i>修改</span>&nbsp;&nbsp;<span id="sc" onclick="userDelete( \''+row.id+'\')"><i class="fa fa-square" aria-hidden="true" style="color:#ff0e05">&nbsp; </i>删除</span>';
            }
        }

    ],
    ywsjClick:function(id,zrr,jjsj,jjfa,zt,jszc){
        $('.tck1').show();
        $('.sure-tck').html('提交');
        $('#ywWrite').attr('idfs',id);
         $('#zrr').val(zrr);
         $('#jjsj').val(jjsj);
         $('#jjfa').val(jjfa);
         $('#jszc').val(jszc);
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
    khClick:function(id,real_name,unit_id,idcard){
        console.log(real_name)
        // user_id,real_name,unit_id,idcard,zpf,ldpf,zpfqzz,zzpf
        ajax_Object('post','/manage/aqjgKhMenu','',function(data){
            $('.tck4').show();
            $('#qdtjPoint').attr('idz',id);
            $('#qdtjPoint').attr('real_name',real_name);
            $('#qdtjPoint').attr('unit_id',unit_id);
            $('#qdtjPoint').attr('idcard',idcard);
            var tr = '';
            var data = data.data;
            for(var i = 0 ;i<data.length;i++){
                var sonMenu =data[i].sonMenu;
                var xuhao = i+1
                tr  += '<tr class="fstjkh" parentMenuPoint="'+data[i].parentMenuPoint+'">'+'<td>'+ xuhao +'</td>' +'<td>'+data[i].parentMenu+'</td>' +'<td>'+data[i].parentMenuPoint+'</td>'+'<td>'
                for(var j = 0; j<sonMenu.length;j++){
                    tr += '<p>'+sonMenu[j].content+'('+sonMenu[j].point +')'+'</p>'
                };
                tr += '</td>'+'<td><input type="text" placeholder="请输入自评分" class="zpfChange fsChange" pflb ="zpf"/></td><td><input type="text" placeholder="请输入领导评分" class="ldpfChange fsChange" pflb ="zpf"/></td><td><input type="text" placeholder="自评分权重值" value="60" class="QzzChange fsChange" pflb ="qzz"/>%</td><td class="zzpf"><input type="text" class="dxzongfen" readonly="readonly"/></td></tr>';
            };
            tr += '<tr><td></td><td></td><td></td><td></td><td></td><td></td><td class="collpla7">合计</td><td class="zongfen"></td></tr>'
            $('#pointBz').html(tr)
        });
        ajax_Object('post','/manage/aqjgKhPfXq',{idcard:idcard},function(data){
            console.log(data);
            if(data.data.length!=0){
                var data = data.data[0];
                var zpf = data.zpf;
                var ldpf = data.ldpf;
                var zpfqzz = data.zpfqzz;
                zpf = zpf.split(',');
                ldpf =ldpf.split(',');
                zpfqzz=zpfqzz.split(',');
                var length = $('.zpfChange').length;
                for(var i =0;i<length;i++){
                    $('.zpfChange').eq(i).val(zpf[i]);
                    $('.ldpfChange').eq(i).val(ldpf[i]);
                    $('.QzzChange').eq(i).val(zpfqzz[i]);


                    var zzdf = (zpf[i]*zpfqzz[i]/100) + (ldpf[i]*(100-zpfqzz[i])/100);
                    $('.dxzongfen').eq(i).val(zzdf)

                    }
                var zdzgy =  0;
                for(var i = 0;i<$('.dxzongfen').length;i++){
                    if($('.dxzongfen').eq(i).val().length!=0){
                        zdzgy =zdzgy+parseInt($('.dxzongfen').eq(i).val())
                    }else{
                        zdzgy = zdzgy+0
                    }
                }
                $('.zongfen').html(zdzgy)
            }


        });

    },
    fsChange:function(){
	    $(document).on('change','.fsChange',function(){
            var ponitLimit =  parseInt($(this).parent().parent().attr('parentMenuPoint'));
            var reg = new RegExp("^(\\d|[1-9]\\d|100)$");
            var pdnum = parseInt($(this).val());
            if(!reg.test(pdnum)){
                alert('请输入正确的数字格式');
                $(this).val('');
            }else{
                if($(this).attr('pflb') == 'zpf'){
                    if(pdnum > ponitLimit){
                        alert('本项最高分数为'+ponitLimit+'分');
                        $(this).val(ponitLimit);
                    }
                }else if($(this).attr('pflb') == 'qzz'){
                    if(pdnum>80){
                        alert('自评分占比不能超过'+80+'%');
                        $(this).val('60%');
                    }
                }
            };
            var zpf = $(this).parent().parent().children().find('.zpfChange').val();
            var ldpf = $(this).parent().parent().children().find('.ldpfChange').val();
            var qzhzb = $(this).parent().parent().children().find('.QzzChange').val();
            if(zpf.length == 0){
                zpf  = 0;
            };
            if(ldpf.length == 0){
                ldpf = 0
            };
            var zzdf = (zpf*qzhzb/100) + (ldpf*(100-qzhzb)/100);
            if(zzdf !=0){
                $(this).parent().parent().children().find('.dxzongfen').val(zzdf);
                   var zdzgy =  0;
                   for(var i = 0;i<$('.dxzongfen').length;i++){
                       if($('.dxzongfen').eq(i).val().length!=0){
                           zdzgy =zdzgy+parseInt($('.dxzongfen').eq(i).val())
                       }else{
                           zdzgy = zdzgy+0
                       }
                   }
                    $('.zongfen').html(zdzgy)

            }

            })

    },
    qdtjPoint:function(){
        $('#qdtjPoint').off('click');
        $('#qdtjPoint').on('click',function(){
            var  user_id  = $('#qdtjPoint').attr('idz');
            var  real_name  = $('#qdtjPoint').attr('real_name');
            var  unit_id  = $('#qdtjPoint').attr('unit_id');
            var  idcard  = $('#qdtjPoint').attr('idcard');
            var length = $('.zpfChange').length;
            var zzpfjg = $('.zongfen').text();
            var zpfjg='';
            var ldpfjg='';
            var qzzjg='';
            var dxzongfenjg='';
            for(var i =0;i<length;i++){
                var zpfcl = $('.zpfChange').eq(i).val();
                var ldpfcl = $('.ldpfChange').eq(i).val();
                var qzzcl = $('.QzzChange').eq(i).val();
                // var dxzongfencl = $('.dxzongfen').eq(i).val();
                if(zpfcl.length == 0 || ldpfcl.length == 0 || qzzcl.length == 0){
                    alert('评分不能为空');
                    return
                }else if(zpfcl.length != 0 && ldpfcl.length != 0 && qzzcl.length != 0){
                    if(i != length-1){
                        zpfjg += zpfcl+',';
                        ldpfjg +=ldpfcl+',';
                        qzzjg += qzzcl+',';
                    }else{
                        zpfjg += zpfcl;
                        ldpfjg +=ldpfcl;
                        qzzjg += qzzcl;
                    }

                    // dxzongfenjg +=dxzongfencl+',';

                };

            };

            if(zzpfjg.length != 0){
                ajax_Object('post','/manage/aqjgKhInsert',{user_id:user_id,real_name:real_name,unit_id:unit_id,idcard:idcard,zpf:zpfjg,ldpf:ldpfjg,zpfqzz:qzzjg,zzpf:zzpfjg,pfr:'',pfrsfzh:'',pfr_unit:''},function(data){
                    alert(data.message);
                    $('.tck4').hide()
                });
            }
        });
    },
    tckg:function(zhi){
	    zhi = zhi.replace(/(^\s*)|(\s*$)/g,'');
        return zhi.replace(/\s+/g,'|')
    },
    yjfzlx:function () {
        ajax_Object('post','/main/getDic',{lx:'type'},function(data){
            console.log(data);
            var data = data.data;
            var option = '<option value="">请选择类型</option>';
            for (var i = 0;i<data.length;i++){
                option +=   '<option value="'+data[i].dm+'">'+data[i].mc+'</option>'
            };
            $('#yjfzlx').html(option);
            $('#yjlxfz').html(option)

        })
    }
};
function yjjnset(id,name,type,yz,yzlx,yjjb){
    $('#yjsetzy').val(name);
    $('#yjfz').val(yz);
    $('#yjfzlxselect').val(yzlx);
    $('#yjjb').val(yjjb);
    $('#yjUpdate').attr('yjid',id);
    $('.tckyj').show();
    ajax_Object('post','/main/getDic',{lx:'type'},function(data){
        var data = data.data;
        var option = '<option value="">请选择类型</option>';
        for (var i = 0;i<data.length;i++){
            if(type == data[i].dm){
                option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
            }else{
                option +=   '<option value="'+data[i].dm+'">'+data[i].mc+'</option>'
            }
        };
        $('#yjlxfz').html(option)
    })
}
function userDelete(id){
    var r = confirm("请确定是否删除用户!");
    if( r==true ){
        //点击确定
        ajax_Object('post','/manage/userDelete',{id:id},function(data){
            if(data.code == 200){
                alert("删除成功");
                common.tabPageInit('/manage/selectUsersList', {key:$('#usersListKey').val(),pageSize:10,pageNum:1}, 'logContent', log.usersList, 20);
            }else{
                alert('失败失败');
            }
        });
    }else{
        //点击取消
    }
}
function userUpdate(id,user_name,idcard,real_name,role_id,password){
    log.insertOrUpdate = 'update';
    ajax_Object('post','/manage/AqjgRoleMenu',{},function(data){
        var data = data.data;
        console.log(data);
        var option = '<option value="">请选择角色</option>';
        for (var i = 0;i<data.length;i++){
            if(role_id == data[i].id){
                option += '<option value="'+data[i].id+'" selected="selected">'+data[i].name+'</option>'
            }else{
                option += '<option value="'+data[i].id+'">'+data[i].name+'</option>'
            }
        };
        $('#aqjg_users_jsxz').html(option);
    })
    $("#aqjg_users_id").val(id);
    $("#aqjg_users_username").val(user_name);
    $("#aqjg_users_idcard").val(idcard);
    $("#aqjg_users_realname").val(real_name);
    $("#aqjg_users_password").val(password);
    $('.tck6').show();
    //更新用户，用新增用户接口，先判断是否有该用户
}
function roleUpdate(id,name,purview_id){
    log.insertOrUpdate = "update";
    ajax_Object('post','/manage/purviewList',{},function(data){
        var data = data.data;
        // console.log(data);
        var checkboxList = "";
        for(var i=0;i<data.length;i++){
            checkboxList += "<span style='display: inline-block;width: 24%'><label><input style='display: inline-block;' id='purview"+data[i].id+"'   name='purview' type='checkbox' value="+data[i].id+" />"+data[i].name+"</label></span>"
        }
        $('#purviewList').html(checkboxList);
        //取消所有选项

        //待开发   purview_id根据这字段 根据逗号分组，之后给checkbox渲染
        var arr = purview_id.split(',');
        for(var a=0;a<arr.length;a++){
            var purvieId = 'purview'+arr[a];
            $("#"+purvieId).prop("checked",true);
        }
    });
    $("#roleId").val(id);
    $("#roleName").val(name);
    $('.tck7').show();
}
function roleDelete(id){
    var r = confirm("请确定是否删除用户!");
    if( r==true ){
        //点击确定
        ajax_Object('post','/manage/userDelete',{id:id},function(data){
            if(data.code == 200){
                alert("删除成功");
                common.tabPageInit('/manage/selectUsersList', {key:$('#usersListKey').val(),pageSize:10,pageNum:1}, 'logContent', log.usersList, 20);
            }else{
                alert('失败失败');
            }
        });
    }else{
        //点击取消
    }
}
function qyjyFz(id,yxx){
    ajax_Object('post','/main/deleteAqjgFzb',{id:id,yxx:yxx},function(data){
        common.tabPageInit('/main/selectAqjgFzb', {name:$('#zyname').val(),type:$('#yjfzlx').val(),yjjb:$('#yjfzyjjb').val(),yxx:$('#yjfzyxx').val(),pageSize:10,pageNum:1}, 'logContentset', log.yjfzList, 20);
    })
}
$('#yjUpdate').click(function(){
    var id = $(this).attr('yjid');
    ajax_Object('post','/main/updateAqjgFzb',{name:$('#yjsetzy').val(),type:$('#yjlxfz').val(),yz:$('#yjfz').val(),yzlx:$('#yjfzlxselect').val(),yjjb:$('#yjjb').val(),id:id},function (data) {
        console.log(data);
        if(data.code == 200){
            alert(data.message);
            $('.tckyj').hide();
            common.tabPageInit('/main/selectAqjgFzb', {name:$('#zyname').val(),type:$('#yjfzlx').val(),yjjb:$('#yjfzyjjb').val(),yxx:$('#yjfzyxx').val(),pageSize:10,pageNum:1}, 'logContentset', log.yjfzList, 20);
        }else{
            alert('更新失败');
        }
    })
})
$(document).on('click','#ywWrite',function(){
    var id = $(this).attr('idfs');
    var zrr = $('#zrr').val();
    var jjsj = $('#jjsj').val();
    var jjfa = $('#jjfa').val();
    var jszc = $('#jszc').val();
   var zt = $("input[name ='zt']:checked").val();
    if(zrr.length!=0 && jjsj.length != 0 && jjfa.length != 0){
        ajax_Object('post','/manage/ywsjUpdate',{id:id,jjsj:jjsj,zrr:zrr,jjfa:jjfa,zt:zt,jszc:jszc},function(data){
            console.log(data);
            if(data.code == 200){
                alert('提交成功');
                $('.tck1').hide();
                common.tabPageInit('/manage/ywsjList', {flcx:$("#selectFlcx").val(),ysmx:$("#selectSjywpgmx").val(),kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1,zt:$('#selectZt').val()}, 'logContent', log.ywnrwh, 20);
            }

        })
    }else{
        alert('不能为空')
    }

});
// 运维事件添加
$('#ywsjtj').click(function(){
    $('.tck5').show();
});
//权限列表添加
$('#button-roleAdd-log').click(function() {
    $("#roleId").val("");
    log.insertOrUpdate = 'insert';
    ajax_Object('post', '/manage/purviewList', {}, function (data) {
        var data = data.data;
        // console.log(data);
        var checkboxList = "";
        for (var i = 0; i < data.length; i++) {
            checkboxList += "<span style='display: inline-block;width: 24%'><label><input style='display: inline-block;' id='purview" + data[i].id + "'   name='purview' type='checkbox' value=" + data[i].id + " />" + data[i].name + "</label></span>"
        }
        $('#purviewList').html(checkboxList);
        //取消所有选项
        // $("input[name='purview']").prop("checked",false);
    })
    $('.tck7').show();
});
//权限列表添加确定按钮
$('#roleAddButton').click(function(){
    var length = $('input[name="purview"]:checked').length;
    var value = "";//定义一个数组
    $('input[name="purview"]:checked').each(function (index,element) {
            if(index==length-1){
                value += $(this).val();
            }else{
                value += $(this).val()+",";
            }

    });
    var roleName = $("#roleName").val();
    var id = $("#roleId").val();
    if(value && roleName){
        var date = "";
        var Msg ="";
        var url ="";
        if(log.insertOrUpdate =='insert'){
            date = {name:roleName,purview_id:value};
            Msg= "权限列表添加";
            url ="/manage/AqjgRoleInsert";
        }else if(log.insertOrUpdate =='update'){
            date = {id:id,name:roleName,purview_id:value};
            Msg= "权限列表修改";
            url ="/manage/AqjgRoleUpdate";
        }
        ajax_Object('post',url,date,function (data) {
            if(data.code == 200){
                alert(Msg+'成功');
                $('.tck6').hide();
                common.tabPageInit('/manage/selectRoleList', {pageSize:10,pageNum:1}, 'logContent', log.roleList, 20);
            }else{
                alert(Msg+'失败');
            }
        });
    }else{
        alert('所有选项不能为空')
    }
    $('.tck7').hide();

});
//用户列表添加
$('#button-add-log').click(function(){
    log.insertOrUpdate = 'insert';
    ajax_Object('post','/manage/AqjgRoleMenu',{},function(data){
        var data = data.data;
        console.log(data);
        var option = '<option value="">请选择角色</option>';
        for (var i = 0;i<data.length;i++){
            // if(type == data[i].dm){
            //     option +=   '<option value="'+data[i].dm+'" selected="selected">'+data[i].mc+'</option>'
            // }else{
                option +=   '<option value="'+data[i].id+'">'+data[i].name+'</option>'
            // }
        };
        $('#aqjg_users_jsxz').html(option);
        $("#aqjg_users_username").val("");
        $("#aqjg_users_idcard").val("");
        $("#aqjg_users_realname").val("");
        $("#aqjg_users_password").val("");
    })
    $('.tck6').show();
});
//用户列表添加确定按钮
$('#usersTjFf').click(function(){
    if($('#aqjg_users_username').val().length != 0 && $('#aqjg_users_password').val().length != 0 && $('#aqjg_users_idcard').val().length != 0 && $('#aqjg_users_realname').val().length != 0 && $('#aqjg_users_jsxz').val().length != 0){
        var date = "";
        var Msg ="";
        if(log.insertOrUpdate =='insert'){
            date = {id:'',user_name:$('#aqjg_users_username').val(),password:$('#aqjg_users_password').val(),idcard:$('#aqjg_users_idcard').val(),real_name:$('#aqjg_users_realname').val(),role_id:$('#aqjg_users_jsxz').val()};
            Msg= "用户列表添加";
        }else if(log.insertOrUpdate =='update'){
            date = {id:$("#aqjg_users_id").val(),user_name:$('#aqjg_users_username').val(),password:$('#aqjg_users_password').val(),idcard:$('#aqjg_users_idcard').val(),real_name:$('#aqjg_users_realname').val(),role_id:$('#aqjg_users_jsxz').val()};
            Msg= "用户列表修改";
        }
        ajax_Object('post','/manage/insertAqjgUsers',date,function (data) {
            if(data.code == 200){
                alert(Msg+'成功');
                $('.tck6').hide();
                common.tabPageInit('/manage/selectUsersList', {key:$('#usersListKey').val(),pageSize:10,pageNum:1}, 'logContent', log.usersList, 20);
            }else{
                alert(Msg+'失败');
            }
        });
    }else{
        alert('所有选项不能为空')
    }

});
$('#ywsjTjFf').click(function(){
    if($('#fssj').val().length != 0 && $('#wtms').val().length != 0 && $('#sjbt').val().length != 0){
        ajax_Object('post','/manage/handInsertYwsj',{sjbt:$('#sjbt').val(),gxsj:$('#fssj').val(),ywsj:$('#wtms').val()},function (data) {
            console.log(data);
            if(data.code == 200){
                alert('运维事件添加成功');
                $('.tck5').hide();
                common.tabPageInit('/manage/ywsjList', {flcx:$("#selectFlcx").val(),ysmx:$("#selectSjywpgmx").val(),kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1,zt:$('#selectZt').val()}, 'logContent', log.ywnrwh, 20);
            }else{
                alert('运维事件添加失败');
            }
        });
    }else{
        alert('所有项不能为空')
    }

});
var logPd = function(){
    $('.logContent').show().siblings().hide();
    $('.dwxzShow').hide();
    $('.timeDate').show();
    $('.zhShow').hide();
    $('.flcxShow').hide();
    $('.sjywpgmxShow').hide();
    $('.usersListKey').hide();
    $('.usersListAdd').hide();
    $('.functionSelect').hide();
    $('.functionExport').hide();
    $('.functionRoleAdd').hide();
	if(log.logType == 'loginLog'){
        $('.dwxzShow').show();
        $('.functionSelect').show();
        $('.functionExport').show();
        common.tabPageInit('/manage/userOnLineList', {order:$('#selectOrderBy').val(),kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:20,pageNum:1,dwmc:log.tckg($('#dwxz').val())}, 'logContent', log.loginLog, 20);
	}else if(log.logType == 'czLog'){
        $('.dwxzShow').show();
        $('.functionSelect').show();
        $('.functionExport').show();
        common.tabPageInit('/manage/czrzList', {order:$('#selectOrderBy').val(),kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1,dwmc:log.tckg($('#dwxz').val())}, 'logContent', log.czLog, 20);
	}else if(log.logType == 'cxLog'){
        $('.dwxzShow').show();
        $('.functionSelect').show();
        $('.functionExport').show();
        common.tabPageInit('/manage/qwjsCxrzList', {kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1,dwmc:log.tckg($('#dwxz').val())}, 'logContent', log.cxLog, 20);
    }else if(log.logType == 'jksyLog'){
        $('.functionSelect').show();
        $('.functionExport').show();
        common.tabPageInit('/manage/wbjkList', {kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1}, 'logContent', log.jksyLog, 20);
    }else if(log.logType == 'fwqLog'){
        $('.functionSelect').show();
        // $('.functionExport').show();
        common.tabPageInit('/manage/fwqLoginList', {kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1}, 'logContent', log.fwqLoginLog, 20);
    }else if(log.logType == 'ywnrwh'){
        $('.zhShow').show();
        $('.flcxShow').show();
        $('.sjywpgmxShow').show();
        $('.functionSelect').show();
        $('.functionExport').show();
        common.tabPageInit('/manage/ywsjList', {flcx:$("#selectFlcx").val(),ysmx:$("#selectSjywpgmx").val(),kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1,zt:$('#selectZt').val()}, 'logContent', log.ywnrwh, 20);
    }
    else if(log.logType == 'bmkh'){
	    $('.bmkh-content').show().siblings().hide();
        $('.functionSelect').show();
        $('.functionExport').show();
        pmList.bumenKao();
        bumenKao();
    }else if(log.logType == 'grkh'){
        $('.functionSelect').show();
        $('.functionExport').show();
        $('.grkh-content').show().siblings().hide();
        khfunction();
    }else if(log.logType == 'khset'){
        $('.functionSelect').show();
        $('.functionExport').show();
        $('.khcsset').show().siblings().hide();
        khxtj();
    }else if(log.logType == 'fwqyxLog'){
        $('.functionSelect').show();
        $('.functionExport').show();
        common.tabPageInit('/manage/fwqList', {kssj:$('#kssj').val(),jssj:$('#jssj').val(),pageSize:10,pageNum:1}, 'logContent', log.fwqList, 20);
    }else if(log.logType == 'yjfzset'){
        $('.functionSelect').show();
        $('.functionExport').show();
        $('.logContentset').show().siblings().hide();
        log.yjfzlx();
        common.tabPageInit('/main/selectAqjgFzb', {name:$('#zyname').val(),type:$('#yjfzlx').val(),yjjb:$('#yjfzyjjb').val(),yxx:$('#yjfzyxx').val(),pageSize:10,pageNum:1}, 'logContentset', log.yjfzList, 20);
    }else if(log.logType == 'yhlb'){
        $('.functionSelect').show();
        $('.functionExport').show();
        $('.usersListKey').show();
        $('.usersListAdd').show();
        $('.timeDate').hide();
        common.tabPageInit('/manage/selectUsersList', {key:$('#usersListKey').val(),pageSize:10,pageNum:1}, 'logContent', log.usersList, 20);
    }else if(log.logType == 'rolelb'){
        $('.timeDate').hide();
        $('.functionRoleAdd').show();
        common.tabPageInit('/manage/selectRoleList', {pageSize:10,pageNum:1}, 'logContent', log.roleList, 20);

    }
};
    $('#yjfzClick').click(function(){
        common.tabPageInit('/main/selectAqjgFzb', {name:$('#zyname').val(),type:$('#yjfzlx').val(),yjjb:$('#yjfzyjjb').val(),yxx:$('#yjfzyxx').val(),pageSize:10,pageNum:1}, 'logContentset', log.yjfzList, 20);
    });
$('.logClick').click(function(){
     $('#kssj').val('');
     $('#jssj').val('');
    log.logType = $(this).attr('datatype');
    $('.logClick').removeClass('logactive');
    $(this).addClass('logactive');
    logPd();
});
$('#button-cx-log').click(function(){
    var kssj = $('#kssj').val();
    var jssj =$('#jssj').val();
   if(kssj.length != 0 && jssj.length ==0){
       alert('请输入结束时间')
   }else if(jssj.length != 0 && kssj.length == 0){
       alert('请输入开始时间')
   }else{
       logPd()
   }
});
$('#button-dc-log').click(function(){
    if(log.logType == 'loginLog'){
        window.open('/manage/exportUserLogin?kssj='+$('#kssj').val()+'&jssj='+$('#jssj').val()+'&dwmc='+log.tckg($('#dwxz').val()));
    }else if(log.logType == 'czLog'){
        window.open('/manage/exportCzrz?kssj='+$('#kssj').val()+'&jssj='+$('#jssj').val()+'&dwmc='+log.tckg($('#dwxz').val()));

    }else if(log.logType == 'cxLog'){
        window.open('/manage/exportQwjs?kssj='+$('#kssj').val()+'&jssj='+$('#jssj').val()+'&dwmc='+log.tckg($('#dwxz').val()));
    }else if(log.logType == 'jksyLog'){
        window.open('/manage/exportWbdy?kssj='+$('#kssj').val()+'&jssj='+$('#jssj').val())
    }else if(log.logType == 'ywnrwh'){
        window.open('/manage/exportYwsj?kssj='+$('#kssj').val()+'&jssj='+$('#jssj').val()+'&zt='+$('#selectZt').val());
    }else if(log.logType == 'fwqyxLog'){
        window.open('/manage/exportFwq?kssj='+$('#kssj').val()+'&jssj='+$('#jssj').val())
    }
});



// 考核项参数设置
function khxtj(){
    $('#add-mainlog').click(function(){
        $('.tckset').show();
        $('.tckset .tck-title').html('添加菜单');
    });
    $('#tjkhx').click(function(){
        if($('#content-name').val().length == 0){
            alert('请输入考核项名称')
        }else if($('#point-main').val().length == 0){
            alert('请输入总分')
        }else{
            ajax_Object('post','/manage/insertAqjgKhMenu',{parentid:0,content:$('#content-name').val(),point:$('#point-main').val()},function(data){
                if(data.code == 200){
                    alert(data.message);
                    $('.tckset').hide();
                    xuanranNr()
                }
            })
        }

    });

    xuanranNr();

}
function xuanranNr(){
    ajax_Object('post','/manage/aqjgKhMenu','',function(data){
        var tr = '';
        var data = data.data;
        for(var i = 0 ;i<data.length;i++){
            var sonMenu =data[i].sonMenu;
            var xuhao = i+1
            tr  += '<tr>'+'<td>'+ xuhao +'</td>' +'<td>'+data[i].parentMenu+'</td>' +'<td>'+data[i].parentMenuPoint+'</td>'+'<td>'
            for(var j = 0; j<sonMenu.length;j++){
                tr += '<p><span class="zjnr">'+sonMenu[j].content+'('+sonMenu[j].point +')'+'</span><span class="zsgc xsClick" fzjpd ="son" IdName ="'+sonMenu[j].id+'" eidyWwite="write" khContent ="'+sonMenu[j].content+'" khPoint="'+sonMenu[j].point+'"><i class="fa fa-square" aria-hidden="true" style="color:#ff0000">&nbsp; </i>修改</span><span  class="zsgc xsClick" fzjpd ="son" IdName ="'+sonMenu[j].id+'" eidyWwite="delete"><i class="fa fa-square" aria-hidden="true" style="color:#0995bf">&nbsp; </i>删除</span></p>'
            };
            tr += '<p parentMenuId="'+data[i].parentMenuId+'" onclick="addContent('+data[i].parentMenuId+')" style="cursor: pointer"><i class="fa fa-plus-square-o" aria-hidden="true" style="color:#f9ec2f">&nbsp;&nbsp;添加子菜单</i></p></td>' +'<td parentMenuId="'+data[i].parentMenuId+'"><span class="xsClick"  style="cursor: pointer;display: inline-block;padding:0 5px;" IdName ="'+data[i].parentMenuId+'"  eidyWwite="delete" fzjpd ="parent"><i class="fa fa-square" aria-hidden="true" style="color:#f9ec2f"></i>&nbsp;删除</span><span class="xsClick" style="cursor: pointer;display: inline-block;padding:0 5px;" IdName ="'+data[i].parentMenuId+'"  eidyWwite="write" fzjpd ="parent" khContent ="'+data[i].parentMenu+'"  khPoint="'+data[i].parentMenuPoint+'"><i class="fa fa-square" aria-hidden="true" style="color:#ff0000"></i>&nbsp;修改</span></td></tr>'

        };
        $('.khxiang').html(tr)
    });
};
$(document).on('click','.xsClick',function(){
    var zsgc = $(this).attr('eidyWwite');
    var IdName = $(this).attr('IdName');
    var level = $(this).attr('fzjpd');
    if(zsgc == 'write'){
        $('.tck-gengxin').show();
       var khContent = $(this).attr('khContent');
       var khPoint = $(this).attr('khPoint');
       $('#eidtContent').val(khContent);
       $('#eidtPonint').val(khPoint);
       $('#xgkhnr').attr('IdName',IdName);

    }else if(zsgc == 'delete'){
        $('.tck-addDelete').show();
        $('#tck-deleteAdd').html('您确定要删除此条内容');
        $('#deleteAdd').click(function(){
            ajax_Object('post','/manage/deleteAqjgKhMenu',{level:level,id:IdName});
            $('.tck-addDelete').hide();
            xuanranNr()
        })

    }


});

$("#xgkhnr").click(function(){
    var IdName = $('#xgkhnr').attr('IdName');
    ajax_Object('post','/manage/updateAqjgKhMenu',{id:IdName,content:$('#eidtContent').val(),point:$('#eidtPonint').val()},function(data){
        if(data.code == 200){
            $('.tck-gengxin').hide();
            alert('更新成功');
            xuanranNr()
        }else{
            alert('更新失败')
        }
    });
})
function addContent(id){
    $('#testContent').val('');
    $('#testPonint').val('')
        $('.tck3').show()

    $('#selectAqjgKhMenu').off('click').on('click',function(){

            if($('#testContent').val().length == 0){
                alert('请输入考核项名称')
            }else if($('#testPonint').val().length == 0){
                alert('请输入总分')
            }else{
                ajax_Object('post','/manage/insertAqjgKhMenu',{parentid:id,content:$('#testContent').val(),point:$('#testPonint').val()},function(data){
                    if(data.code == 200){
                        // alert(data.message);
                        $('.tck3').hide();
                        xuanranNr()
                    }
                })
            }

    })
};

$('#lingdtj').click(function(){
    $('.tck2').show();
    $('.tck-title').html('告警统计');
    common.tabPageInit('/manage/ywsjList', {flcx:"",kssj:'',jssj:'',pageSize:10,pageNum:1,zt:0}, 'ick-table', log.ywnrwh, 20);
})
//绩效考核接口
var khjk = function(){
    // common.tabPageInit('/manage/userList', {pageSize:20,pageNum:1,idcard:'',real_name:'',dwmc:''}, 'userList', log.khcontent, 10);
    common.tabPageInit('/manage/selectAqjgKhTJ', {pageSize:20,pageNum:1,idcard:'',real_name:'',dwmc:''}, 'khjgShow', log.khResult, 10);
};
var qx = function(){
    var idcard =_getRequest('idcard');
        $.ajax(
            {
                type: 'get',
                url: '/user/roleCtl',
                data: {idcard:idcard},
                dataType: 'JSON',
                success: function (data) {
                    var allClass = data.allClass;
                    var userClass = data.userClass;
                    for(var i=0;i<allClass.length;i++){
                        $("."+allClass[i].class).hide();
                    }
                    if(idcard!=""&&idcard!=null&&idcard!="null"){
                        for(var i=0;i<userClass.length;i++){
                            $("."+userClass[i].class).show();
                        }
                    }
                }
            }
        );
    console.log("空")
};

// 绩效考核查询按钮

$('#buttonCxkhfs').click(function(){
    var sfzh =$('#cxkhlistSfzh').val();
    var real_name = $('#cxkhlistName1').val();
    var dwmc = $('#dwselect2').val();
    common.tabPageInit('/manage/userList', {pageSize:20,pageNum:1,idcard:sfzh,real_name:real_name,dwmc:dwmc}, 'userList', log.khcontent, 10);
});
$('#buttonCxkhjg').click(function(){
    var sfzh =$('#cxkhJgSfzh').val();
    var real_name = $('#cxkhlistName').val();
    var dwmc = $('#dwselect').val();
    common.tabPageInit('/manage/selectAqjgKhTJ', {pageSize:20,pageNum:1,idcard:sfzh,real_name:real_name,dwmc:dwmc}, 'khjgShow', log.khResult, 10);
});

// 考核查询结果导出
$('#buttonCxkhDc').click(function(){
    var sfzh =$('#cxkhJgSfzh').val();
    var real_name = $('#cxkhlistName').val();
    window.open('/manage/exportKhPfList?idcard='+sfzh+'&real_name='+real_name)
})
// 考核结果
var khjgShow = function(){
    common.tabPageInit('/manage/selectAqjgKhTJ', {pageSize:20,pageNum:1,idcard:'',real_name:'',dwmc:''}, 'khjgShow', log.khResult, 10);
};
$(function(){
    qx();
    logPd();
});

function khfunction(){
    khjk();
    log.fsChange();
    // 分数计算
    log.qdtjPoint();
    // 考核结果
    khjgShow();
};


// 部门考核图渲染
var pmList ={
    bumenKao:function(){
        // 部门排名
        ajax_Object('post','/manage/aqjgKhBmPm','',function(data){
            if(data.code == 200){
                var data = data.data;
                console.log(data);
                var dataName = [];
                var dataEight = [];
                var dataSix = [];
                var dataDown = [];
                for(var i = 0;i<data.length;i++){
                    dataName.push(data[i].unit_zh);
                    dataEight.push(data[i].unitList[0].value);
                    dataSix.push(data[i].unitList[1].value)
                    dataDown.push(data[i].unitList[2].value)
                };
                tjkh.bar(dataName,dataEight,dataSix,dataDown);
            }

        })
    },
    timeKao:function(){
        ajax_Object('post','/manage/aqjgKhSjPm','',function(data){
            // console.log(data);
            if(data.code == 200){
                var data = data.data;
                // console.log(data)
                var dataName = [];
                var dataEight = [];
                var dataSix = [];
                var dataDown = [];
                for(var i = 0;i<data.length;i++){
                    dataName.push(data[i].month+'月');
                    dataEight.push(data[i].sjList[0].value);
                    dataSix.push(data[i].sjList[1].value)
                    dataDown.push(data[i].sjList[2].value)
                };
                tjkh.bar(dataName,dataEight,dataSix,dataDown);
            }

        })
    },
};
function bumenKao(){
    // log.pie1();
    // log.pie2();
    ajax_Object('post','/manage/aqjgKhBmJglTj','',function(data){

        var dataName =[];
        var data = data.data;
        var dataJgl =  [];
        if(data.length !=0){
            for(var i =0;i<data.length;i++){
                dataName.push(data[i].NAME);
                dataJgl.push(data[i].VALUE.toFixed(2));
            }

        };
        tjkh.line('tjkhBt',dataName,dataJgl);
    });

    ajax_Object('post','/manage/aqjgKhGrTj','',function(data){
        var data = data.data;
        // console.log(data);
        if(data.length !=0){
            tjkh.dataEhart.id = 'tjkhBt';
            tjkh.dataEhart.title = '个人排名';
            tjkh.dataEhart.data=[];
            if(data.length<5){
                for(var i =0;i<data.length;i++){
                    tjkh.dataEhart.data.push({value:data[i].zzpf,name:data[i].real_name})
                }
            }else{
                for(var i =0;i<5;i++){
                    tjkh.dataEhart.data.push({value:data[i].zzpf,name:data[i].real_name})
                }
            }

            tjkh.pie('tjkhzxt',tjkh.dataEhart)
        };





        // tjkh.line('tjkhBt',dataName,dataJgl)
        // console.log(dataName);
        // console.log(dataJgl)
    });
    $('#topQie>div').click(function(){
        var nr = $(this).attr('nr');
        $(this).addClass('active').siblings().removeClass('active');
        if(nr == 'quan'){
            ajax_Object('post','/manage/aqjgKhBmJglTj','',function(data){
                console.log(data);
                var dataName =[];
                var data = data.data;
                var dataJgl =  [];
                if(data.length !=0){
                    for(var i =0;i<data.length;i++){
                        dataName.push(data[i].NAME);
                        dataJgl.push(data[i].VALUE.toFixed(2));
                    }

                };
                tjkh.line('tjkhBt',dataName,dataJgl)
                console.log(dataName);
                console.log(dataJgl)

            });
        }else{
            ajax_Object('post','/manage/aqjgKhBmJglTj','',function(data){
                console.log(data);
                var dataName =[];
                var data = data.data;
                var dataJgl =  [];
                if(data.length !=0){
                    for(var i =0;i<5;i++){
                        dataName.push(data[i].NAME);
                        dataJgl.push(data[i].VALUE.toFixed(2));
                    }

                };
                tjkh.line('tjkhBt',dataName,dataJgl);
                // console.log(dataName);
                // console.log(dataJgl)

            });
        }

    })
};
$('#paimingStyle>div').click(function(){
    $(this).addClass('active').siblings().removeClass('active');
    var pmStyle = $(this).attr('pmStyle')
    if(pmStyle == 'bumen'){
        pmList.bumenKao();
    }else if(pmStyle == 'time'){
        pmList.timeKao();
    }
})


