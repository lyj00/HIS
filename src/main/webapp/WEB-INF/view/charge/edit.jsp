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
    	<input type="hidden" name="charge.registrationInfor.id" value="${charge.registrationInfor.id }" />
    	<input type="hidden" name="id" value="${charge.id }" />

    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td><input type="text" name="medical_record" value="${charge.medical_record }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费项目</td>
        <td>
        	<select name="pay_items_id">
		        <option value="1">心脏检查</option>
		        <option value="2">CT</option>
		        <option value="3">尿检</option>
		        <option value="4">抽血化验</option>
		        <option value="5">一般手术费用</option>
		        <option value="6">中等难度手术费用</option>
		        <option value="7">肝脏检查</option>
		        <option value="8">肾脏检查</option>
		        <option value="9">视力检查</option>
		        <option value="10">神经外科检查</option>
		        <option value="11">耳鼻喉科检查</option>
	        </select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费金额</td>
        <td><input type="text" name="charge_money" value="${charge.charge_money }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费时间</td>
        <td>
	        <div class="layui-inline">
		      <div class="layui-input-inline">
		        <input type="text" name="charge_time" value=' <fmt:formatDate value="${charge.charge_time }" pattern="yyyy-MM-dd HH:mm:ss"/> ' class="layui-input" id="test5" placeholder="yyyy-MM-dd HH:mm:ss">
		      </div>
	        </div>
        </td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>
        	<input type="text" name="registrationInfor.name" value="${charge.registrationInfor.name }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td>
	        <select name="registrationInfor.certificate_type">
		        <option value="1">身份证</option>
		        <option value="2">护照</option>
		        <option value="3">军人</option>
	        </select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td>
        	<input type="text" name="registrationInfor.ID_num" value="${charge.registrationInfor.ID_num }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td>
        	<input type="text" name="registrationInfor.social_safe_num" value="${charge.registrationInfor.social_safe_num }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td>
        	<input type="text" name="registrationInfor.registration_fee" value="${charge.registrationInfor.registration_fee }"/>元
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td>
        	<input type="text" name="registrationInfor.phone" value="${charge.registrationInfor.phone }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td>
	        <input type="radio" value="0" name="registrationInfor.self_paying" ${charge.registrationInfor.self_paying=="0" ? "checked='checked'" : ""} />否
			<input type="radio" value="1" name="registrationInfor.self_paying" ${charge.registrationInfor.self_paying=="1" ? "checked='checked'" : ""} />是
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>
			<input type="radio" value="0" name="registrationInfor.sex" ${charge.registrationInfor.sex=="0" ? "checked='checked'" : ""} />女
			<input type="radio" value="1" name="registrationInfor.sex" ${charge.registrationInfor.sex=="1" ? "checked='checked'" : ""} />男
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>
        	<input type="text" name="registrationInfor.age" value="${charge.registrationInfor.age }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td>
        	<input type="text" name="registrationInfor.career" value="${charge.registrationInfor.career }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td>
	        <input type="radio" name="registrationInfor.early_appointment" value="初诊" ${charge.registrationInfor.early_appointment=="初诊" ? "checked='checked'" : ""}/>初诊&nbsp;&nbsp;&nbsp;
	        <input type="radio" name="registrationInfor.early_appointment" value="复诊" ${charge.registrationInfor.early_appointment=="复诊" ? "checked='checked'" : ""}/>复诊
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>
	        <select name="registrationInfor.section_id">
		        <option value="1">血液科</option>
		        <option value="2">骨科</option>
		        <option value="3">外科</option>
		        <option value="4">急诊科</option>
		        <option value="5">妇科</option>
	        </select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td>
	        <select name="registrationInfor.doctor_id">
		        <option value="1">华佗</option>
		        <option value="2">扁鹊</option>
		        <option value="3">李时珍</option>
	        </select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">状态</td>
        <td>
	        <select name="registrationInfor.status" >
		        <option>已出院</option>
		        <option>已结算</option>
		        <option>已挂号</option>
	        </select>
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td ><textarea name="registrationInfor.noted" value="${charge.registrationInfor.noted }"></textarea></td>
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
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  laydate.render({
	    elem: '#test5'
	    ,type: 'datetime'
	    ,trigger: 'click'
	  });
  });
</script>
</body>
</html>