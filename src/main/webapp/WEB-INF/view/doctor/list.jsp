<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>门诊医生---2019</title>
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
							window.location.href = "${pageContext.request.contextPath }/doctor/add";
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

	<form action="${pageContext.request.contextPath }/doctor/list"
		method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">医生编号：</td>
				<td><input type="text" name="id" placeholder="关键字" /></td>

				<td width="10%" class="tableleft">医生姓名：</td>
				<td><input type="text" name="dname" placeholder="关键字" /></td>

				<td width="10%" class="tableleft">科室：</td>
				<td><input type="text" name="section" placeholder="关键字" /></td>
			</tr>
			<tr>
				<td colspan="6">
					<center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="submit" class="btn btn-primary" type="button">清空</button>
					</center>
				</td>
			</tr>
		</table>
	</form>
	<form action="<c:url value="/doctor/deleteByIds" />" method="get">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall"
						onChange="checkall();"></th>
					<th>医生编号</th>
					<th>医生姓名</th>
					<th>证件类型</th>
					<th>证件号</th>
					<th>手机号</th>
					<th>座机号</th>
					<th>性别</th>
					<th>年龄</th>
					<th>生日</th>
					<th>邮箱</th>
					<th>所属科室</th>
					<th>学历</th>
					<th>备注</th>
					<th>入院时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${doctors }" var="d">
				<tr>
					<td style="vertical-align: middle;"><input type="checkbox"
						name="ids" value="${d.id }"></td>
					<td>${d.id }</td>
					<td>${d.name }</td>
					<td>${d.certificateType.name }</td>
					<td>${d.ID_num}</td>
					<td>${d.phone }</td>
					<td>${d.special_plane}</td>
					<td>${d.sex ==0?"男" : "女" }</td>

					<td>${d.age }</td>
					<td>${d.birther } <%-- <fmt:formatDate value="${d.birther }" pattern="yyyy-MM-dd"/> --%>
					</td>
					<td>${d.email }</td>
					<td>${d.section.secco_name }</td>
					<td>${d.education==1?"专科":d.education==2?"本科":d.education==3?"博士":"博士后" }</td>
					<td>${d.noted }</td>
					<td><fmt:formatDate value="${d.time}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><a class="glyphicon glyphicon-search"
						href="<c:url value="/doctor/detail?id=${d.id}" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-pencil"
						href="<c:url value="/doctor/edit?id=${d.id}" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-trash"
						href="<c:url value="/doctor/delete?id=${d.id }" />"></a></td>
				</tr>
			</c:forEach>

		</table>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th colspan="5">
					<div class="inline pull-right page">
						<a
							href='${pageContext.request.contextPath }/doctor/list?pageNum=${page.firstPage} '>第一页</a>
						<c:if test="${page.hasPreviousPage }">
							<a
								href='${pageContext.request.contextPath }/doctor/list?pageNum=${page.pageNum-1}&id=${keywordMap.id }&section=${keywordMap.section }&dname=${keywordMap.dname }'>上一页</a>
						</c:if>
						<c:forEach var="i" begin="1" end="${page.pages }" step="1">
							<a class="${page.pageNum == i? 'current' : '' }"
								href='${pageContext.request.contextPath }/doctor/list?pageNum=${i}&id=${keywordMap.id }&section=${keywordMap.section }&dname=${keywordMap.dname }'>${i }</a>
						</c:forEach>
						<c:if test="${page.hasNextPage }">
							<a
								href='${pageContext.request.contextPath }/doctor/list?pageNum=${page.pageNum+1}&id=${keywordMap.id }&section=${keywordMap.section }&dname=${keywordMap.dname }'>下一页</a>
						</c:if>
						<a
							href='${pageContext.request.contextPath }/doctor/list?pageNum=${page.lastPage}'>最后一页</a>
						&nbsp;&nbsp;&nbsp; 共<span class='current'>${page.total }</span>&nbsp;条记录&nbsp;&nbsp;&nbsp;
						第<span class='current'> ${page.pageNum }/${page.pages } </span>页
					</div>

					<div>
						<button type="button" class="btn btn-success" id="newNav">添加新医生</button>
						<button type="submit" class="btn btn-success" id="delPro">删除选中</button>
					</div>

				</th>
			</tr>
		</table>

	</form>
</body>
</html>
