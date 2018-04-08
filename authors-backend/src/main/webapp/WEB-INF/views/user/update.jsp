<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:message code="Fullname" var="fullname"/>
<spring:message code="Email" var="Email"/>
<spring:message code="posts_image" var="posts_image"/>
<h1><spring:message code="userUpdate.Title"></spring:message></h1>
<c:if test="${success == 1}">
<div class="alert alert-success">
  <spring:message code="userUpdate.success"></spring:message>
</div>
</c:if>
<form:form class="form-horizontal" modelAttribute="userUpdate" enctype="multipart/form-data">
  <div class="form-group">
		<label class="control-label col-sm-2" for="email">${Email}:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" placeholder="${Email}" />
			<form:errors path="email" cssClass="error" element="div" />
		</div>
	</div>
  <div class="form-group">
		<label class="control-label col-sm-2" for="email">${fullname}:</label>
		<div class="col-sm-10">
			<form:input path="fullname" class="form-control"
				placeholder="${fullname}" />
			<form:errors path="fullname" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${posts_image}</label>
		<div class="col-sm-10" style="margin: 0px !important;padding: 0px !important;">
			<div class="row">
				<div class="col-sm-2">
					<img alt="" width="100px"
						src='<spring:url value='${user.getUrlImage()}'/>'>
					<form:input path="file" type="file" style="padding: 2px 13px;" />
					<form:errors path="file" cssClass="error" element="div" />
				</div>
			</div>
		</div>
	</div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10 text-xs-left">
      <button type="submit" class="btn btn-primary"><spring:message code="Update"></spring:message> </button>
    </div>
  </div>
</form:form>