<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="align-content: center;">
	<s:form action="register">
<s:textfield name="name" label="name"/>

<s:textfield name="email" label="Email"/>
<s:textfield name="password" label="password"/>
<s:textfield name="phoneNumber" label="phoneNumber"/>
<s:submit value="register"/>
	</s:form>

</body>
</html>