<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
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
    <script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });
    });
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/add" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${user.id}" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">账户名</td>
            <td><input type="text" name="user_name"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        
        <!-- <tr>
		<td>更新时间</td>
		<td>
		
			 <div class="layui-inline">
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="test5" name="update_time" placeholder="yyyy-MM-dd HH:mm:ss">
		      </div>
		    </div>
		</td>
		</tr> -->
		
			 <!-- <div class="layui-inline">
		      <div class="layui-input-inline">
		        <input type="text" name="update_time" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
		      </div>
		    </div> -->
        
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="real_name"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="status" value="0" checked/> 有效
              	<input type="radio" name="status" value="1" /> 失效
            </td>
        </tr>
       <!--  <tr>
            <td class="tableleft">角色</td>
            <td>
            	<select name="role">
        			<option value="">--请选择--
        			<option value="1">管理员
        			<option value="2">院长
            		<option value="3">医生护士
       			 </select>
        	</td>
        </tr> -->
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //常规用法
  laydate.render({
    elem: '#test1'
  });
  laydate.render({
    elem: '#test5'
    ,type: 'datetime'
  });
});
</script>                                                                                      
</body>
</html>