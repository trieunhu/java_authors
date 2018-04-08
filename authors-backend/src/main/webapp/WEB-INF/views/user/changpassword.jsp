<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:message code="oldPassword" var="oldPassword"/>
<spring:message code="newPassword" var="newPassword"/>
<spring:message code="repeatPassword" var="repeatPassword"/>
<h1><spring:message code="changePassword.Title"/></h1>
<c:if test="${success == 1}">
<div class="alert alert-success">
  <spring:message code="changePassword.Title"/>
</div>
</c:if>
<form:form class="form-horizontal" modelAttribute="changePassword">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">${oldPassword}:</label>
    <div class="col-sm-10">
      <form:password path="oldPassword" class="form-control"  placeholder="${oldPassword}"/>
      <form:errors path="oldPassword" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">${newPassword}:</label>
    <div class="col-sm-10">
      <form:password path="newPassword" class="form-control"  placeholder="${newPassword}"/>
      <form:errors path="newPassword" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">${repeatPassword}:</label>
    <div class="col-sm-10">
      <form:password path="repeatPassword" class="form-control"  placeholder="${repeatPassword}"/>
      <form:errors path="repeatPassword" cssClass="error" element="div"/>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10 text-xs-left">
      <button type="submit" class="btn btn-primary">Thay đổi </button>
    </div>
  </div>
</form:form>