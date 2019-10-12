<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 通过new Form 表单对象,从表单对象中获得上传的文件对象
将这个对象通过ajax发送到后台 -->

<form action="#" id = "formId">
	<input type="file" name="img">
	<input type="button" value="上传" onclick="doUpload()">
</form>
<div>
	<img id="i1" width="500px" height="500px" alt="" src="http://java2101/group1/M00/00/00/wKidgF2Ir2mADcuHAAAyH04a2mU711.jpg">
</div>

</body>
<script type="text/javascript" src="Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	function doUpload(){
		// 创建form表单对象
		var formData = new FormData($("#formId")[0]);
		// ajax发送请求 返回图片地址 赋值给img标签
		$.ajax({
			url:"/hhh/upload.do",
			type:"POST",
			data:formData,
			async:false,
			contentType:false,
			processData:false,
			success:function(data){
				alert(data.obj);
				$("#i1").attr("src","${pageContext.request.contextPath }"+data.obj);
			
			}
		
		});
	}


</script>
</html>