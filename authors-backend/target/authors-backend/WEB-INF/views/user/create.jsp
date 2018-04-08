<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<h1>Tạo người dùng mới</h1>
<c:if test="${success == 1}">
	<div class="alert alert-success">Tạo người dùng thành công</div>
</c:if>
<form:form class="form-horizontal" modelAttribute="userCreate">
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Họ và tên:</label>
		<div class="col-sm-10">
			<form:input path="fullname" class="form-control"
				placeholder="Họ và tên" />
			<form:errors path="fullname" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Tên đăng
			nhập</label>
		<div class="col-sm-10">
			<form:input path="username" class="form-control"
				placeholder="Tên đăng nhập" />
			<form:errors path="username" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Mật khẩu</label>
		<div class="col-sm-10">
			<form:password path="password" class="form-control"
				placeholder="Mật khẩu" />
			<form:errors path="password" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" placeholder="Email" />
			<form:errors path="email" cssClass="error" element="div" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 text-xs-left">
			<button type="submit" class="btn btn-primary">Tạo mới</button>
		</div>
	</div>
</form:form>