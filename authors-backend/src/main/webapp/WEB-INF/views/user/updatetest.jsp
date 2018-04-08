<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1>Cập nhật thông tin cá nhân</h1>
<c:if test="${success == 1}">
<div class="alert alert-success">
  Chỉnh sửa thông tin thành công
</div>
</c:if>
<form:form class="form-horizontal" modelAttribute="userCreate">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Họ và tên:</label>
    <div class="col-sm-10">
      <form:input path="fullname" class="form-control"  placeholder="Họ và tên"/>
      <form:errors path="fullname" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10 text-xs-left">
      <button type="submit" class="btn btn-primary">Cập nhật </button>
    </div>
  </div>
</form:form>
</body>
</html>
