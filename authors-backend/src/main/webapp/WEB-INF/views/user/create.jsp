<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="Fullname" var="fullname"/>
<spring:message code="Username" var="Username"/>
<spring:message code="Password" var="Password"/>
<spring:message code="Email" var="Email"/>
<form:form class="form-horizontal" modelAttribute="userCreate">
	<h1 class="text-left"><spring:message code="userCreate.Title"/></h1>
	<c:if test="${success == 1}">
		<div class="alert alert-success"><spring:message code="userCreate.success"></spring:message></div>
	</c:if>
	<div class="form-group">
	
		<label class="control-label col-sm-2" for="email">${fullname}:</label>
		<div class="col-sm-10">
			<form:input path="fullname" class="form-control"
				placeholder="${fullname}" />
			<form:errors path="fullname" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
	
		<label class="control-label col-sm-2" for="email">${Username}:</label>
		<div class="col-sm-10">
			<form:input path="username" class="form-control"
				placeholder="${Username}" />
			<form:errors path="username" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
	
		<label class="control-label col-sm-2" for="email">${Password}:</label>
		<div class="col-sm-10">
			<form:password path="password" class="form-control"
				placeholder="${Password}" />
			<form:errors path="password" cssClass="error" element="div" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${Email}:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" placeholder="${Email}" />
			<form:errors path="email" cssClass="error" element="div" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 text-xs-left">
			<button type="submit" class="btn btn-primary"><spring:message code="Create"/></button>
			<a href='<spring:url value="/login"></spring:url>'  class="btn btn-default"><spring:message code="Back"/></a>
		</div>
	</div>
</form:form>