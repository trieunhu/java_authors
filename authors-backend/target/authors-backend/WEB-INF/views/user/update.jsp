<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1>Cập nhật thông tin cá nhân</h1>
<c:if test="${success == 1}">
<div class="alert alert-success">
  Chỉnh sửa thông tin thành công
</div>
</c:if>
<form:form class="form-horizontal" modelAttribute="userUpdate">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email:</label>
    <div class="col-sm-10">
      <form:input path="email" class="form-control"  placeholder="Email"/>
      <form:errors path="email" cssClass="error" element="div"/>
    </div>
  </div>
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