<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 	<link href="${pageContext.request.contextPath }/dist/css/bootstrap.css" rel="stylesheet" >
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/laydate.js"></script>
	<link href="${pageContext.request.contextPath }/layui/css/modules/laydate/default/laydate.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckeditor/ckeditor.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/charge/edit" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">

    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td>${charge.medical_record }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费项目</td>
        <td>${charge.payItems.charge_item_name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费金额</td>
        <td>${charge.charge_money }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费时间</td>
        <td>
		    <fmt:formatDate value="${charge.charge_time }" pattern="yyyy-MM-dd HH:mm:ss"/> 
        </td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>
        	${charge.registrationInfor.name }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td>
        	${charge.registrationInfor.certificate_type }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td>
        	${charge.registrationInfor.ID_num }
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td>
        	${charge.registrationInfor.social_safe_num }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td>
        	${charge.registrationInfor.registration_fee }元
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td>
        	${charge.registrationInfor.phone }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td>
        	${charge.registrationInfor.self_paying }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>
        	${charge.registrationInfor.sex }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>
        	${charge.registrationInfor.age }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td>
        	${charge.registrationInfor.career }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td>
        	${charge.registrationInfor.early_appointment }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>
        	${charge.registrationInfor.section_id }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td>
        	${charge.registrationInfor.doctor_id }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">状态</td>
        <td>
        	${charge.registrationInfor.status }
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td >${charge.registrationInfor.noted }</td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>