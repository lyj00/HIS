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
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">药品编号</td>
        <td>${drug.drug_num }</td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">图片</td>
        <td>
        	<img alt=""
        	 src="${pageContext.request.contextPath }${drug.drug_url}" >
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">进价</td>
        <td>${drug.purchas_price }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">售价</td>
        <td>${drug.sale_price }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td>${drug.drug_name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品类型</td>
        <td>
        	${drug.drug_type == 1?"处方药":drug.drug_type == 2?"中药":"西药" }
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">简单描述</td>
        <td>${drug.simple_detail }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产日期</td>
        <td>
		    <fmt:formatDate value="${drug.prodeced_date }" pattern="yyyy-MM-dd"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">过期日期</td>
        <td>
	        <fmt:formatDate value="${drug.expiration_date }" pattern="yyyy-MM-dd"/>
    </tr>
    <tr>
        <td width="10%" class="tableleft">保质期</td>
        <td>${drug.quality_date }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">详细描述</td>
        <td>${drug.detail }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产厂商</td>
        <td>${drug.manufacture }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">服用说明</td>
        <td>${drug.use_infor }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">总的进货量</td>
        <td>${drug.total_stock }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">剩余量</td>
        <td>${drug.surplus }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">状态</td>
        <td>
        	${drug.status == 1?"已过期":drug.status == 2?"待出售":drug.status == 3?"待检测":drug.status == 4?"已售罄":"待进货" }
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${drug.noted }</td>
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