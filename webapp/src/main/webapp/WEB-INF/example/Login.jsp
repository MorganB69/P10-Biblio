<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
</head>

<body>
<s:actionerror/>
<s:actionmessage/>
<s:form action="Login">
    <s:textfield label="Identifiant" name="login"/>
    <s:password label="Mot de passe" name="password" />
    <s:submit/>
</s:form>
</body>
</html>
