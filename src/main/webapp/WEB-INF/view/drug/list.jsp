<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看-- -2019</title>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath }/dist/css/bootstrap.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/ckeditor/ckeditor.js"></script>

<style type="text/css">
#images {
	width: 50px;
	height: 50px;
}
</style>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script type="text/javascript">
	$(function() {
		$('#newNav')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/drug/add";
						});
	});
	function checkall() {
		var alls = document.getElementsByName("ids");
		var ch = document.getElementById("checkall");
		if (ch.checked) {
			for (var i = 0; i < alls.length; i++) {
				alls[i].checked = true;
			}
		} else {
			for (var i = 0; i < alls.length; i++) {
				alls[i].checked = false;
			}
		}
	}
	function delAll() {
		var alls = document.getElementsByName("ids");
		var ids = new Array();
		for (var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				ids.push(alls[i].value);
			}
		}
		if (ids.length > 0) {
			if (confirm("确认操作?")) {
				alert("成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/drug/list"
		method="post" class="definewidth m20">

		<select name="filed">
			<option value="drug_num">药品编号</option>
			<option value="purchas_price">药品进价</option>
			<option value="sale_price">药品售价</option>
			<option value="drug_name">药品名称</option>
			<option value="drug_type">药品类型</option>
			<option value="prodeced_date">生产日期</option>
			<option value="expiration_date">过期日期</option>
			<option value="quality_date">保质期</option>
			<option value="manufacture">生产厂商</option>
			<option value="use_infor">使用说明</option>
			<option value="total_stock">总的进货量</option>
			<option value="surplus">剩余量</option>
			<option value="status">状态</option>
		</select> <input type="text" name="keyword" placeholder="关键字">
		<button type="submit" class="btn btn-primary">查询</button>
	</form>
	<form action="<c:url value="/drug/deleteByIds" />" method="get">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall"
						onChange="checkall();"></th>
					<th>序号</th>
					<th>药品编号</th>
					<th>药品图片地址</th>
					<th>药品进价</th>
					<th>药品售价</th>
					<th>药品名称</th>
					<th>药品类型</th>
					<th>简单描述</th>
					<th>生产日期</th>
					<th>过期日期</th>
					<th>保质期</th>
					<th>详细描述</th>
					<th>生产厂商</th>
					<th>使用说明</th>
					<th>总的进货量</th>
					<th>剩余量</th>
					<th>状态</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${drugs }" var="d">
				<tr>
					<td style="vertical-align: middle;"><input type="checkbox"
						value="${d.id }" name="ids"></td>

					<td style="vertical-align: middle;">${d.id }</td>
					<td style="vertical-align: middle;">${d.drug_num }</td>
					<td style="vertical-align: middle;">
						${d.drug_url }
						<img alt="" src="${pageContext.request.contextPath }${path}">
					</td>
					<td style="vertical-align: middle;">${d.purchas_price }</td>
					<td style="vertical-align: middle;">${d.sale_price}</td>
					<td style="vertical-align: middle;">${d.drug_name }</td>
					<td style="vertical-align: middle;">${d.drug_type ==1?"处方药":d.drug_type ==2?"中药" : "西药"}
					</td>
					<td style="vertical-align: middle;">${d.simple_detail }</td>
					<td style="vertical-align: middle;"><fmt:formatDate
							value="${d.prodeced_date}" pattern="yyyy-MM-dd" /></td>
					<td style="vertical-align: middle;"><fmt:formatDate
							value="${d.expiration_date}" pattern="yyyy-MM-dd" /></td>
					<td style="vertical-align: middle;">${d.quality_date }</td>
					<td style="vertical-align: middle;">${d.detail }</td>
					<td style="vertical-align: middle;">${d.manufacture}</td>
					<td style="vertical-align: middle;">${d.use_infor }</td>
					<td style="vertical-align: middle;">${d.total_stock }</td>
					<td style="vertical-align: middle;">${d.surplus}</td>
					<td style="vertical-align: middle;">${d.status ==1?"已过期":d.status==2?"待售出":"已售罄" }
					</td>
					<td style="vertical-align: middle;">${d.noted }</td>

					<td><a class="glyphicon glyphicon-search"
						href="<c:url value="/drug/detail?id=${d.id}" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-pencil"
						href="<c:url value="/drug/edit?id=${d.id}" />"></a> &nbsp;| &nbsp;
						<a class="glyphicon glyphicon-trash"
						href="<c:url value="/drug/delete?id=${d.id }" />"></a></td>
				</tr>
			</c:forEach>

		</table>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th colspan="5">
					<div class="inline pull-right page">
						<p
							style="line-height: 1.6em; text-align: justify; text-indent: 2em; font-size: 16px; font: 微软雅黑; color: green">
							共${page.total }条,当前${page.pageNum }/${page.pages }页</p>
						<nav aria-label="Page navigation">
						<ul class="pagination">
							<li><c:choose>
									<c:when test="${page.pageNum==1 }">
										<a href="#" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value="/drug/list?pageNum=${page.pageNum-1 }&filed=${map.filed }&keyword=${map.keyword }" /> "
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a>
									</c:otherwise>
								</c:choose></li>
							<c:forEach var="i" begin="1" end="${page.pages }" step="1">
								<li><a
									href="<c:url value="/drug/list?pageNum=${i }&filed=${map.filed }&keyword=${map.keyword }" /> ">${i }</a></li>
							</c:forEach>
							<li><c:choose>
									<c:when test="${map.pageNo == map.pageCount }">
										<a href="<c:url value="#" />" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value="/drug/list?pageNum=${page.pageNum+1 }&filed=${map.filed }&keyword=${map.keyword }" /> "
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a>
									</c:otherwise>
								</c:choose></li>
						</ul>
						</nav>
					</div>
					<div>
						<button type="button" class="btn btn-success" id="newNav">添加新药</button>
						<button type="submit" class="btn btn-success" id="delPro">删除选中</button>
						<button type="button" class="btn btn-success" id="delPro">导出txt</button>
					</div>

				</th>
			</tr>

		</table>
	</form>
</body>
</html>
