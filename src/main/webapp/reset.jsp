<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:form action="reset">
		<s:textfield name="password" label="password"/>
		<s:submit value="reset"/>
	</s:form>
</body>
</html>