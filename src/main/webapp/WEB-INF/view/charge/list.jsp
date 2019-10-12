<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>收费项目管理-- -2019</title>
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
		$('#newNav').click(function() {
			window.location.href = "${pageContext.request.contextPath }/charge/add";
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
	$(function() {
		$('#backid').click(function() {
			window.location.href = "dispensing.html";
		});
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/charge/list"
		method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">病历号：</td>
				<td><input type="text" name="medicalRecord" value="" /></td>

				<td width="10%" class="tableleft">姓名：</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td colspan="4">
					<center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="submit" class="btn btn-primary" type="button">清空</button>
					</center>
				</td>
			</tr>
		</table>
	</form>
<form action="<c:url value="/charge/deleteByIds" />"  method="get">
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkall"
						onChange="checkall();"></th>
				<th>编号</th>
				<th>病历号</th>
				<th>姓名</th>
				<th>收费项目</th>
				<th>收费金额</th>
				<th>收费日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${charges }" var="c">
			<tr>
				<td style="vertical-align: middle;"><input type="checkbox"
					value="${c.id }" name="ids"></td>

				<td style="vertical-align: middle;">${c.id }</td>
				<td style="vertical-align: middle;">${c.medical_record }</td>
				<td style="vertical-align: middle;">${c.registrationInfor.name }</td>
				<td style="vertical-align: middle;">${c.payItems.charge_item_name }</td>
				<td style="vertical-align: middle;">${c.charge_money }</td>
				<td style="vertical-align: middle;"><fmt:formatDate
						value="${c.charge_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><a class="glyphicon glyphicon-search"
					href="<c:url value="/charge/detail?medical_record=${c.medical_record}" />"></a> &nbsp;|
					&nbsp; <a class="glyphicon glyphicon-pencil"
					href="<c:url value="/charge/edit?medical_record=${c.medical_record}" />"></a> &nbsp;|
					&nbsp; <a class="glyphicon glyphicon-trash"
					href="<c:url value="/charge/delete?id=${c.id }" />"></a></td>
			</tr>
		</c:forEach>
	</table>
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<th colspan="5">
				<div class="inline pull-right page">
					<a
						href='${pageContext.request.contextPath }/charge/list?pageNum=${page.firstPage} '>第一页</a>
					<c:if test="${page.hasPreviousPage }">
						<a
							href='${pageContext.request.contextPath }/charge/list?pageNum=${page.pageNum-1}&medicalRecord=${keywordMap.medicalRecord }&name=${keywordMap.name }'>上一页</a>
					</c:if>
					<c:forEach var="i" begin="1" end="${page.pages }" step="1">
						<a class="${page.pageNum == i? 'current' : '' }"
							href='${pageContext.request.contextPath }/charge/list?pageNum=${i}&medicalRecord=${keywordMap.medicalRecord }&name=${keywordMap.name }'>${i }</a>
					</c:forEach>
					<c:if test="${page.hasNextPage }">
						<a
							href='${pageContext.request.contextPath }/charge/list?pageNum=${page.pageNum+1}&medicalRecord=${keywordMap.medicalRecord }&name=${keywordMap.name }'>下一页</a>
					</c:if>
					<a
						href='${pageContext.request.contextPath }/charge/list?pageNum=${page.lastPage}'>最后一页</a>
					&nbsp;&nbsp;&nbsp; 共<span class='current'>${page.total }</span>&nbsp;条记录&nbsp;&nbsp;&nbsp;
					第<span class='current'> ${page.pageNum }/${page.pages } </span>页
				</div>
				<div>
					<button type="button" class="btn btn-success" id="newNav">添加收费项目</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-success" id="delPro"
							onClick="delAll();">删除选中</button>
						&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
						<button type="button" class="btn btn-success" id="delPro">打印</button>

					</div>

			</th>
		</tr>
	</table>
	</form>


</body>
</html>
