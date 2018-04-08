<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form action="" class="form-signin" method="POST" modelAttribute="model">
<h2 class="form-signin-heading"><spring:message code="Title.loginForm" /></h2>
<c:if test="${param.error != null}">
<div class="alert alert-danger fade in">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <spring:message code="loginForm.error"/>
</div>
</c:if>
        <label for="inputEmail" class="sr-only"><spring:message code="Username" /></label>
        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="<spring:message code="Username" />" required autofocus>
        <label for="inputPassword" class="sr-only"><spring:message code="Password" /></label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="<spring:message code="Password" />" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="Submit.Form.Login"></spring:message></button>
        <a href="<c:url value='/user/create' />" class="btn btn-lg btn-success btn-block" type="submit"><spring:message code="Submit.Form.Register"></spring:message></a>
</form:form>