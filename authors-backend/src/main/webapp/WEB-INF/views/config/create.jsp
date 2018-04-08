<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="nameApp" var="nameApp" />
<spring:message code="contentFooter" var="contentFooter" />
<spring:message code="numberPostBackend" var="numberPostBackend" />
<spring:message code="numberPostFrontend" var="numberPostFrontend" />
<form:form class="form-horizontal" modelAttribute="configCreate">
	<h1 class="text-left">
		<spring:message code="configCreate.Title" />
	</h1>
	<c:if test="${success == 1}">
		<div class="alert alert-success">
			<spring:message code="configCreate.success"></spring:message>
		</div>
	</c:if>
	<div class="form-group">

		<label class="control-label col-sm-2" for="email">${nameApp}:</label>
		<div class="col-sm-10">
			<form:input path="nameApp" class="form-control"
				placeholder="${nameApp}" />
			<form:errors path="nameApp" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">

		<label class="control-label col-sm-2" for="email">${contentFooter}:</label>
		<div class="col-sm-10">
			<form:input path="contentFooter" class="form-control"
				placeholder="${contentFooter}" />
			<form:errors path="contentFooter" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${numberPostBackend}</label>
		<div class="col-sm-10">
			<form:select path="numberPostBackend" class="form-control">
				<form:option value="1" label="1" />
				<c:forEach begin="1" end="20" var="i">
					<c:if test="${ i % 5 == 0 }">
						<form:option value="${i}" label="${i}" />
					</c:if>
				</c:forEach>
			</form:select>
			<form:errors path="numberPostBackend" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${numberPostFrontend}</label>
		<div class="col-sm-10">
			<form:select path="numberPostFrontend" class="form-control">
				<form:option value="1" label="1" />
				<c:forEach begin="1" end="20" var="i">
					<c:if test="${ i % 5 == 0 }">
						<form:option value="${i}" label="${i}" />
					</c:if>
				</c:forEach>
			</form:select>
			<form:errors path="numberPostFrontend" cssClass="error" element="div" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 text-xs-left">
			<button type="submit" class="btn btn-primary">
				<spring:message code="Update" />
			</button>
			<a href='<spring:url value="/login"></spring:url>'
				class="btn btn-default"><spring:message code="Back" /></a>
		</div>
	</div>
</form:form>