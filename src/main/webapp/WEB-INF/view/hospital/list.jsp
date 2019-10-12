<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>入院办理-- -2019</title>
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
		$('#newNav').click(function() {
			window.location.href = "add.html";
		});
	});

	function checkall() {
		var alls = document.getElementsByName("check");
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
		var alls = document.getElementsByName("check");
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

	<form action="${pageContext.request.contextPath }/hospital/list"
		method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">病例号：</td>
				<td><input type="text" name="medicalRecord" value="" /></td>

				<td width="10%" class="tableleft">主治医生：</td>
				<td><input type="text" name="hospital" value="" /></td>

				<td width="10%" class="tableleft">科室：</td>
				<td><input type="text" name="section" value="" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">住院时间：</td>
				<td colspan="5"><input type="date" name="startTime" value="" />&nbsp;至&nbsp;
					<input type="date" name="endTime" value="" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary" type="button">查询</button>
					<button type="submit" class="btn btn-primary" type="button">清空</button>
				</td>
			</tr>
		</table>
	</form>
	<form action="<c:url value="/hospital/deleteByIds" />" method="get">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall"
						onChange="checkall();"></th>
					<th>编号</th>
					<th>病历号</th>
					<th>护理人</th>
					<th>床位号</th>
					<th>押金</th>
					<th>主治医生</th>
					<th>入院时间</th>
					<th>科室</th>
					<th>病情状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${hospitals }" var="h">
				<tr>
					<td style="vertical-align: middle;"><input type="checkbox"
						name="check" value="${h.id }"></td>
					<td style="vertical-align: middle;">${h.id }</td>
					<td style="vertical-align: middle;">${h.medical_record }</td>
					<td style="vertical-align: middle;">${h.caregiver }</td>
					<td style="vertical-align: middle;">${h.bed_id }</td>
					<td style="vertical-align: middle;">${h.pay_the_deposit }</td>
					<td style="vertical-align: middle;">${h.doctor.name }</td>
					<td style="vertical-align: middle;"><fmt:formatDate
							value="${h.time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td style="vertical-align: middle;">${h.section.secco_name }</td>
					<td style="vertical-align: middle;">${h.state_illness }</td>
					<td><a class="glyphicon glyphicon-search"
						href="<c:url value="/hospital/detail?id=${h.id }" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-pencil"
						href="<c:url value="/hospital/edit?id=${h.id }" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-trash"
						href="<c:url value="/hospital/delete?id=${h.id }" />"></a></td>
				</tr>
			</c:forEach>
		</table>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th colspan="5">
					<div class="inline pull-right page">
						<a
							href='${pageContext.request.contextPath }/hospital/list?pageNum=${page.firstPage} '>第一页</a>
						<c:if test="${page.hasPreviousPage }">
							<a
								href='${pageContext.request.contextPath }/hospital/list?pageNum=${page.pageNum-1}&medicalRecord=${keywordMap.medicalRecord }&section=${keywordMap.section }&doctorName=${keywordMap.doctorName }&startTime=${keywordMap.startTime }&endTime=${keywordMap.endTime } '>上一页</a>
						</c:if>
						<c:forEach var="i" begin="1" end="${page.pages }" step="1">
							<a class="${page.pageNum == i? 'current' : '' }"
								href='${pageContext.request.contextPath }/hospital/list?pageNum=${i}&medicalRecord=${keywordMap.medicalRecord }&section=${keywordMap.section }&doctorName=${keywordMap.doctorName }&startTime=${keywordMap.startTime }&endTime=${keywordMap.endTime }'>${i }</a>
						</c:forEach>
						<c:if test="${page.hasNextPage }">
							<a
								href='${pageContext.request.contextPath }/hospital/list?pageNum=${page.pageNum+1}&medicalRecord=${keywordMap.medicalRecord }&section=${keywordMap.section }&doctorName=${keywordMap.doctorName }&startTime=${keywordMap.startTime }&endTime=${keywordMap.endTime }'>下一页</a>
						</c:if>
						<a
							href='${pageContext.request.contextPath }/hospital/list?pageNum=${page.lastPage}'>最后一页</a>
						&nbsp;&nbsp;&nbsp; 共<span class='current'>${page.total }</span>&nbsp;条记录&nbsp;&nbsp;&nbsp;
						第<span class='current'> ${page.pageNum }/${page.pages } </span>页
					</div>
					<div>
						<button type="button" class="btn btn-success" id="newNav">录入住院信息</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-success" id="delPro"
							onClick="delAll();">出院</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-success" id="delPro"
							onClick="delAll();">退院</button>
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
