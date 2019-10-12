<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
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
							window.location.href = "${pageContext.request.contextPath }/user/add";
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
	<form class="form-inline definewidth m20"
		action="<c:url value="list" />" method="get">
		<select name="filed">
			<option value="user_name">用户名</option>
			<option value="password">密码</option>
			<option value="update_time">更新时间</option>
			<option value="status">状态</option>
			<option value="real_name">真实姓名</option>
			<option value="email">电子邮箱</option>
		</select> <input type="text" name="keyword" placeholder="关键字">
		<button type="submit" class="btn btn-primary">查询</button>
	</form>

	<form action="<c:url value="/user/deleteByIds"/>" method="get">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall"
						onChange="checkall();"></th>
					<th>用户编号</th>
					<th>账户名</th>
					<th>密码</th>
					<th>更新时间</th>
					<th>状态</th>
					<th>真实姓名</th>
					<th>电子邮箱</th>
					<!-- <th>角色</th>
        			<th>权限</th> -->
					<th width="10%">操作</th>
				</tr>
			</thead>
			<c:forEach items="${users }" var="u">
				<tr>
					<td style="vertical-align: middle;"><input type="checkbox"
						name="ids" value="${u.id }"></td>
					<td>${u.id }</td>
					<td>${u.user_name }</td>
					<td>${u.password }</td>
					<td><fmt:formatDate value="${u.update_time}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${u.status == 0 ? "失效" : "有效"}</td>
					<td>${u.real_name }</td>
					<td>${u.email }</td>
					<%--  <td>${u.role.role_name }</td>
           			<td>${u.permission.resource_name }</td> --%>
					<td><a class="glyphicon glyphicon-search"
						href="<c:url value="/user/detail?id=${u.id }" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-pencil"
						href="<c:url value="/user/edit?id=${u.id }" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-trash"
						href="<c:url value="/user/delete?id=${u.id }" />"></a></td>
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
											href="<c:url value="/user/list?pageNum=${page.pageNum-1 }&keyword=${map.keyword }&filed=${map.filed }" /> "
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a>
									</c:otherwise>
								</c:choose></li>
							<c:forEach var="i" begin="1" end="${page.pages }" step="1">
								<li><a
									href="<c:url value="/user/list?pageNum=${i }&keyword=${map.keyword }&filed=${map.filed }" /> ">${i }</a></li>
							</c:forEach>
							<li><c:choose>
									<c:when test="${map.pageNo == map.pageCount }">
										<a href="<c:url value="#" />" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value="/user/list?pageNum=${page.pageNum+1 }&keyword=${map.keyword }&filed=${map.filed }" /> "
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a>
									</c:otherwise>
								</c:choose></li>
						</ul>
						</nav>
					</div>
					<div>
						<button type="button" class="btn btn-success" id="newNav">添加用户</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-success" id="delPro"
							onClick="delAll();">删除选中</button>
					</div>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>
