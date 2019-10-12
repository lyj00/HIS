<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckeditor/ckeditor.js"></script>
 
</head>
<body>
<form action="<c:url value="/drug/edit" />" method="post" enctype="multipart/form-data" class="definewidth m20" >
<table class="table table-bordered table-hover definewidth m10">
   <input type="hidden" name="id" value="${drug.id }" />
   
    <tr>
        <td width="10%" class="tableleft">药品编号</td>
        <td><input type="text" name="drug_num" value="${drug.drug_num }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">图片</td>
        <td><input type="file" name="img" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">进价</td>
        <td><input type="text" name="purchas_price" value="${drug.purchas_price }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">售价</td>
        <td><input type="text" name="sale_price" value="${drug.sale_price }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td><input type="text" name="drug_name" value="${drug.drug_name }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品类型</td>
        <td>
        	<input type="radio" value="1" name="drug_type" ${drug.drug_type=="1" ? "checked='checked'" : ""} />处方药&nbsp;&nbsp;&nbsp;
			<input type="radio" value="2" name="drug_type" ${drug.drug_type=="2" ? "checked='checked'" : ""} />中药&nbsp;&nbsp;&nbsp;
			<input type="radio" value="3" name="drug_type" ${drug.drug_type=="3" ? "checked='checked'" : ""} />西药&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">简单描述</td>
        <td><input type="text" name="simple_detail" value="${drug.simple_detail }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产日期</td>
        <td>
        <div class="layui-inline">
		      <div class="layui-input-inline">
		        <input type="text" name="prodeced_date" class="layui-input" id="test1" value=' <fmt:formatDate value="${drug.prodeced_date }" pattern="yyyy-MM-dd"/>' >
		      </div>
		    </div>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">过期日期</td>
        <td>
        
	    <div class="layui-inline">
	      <div class="layui-input-inline">
	        <input type="text" class="layui-input" name="expiration_date" id="test1-1" value=' <fmt:formatDate value="${drug.expiration_date }" pattern="yyyy-MM-dd"/> ' >
	      </div>
	    </div>
       
    </tr>
    <tr>
        <td width="10%" class="tableleft">保质期</td>
        <td><input type="text" name="quality_date" value="${drug.quality_date }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">详细描述</td>
        <td><textarea name="detail" value="${drug.detail }"></textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产厂商</td>
        <td><textarea name="manufacture" value="${drug.manufacture }"></textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">服用说明</td>
        <td><input type="text" name="use_infor" value="${drug.use_infor }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">总的进货量</td>
        <td><input type="text" name="total_stock" value="${drug.total_stock }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">剩余量</td>
        <td><input type="text" name="surplus" value="${drug.surplus }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">状态</td>
        <td>
        	<input type="radio" value="1" name="status" ${drug.status=="1" ? "checked='checked'" : ""} />已过期&nbsp;&nbsp;&nbsp;
			<input type="radio" value="2" name="status" ${drug.status=="2" ? "checked='checked'" : ""} />待售出&nbsp;&nbsp;&nbsp;
			<input type="radio" value="3" name="status" ${drug.status=="3" ? "checked='checked'" : ""} />已售罄&nbsp;&nbsp;&nbsp;

        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><input name="noted" value="${drug.noted }"/></td>
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
    	  elem: '#test1'
          ,trigger: 'click'
      });
      laydate.render({
   	    elem: '#test1-1'
   	    ,lang: 'en'
   	    ,trigger: 'click'

      });
  });
</script> 
</body>
</html>