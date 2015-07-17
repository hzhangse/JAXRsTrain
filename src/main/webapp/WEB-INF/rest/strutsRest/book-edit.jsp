<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %> 
 <%@taglib prefix="s" uri="/struts-tags" %> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
 <html xmlns="http://www.w3.org/1999/xhtml"> 
 <head> 
    <title> 编辑 ID 为 <s:property value="id"/> 的图书 </title> 
    <link href="<%=request.getContextPath() %>/css/demo.css"
        rel="stylesheet" type="text/css" /> 
 </head> 
 <body> 
 <s:form method="post" 
    action="%{#request.contextPath}/strutsRest/book/%{id}"> 
 <!-- 增加 _method 请求参数，参数值为 put 用于模拟 PUT 操作 --> 
 <s:hidden name="_method" value="put" /> 
 <table> 
    <s:textfield name="id" label="图书 ID" disabled="true"/> 
    <s:textfield name="name" label="书名"/> 
    <s:textfield name="price" label="价格" /> 
    <tr> 
        <td colspan="2"> 
            <s:submit value="修改"/> 
        </td> 
 </table> 
 </s:form> 
 <a href="<%=request.getContextPath() %>/strutsRest/book"> 返回首页 </a> 
 </body> 
 </html>