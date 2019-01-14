<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<!--[if lt IE 9]>
<script type="text/javascript" src="/lib/html5shiv.js"></script>
<script type="text/javascript" src="/lib/respond.min.js"></script>
<![endif]-->
		<link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />
		<!--[if IE 6]>
<script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
		<title>用户听歌信息列表</title>
	</head>

	<body>
		<div class="page-container">
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
					<thead>
						<tr class="text-c">
							<th width="20%">用户ID</th>
							<th width="20%">用户名称</th>
							<th width="20%">音乐ID</th>
							<th width="20%">音乐名称</th>
							<th width="20%">用户听歌频率</th>
						</tr>
					</thead>
					<tbody>
						<%--<c:forEach items="${cleUserMusicList}" var="cleUM">--%>
							<%--<tr class="text-c">--%>
								<%--<td>${cleUM.userid}</td>--%>
								<%--<td>${cleUM.userid}</td>--%>
								<%--<td>${cleUM.musicid}</td>--%>
								<%--<td>${cleUM.userid}</td>--%>
								<%--<td>${cleUM.ratio}</td>--%>
							<%--</tr>--%>
						<%--</c:forEach>--%>
					</tbody>
				</table>
			</div>
		</div>
		<!--_footer 作为公共模版分离出去-->
		<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
		<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
		<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script>
		<!--/_footer 作为公共模版分离出去-->

		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>


		<!-- 自定义js -->
		<script type="text/javascript" src="/lib/content.js"></script>
		<script type="text/javascript">
            // $('.table-sort').dataTable({
            // 	"aaSorting": [
            // 		[0, "desc"]
            // 	], //默认第几个排序
            // 	"bStateSave": true, //状态保存
            // 	"pading": false,
            // 	"iDisplayLength":20
            // });
            $(function(){
                var $table = $(".table-sort");
                var _table = $table.dataTable($.extend(true,{},CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
                    ajax : function(data, callback, settings) {
                        //封装请求参数
                        var param = contestObj.getQueryCondition(data);
                        $.ajax({
                            type: "POST",
                            url: "${pageContext.request.contextPath}/cle/getUserMusic",
                            cache : false,  //禁用缓存
                            data: param,    //传入已封装的参数
                            dataType: "json",
                            success: function(result) {
                                //异常判断与处理
                                if (result.errorCode) {
                                    alert("查询失败");
                                    return;
                                }
                                //封装返回数据
                                var returnData = {};
                                returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                                returnData.recordsTotal = result.cleUMTotal;//总记录数
                                returnData.recordsFiltered = result.cleUMTotal;//后台不实现过滤功能，每次查询均视作全部结果
                                returnData.data = result.cleUserMusics;
                                //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                                //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                                callback(returnData);
                            },
                            error: function(XMLHttpRequest, textStatus, errorThrown) {
                                alert("查询失败");
                            }
                        });
                    },
                    //绑定数据
                    columns: [
                        {
                            data: "userid"//字段名
                        },
                        {
                            data: "username"//字段名
                        },
                        {
                            data: "musicid"//字段名
                            // title: "",
                            // render: function (data, type, row, meta) {
                            //     return new Date(Date.parse(data)).Format("yyyy-MM-dd hh:mm:ss");
                            // }
                        },
						{
                            data: "musicname"//字段名
                        },
                        {

                            data: "ratio"//字段名
                        }
                        // {
                        //     data : "contestStatus",//字段名
                        //     orderable : false//禁用排序
                        // }
                    ],
                    "drawCallback": function( settings ) {
                        //渲染完毕后的回调
                        //默认选中第一行
                        //$("tbody tr",$table).eq(0).click();
                    }
                })).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
                //查询
                $("#btn_search").click(function(){
                    _table.draw();
                });
            });
            var contestObj = {
                getQueryCondition : function(data) {
                    var param = {};
                    //组装排序参数
                    if (data.order&&data.order.length&&data.order[0]) {
                        switch (data.order[0].column) {
                            case 0:
                                param.orderColumn = "userid";//数据库列名称
                                break;
                            case 1:
                                param.orderColumn = "username";//数据库列名称
                                break;
                            case 2:
                                param.orderColumn = "musicid";//数据库列名称
                                break;
                            case 3:
                                param.orderColumn = "musicname";//数据库列名称
                                break;
                            case 4:
                                param.orderColumn = "ratio";//数据库列名称
                                break;
                            default:
                                param.orderColumn = "id";//数据库列名称
                                break;

                        }
                        //排序方式asc或者desc
                        param.orderDir = data.order[0].dir;
                    }
                    param.contestId = $("#contestId-search").val();//查询条件
                    param.name = $("#name-search").val();//查询条件
                    param.status = $("#status-search").val();//查询条件
                    //组装分页参数
                    param.startIndex = data.start;
                    param.pageSize = data.length;
                    param.draw = data.draw;
                    return param;
                }
            };
		</script>
	</body>

</html>