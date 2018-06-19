<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
   
</head>

<body>
<div class="row">
<header>


<div class="layer">
</div>

<s:include value="include/nav.jsp"></s:include> 




</header>
</div>

<div class="row justify-content-center">
    <h2><s:text name="error.title" /></h2>
</div>
<div class="row justify-content-center">
    <s:actionerror />
</div>
<div class="row justify-content-center">
    <s:bean name="java.util.Date" var="now" />
    <s:text name="error.metadata">
        <s:param value="now" />
    </s:text>
</div>
</body>
</html>
