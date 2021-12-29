<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Captura una nueva orden de compra

<form:form method="post" action="/orden-compra-web/ordenes/crearOrdenCompra" 
modelAttribute="ordenCompra">
  fecha orden compra: <br>
  <form:input path="fechaCompra" />
  <form:errors path="fechaCompra" />
  <br>
  
   fecha orden status: <br>
  <form:input path="fechaStatus" />
  <form:errors path="fechaStatus" />
  <br>
  
  
  status de la orden: <br>
  <form:select path="status.id">
    <form:options itemLabel="clave"/>
  </form:select>
  
  <input type="submit" value="Registra orden compra">
  
</form:form>

</body>
</html>