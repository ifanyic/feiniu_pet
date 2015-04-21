<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>super后台——批量订单生成</title>
<link href="<%=basePath%>style/houtai.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${basePath}style/panel-content.css"></link>
<%@ include file="/WEB-INF/pages/back/base/jquery.jsp"%>
<style type="">
.table_label{background: none repeat scroll 0 0 #E2EAF4}
</style>
</head>
<body>
	<div >
		<div class="row1 table_label" style="width:600px">
			<h3 class="newTit">
				销售产品信息
			</h3>
		</div>
		<form id="ordBatchSubmitForm" action="<%=basePath%>distribution/saveBatchOrd.do" method="post" onsubmit="return check();">
			<div class="row2">
				<!-- 签证新增属性 -->
				<table class="p_table form-inline" border="0" cellspacing="0" cellpadding="0" style="width:600px">
					<tr>
						<td class="p_label" width="17%"><em>类别ID：</em></td>
						<td colspan="3"><input type="text" id="branchId" name="branchId" class="newtext1"/><span class="require">[*]</span> <input type="button" class="right-button08" style="width:80px" value="查  询" name="wre" onclick="findProd();"/></td>
					</tr>
					<tr>
						<td class="p_label"><em>产品ID：</em></td>
						<td colspan="3"><input type="text" id="productId" readonly="true"  class="newtext1"/></td>
					</tr>
					<tr>
						<td class="p_label"><em>产品名称：</em></td>
						<td colspan="3"><input type="text" id="productName" readonly="true" class="newtext1"/></td>
					</tr>
					<tr>
						<td class="p_label"><em>类别名称：</em></td>
						<td colspan="3"><input type="text" id="branchName" readonly="true" class="newtext1"/></td>
					</tr>
					<tr>
						<td class="p_label"><em>联系人：</em></td>
						<td colspan="3"><input type="text" name="contactName"class="newtext1" value="批量导码"/></td>
					</tr>
					<tr>
						<td class="p_label"><em>联系人手机：</em></td>
						<td colspan="3"><input type="text" name="contactMobile" value="13800138000" class="newtext1"/><span class="require">[*]</span></td> 
					</tr>
					<tr>
						<td class="p_label"><em>分 销 商：</em></td>
						<td colspan="3"><select name="distributorId">
							<s:iterator var="dist" value="lists">
								<option value="${dist.distributorTuanInfoId}">${dist.distributorName}</option>
							</s:iterator>
						</select></td> 
					</tr>
					<tr>
						<td class="p_label"><em>生成订单数：</em></td>
						<td colspan="3"><input type="text" name="count" class="newtext1"/><span class="require">[*]</span> 一次最多能生成1000笔订单</td> 
					</tr>
					<tr>
						<td class="p_label"><em>生成订单原因：</em></td>
						<td colspan="3"><textarea style="width: 381px; height: 106px;" name="content"></textarea></td> 
					</tr>
				</table>
			</div>
			<p>
				<input type="hidden" value="${token}" name="token"/>
				<input type="submit" value="保  存" id="submitButton"
					class="right-button08" style="width:80px; margin-left:260px;" />
			</p>
		</form>
	</div>
</body>
<script type="text/javascript">
	function findProd(){
		if(checkBranchId()){
			$.ajax({
				url:"/super_back/distribution/findProd.do",
				type:"POST",
				data:{"branchId":$("#branchId").val()},
				success:function(dt){
					if(dt.result=="true"){
						$("#productId").val(dt.prodProductId);				
						$("#productName").val(dt.prodProductName);
						$("#branchName").val(dt.branchName);
					}else{
						alert(dt.result);
						flag = false;
					}
				}
			});
		}
	}

	function checkBranchId(){
		var branchId = $.trim($("input[name=branchId]").val());
		if(branchId==null  || branchId=="" || isNaN(Number(branchId))){
			alert("请填写类别ID");
			return false;
		}
		return true;
	}
	function check(){
		if(!checkBranchId()){
			return false;
		}
		var branchId = $.trim($("input[name=branchId]").val());
		if(branchId==null  || branchId=="" || isNaN(Number(branchId))){
			alert("请填写类别ID");
			return false;
		}
		var count = Number($("input[name=count]").val());
		 if(isNaN(count) || count<=0 ||count >1000){
			alert("请正确填写生成订单数");
			return false;
		}
		var mobile=$.trim($("input[name=contactMobile]").val());
		var MOBILE_REGX = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if (!MOBILE_REGX.test(mobile)) {
			alert("手机号格式不正确");
			return false;
		}
		if($.trim($("textarea[name=content]").val()) == ""){
				alert("下单原因不能为空");
				return false;
		}
		 $("input[name=branchId]").val(branchId);
		 create_order();
		 return false;
		
	}
	
	function create_order(){
		$('#submitButton').attr('disabled',true); 
		$.ajax({
			url:"<%=basePath%>distribution/saveBatchOrd.do",
			type:"POST",
			data:$("#ordBatchSubmitForm").serialize(),
			success:function(dt){
				if(dt.result=="true"){
					alert(dt.message);
					parent.location.href="<%=basePath%>distribution/batch/batchList.do";
				}else{
					alert(dt.message);
				}
				$('#submitButton').attr('disabled',false); 
			}
		});
	}
</script>
</html>