<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">账户名</td>
            <td>
            	${user.user_name }
			</td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td>
            	${user.password }
            </td>
        </tr>
        <tr>
            <td class="tableleft">更新时间</td>
            <td>
				<fmt:formatDate value="${user.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td>${user.real_name }
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td>${user.email }</td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                ${user.status ==1 ? "有效" : "失效" }
            </td>
        </tr>
        <!-- <tr>
            <td class="tableleft">角色</td>
            <td>
            	<select name="role">
        			<option value="">--请选择--
        			<option value="1" selected>管理员
        			<option value="2">院长
            		<option value="3">医生护士
       			 </select>
        	</td>
        </tr> -->
       <!--  <tr>
            <td class="tableleft"></td>
            <td>
                <button type="reset" class="btn btn-primary" type="button">确定</button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr> -->
    </table>
                                                                                            
</body>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });
    });
</script>
</html>