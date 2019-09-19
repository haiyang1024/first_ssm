<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>He后台</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				订单管理 <small>订单表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/orders/findAll.do/?currentPage=1&pageSize=5"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/orders/findAll.do/?currentPage=1&pageSize=5">订单管理</a></li>
				<li class="active">订单表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form action="${pageContext.request.contextPath}/orders/save.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">订单信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">订单编号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="orderNum"
								placeholder="订单编号" value="">
						</div>
						<div class="col-md-2 title">订单时间</div>
						<div class="col-md-4 data">
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									   id="datepicker-a3" name="orderTime">
							</div>
						</div>
						<div class="col-md-2 title">订单人数</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="peopleCount"
								   placeholder="订单人数" value="">
						</div>
						<div class="col-md-2 title">支付类型</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
									name="payType">
								<option value="0" selected="selected">支付宝</option>
								<option value="1">微信</option>
							</select>
						</div>

						<div class="col-md-2 title">订单状态</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
								name="orderStatus">
								<option value="0">关闭</option>
								<option value="1" selected="selected">开启</option>
							</select>
						</div>
						<div class="col-md-2 title">产品</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
									name="productId" id="productId">
								<%--<option value="0" selected="selected">北京三日游</option>
								<option value="1">上海三日游</option>--%>
	                        </select>
	                    </div>
                        <div class="col-md-2 title">会员</div>
                        <div class="col-md-4 data">
                            <select class="form-control select2" style="width: 100%"
                                name="memberId" id="memberId">

                            </select>
                        </div>
                        <div class="col-md-2 title" >订单描述</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="orderDesc"
                                    placeholder="订单描述" value="">
                        </div>
                </div>
			</div>
			<!--订单信息/--> <!--工具栏-->
			<div class="box-tools text-center">
			<button type="submit" class="btn bg-maroon">保存</button>
			<button type="button" class="btn bg-default"
	onclick="history.back(-1);">返回</button>
			</div>
			<!--工具栏/--> </section>
			<!-- 正文区域 /-->
			</form>
			</div>
			<!-- 内容区域 /-->

			<!-- 底部导航 -->
			<footer class="main-footer">
			<div class="pull-right hidden-xs">
			<b>Version</b> 1.0
			</div>
			<strong>Copyright &copy; 2019-2019 <a
	href="http://www.itcast.cn">研究院研发部</a>.
			</strong> All rights reserved. </footer>
	<!-- 底部导航 /-->

	</div>


	<script
	src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
		<script
				src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
		<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script>
        $(function () {
            $.ajax({
				url:"${pageContext.request.contextPath}/product/findAll2.do",
				type:"get",
				dataType:"json",
				success:function (result) {
					var msg = result.msg;
					if (msg == 'success') {
						$("#productId").empty();//清空下拉框
						var str = "<option>请选择产品名称</option>";
						for (var i = 0; i < result.productJson.length; i++) {
							var productName = result.productJson[i].productName;
							var productId = result.productJson[i].id;//获取第i个对象的id，{}对象 [{},{},{}]数组里面存的是对象
							str = str + '<option value="' + productId + '">' + productName + "</option>";
						}
						$("#productId").append(str);
					}
				}
			});
			$.ajax({
				url:"${pageContext.request.contextPath}/member/findAll.do",
				type:"get",
				dataType:"json",
				success:function (result) {
					var msg = result.msg;
					if (msg=='success'){
						$("#memberId").empty();//清空下拉框
						var str="<option>请选择会员名称</option>";
						for (var i = 0; i < result.memberJson.length; i++) {
							var name = result.memberJson[i].name;
							var id = result.memberJson[i].id;
							str=str+"<option value='"+id+"'>"+name+"</option>"
						}
						$("#memberId").append(str);

					}

				}
			});
        });
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {
			$('#datepicker-a3').datetimepicker({
				format : "yyyy-mm-dd hh:mm:ss",
				autoclose : true,
				todayBtn : true,
				language : "zh-CN"
			});
		});

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("order-manage");
			$("#datepicker-a3").datetimepicker({
				format : "yyyy-mm-dd hh:ii",

			});

		});
	</script>


</body>

</html>