<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>图书展示系统</title>
<link href="<%=request.getContextPath()%>/css/demo.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<s:actionmessage />
	<table>
		<tr>
			<th>图书 ID</th>
			<th>书名</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
		<s:iterator value="model">
			<tr>
				<td><s:property value="id" /></td>
				<td>${name}</td>
				<td>${price}</td>
				<td><a href="book/${id}"> 查看 </a> | <a href="book/${id}/edit">
						编辑 </a> | <a href="book/${id}/deleteConfirm"> 删除 </a></td>
			</tr>
		</s:iterator>
	</table>
	<a href="<%=request.getContextPath()%>/book/new"> 创建新图书 </a>
</body>
</html>