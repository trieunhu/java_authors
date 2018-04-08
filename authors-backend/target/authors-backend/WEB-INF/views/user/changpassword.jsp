<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1>Đổi mật khẩu</h1>
<c:if test="${success == 1}">
<div class="alert alert-success">
  Đổi mật khẩu thành công
</div>
</c:if>
<form:form class="form-horizontal" modelAttribute="changePassword">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Mật khẩu cũ:</label>
    <div class="col-sm-10">
      <form:password path="oldPassword" class="form-control"  placeholder="Mật khẩu cũ"/>
      <form:errors path="oldPassword" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Mật khẩu mới:</label>
    <div class="col-sm-10">
      <form:password path="newPassword" class="form-control"  placeholder="Mật khẩu mới"/>
      <form:errors path="newPassword" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Nhắc lại mật khẩu:</label>
    <div class="col-sm-10">
      <form:password path="repeatPassword" class="form-control"  placeholder="Mật khẩu cũ"/>
      <form:errors path="repeatPassword" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10 text-xs-left">
      <button type="submit" class="btn btn-primary">Thay đổi </button>
    </div>
  </div>
</form:form>