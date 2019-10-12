<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>门诊查询-- -2015</title>
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
							window.location.href = "${pageContext.request.contextPath }/reg/add";
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

	<form action="${pageContext.request.contextPath }/reg/list"
		method="get" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">病历号：</td>
				<td><input type="text" name="medicalRecord"
					value="${keywordMap.medicalRecord }" placeholder="关键字"></td>

				<td width="10%" class="tableleft">主治医生：</td>
				<td><input type="text" name="doctorName" placeholder="关键字">
				</td>

				<td width="10%" class="tableleft">科室：</td>
				<td><input type="text" name="section" placeholder="关键字">
				</td>
			</tr>
			<tr>

				<td width="10%" class="tableleft">挂号时间：</td>

				<td colspan="5"><input type="date" name="startTime"
					placeholder="起始时间" />&nbsp;至&nbsp; <input type="date"
					name="endTime" placeholder="结束时间" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary" type="button">查询</button>
					<button type="submit" class="btn btn-primary" type="button">清空</button>

				</td>
			</tr>
		</table>
	</form>
	<form action="<c:url value="/reg/deleteByIds" />" method="post">

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall"
						onChange="checkall();"></th>
					<th>门诊编号</th>
					<th>病例</th>
					<th>姓名</th>
					<th>证件类型</th>
					<th>证件号码</th>
					<th>社保号</th>
					<th>手机号</th>
					<th>是否自费</th>
					<th>性别</th>
					<th>职业</th>
					<th>早期诊断</th>
					<th>主治医生</th>
					<th>状态</th>
					<th>备注</th>
					<th>挂号时间</th>
					<th>挂号科室</th>
					<th>年龄</th>
					<th>挂号费</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${regs }" var="r">
				<tr>
					<td style="vertical-align: middle;"><input type="checkbox"
						name="ids" value="${r.id }"></td>
					<td>${r.id }</td>
					<td>${r.medical_record }</td>
					<td>${r.name }</td>
					<td>${r.certificateType.name }</td>
					<td>${r.ID_num }</td>
					<td>${r.social_safe_num }</td>
					<td>${r.phone }</td>
					<td>${r.self_paying ==1?"是":"否" }</td>
					<td>${r.sex==1?"男":"女" }</td>
					<td>${r.career }</td>
					<td>${r.early_appointment }</td>
					<td>${r.doctor.name}</td>
					<td>${r.status }</td>
					<td>${r.noted }</td>
					<td><fmt:formatDate value="${r.time}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${r.section.secco_name }</td>
					<td>${r.age }</td>
					<td>${r.registration_fee }</td>

					<td><a class="glyphicon glyphicon-search"
						href="<c:url value="/reg/detail?id=${r.id }" />"></a> &nbsp;|
						&nbsp; <a class="glyphicon glyphicon-pencil"
						href="<c:url value="/reg/edit?id=${r.id }" />"></a> &nbsp;| &nbsp;
						<a class="glyphicon glyphicon-trash"
						href="<c:url value="/reg/delete?id=${r.id }" />"></a></td>
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
											href="<c:url value="/reg/list?pageNum=${page.pageNum-1 }&medicalRecord=${keywordMap.medicalRecord }&section=${keywordMap.section }&doctorName=${keywordMap.doctorName }&startTime=${keywordMap.startTime }&endTime=${keywordMap.endTime }" /> "
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a>
									</c:otherwise>
								</c:choose></li>
							<c:forEach var="i" begin="1" end="${page.pages }" step="1">
								<li><a
									href="<c:url value="/reg/list?pageNum=${i }&medicalRecord=${keywordMap.medicalRecord }&section=${keywordMap.section }&doctorName=${keywordMap.doctorName }&startTime=${keywordMap.startTime }&endTime=${keywordMap.endTime }" /> ">${i }</a></li>
							</c:forEach>
							<li><c:choose>
									<c:when test="${map.pageNo == map.pageCount }">
										<a href="<c:url value="#" />" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value="/reg/list?pageNum=${page.pageNum+1 }&medicalRecord=${keywordMap.medicalRecord }&section=${keywordMap.section }&doctorName=${keywordMap.doctorName }&startTime=${keywordMap.startTime }&endTime=${keywordMap.endTime }" /> "
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a>
									</c:otherwise>
								</c:choose></li>
						</ul>
						</nav>
					</div>
					<div>
						<button type="button" class="btn btn-success" id="newNav">门诊挂号</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-success" id="delPro"
							onClick="delAll();">退号</button>
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
