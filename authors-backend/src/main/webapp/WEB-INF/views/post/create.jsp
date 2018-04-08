<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="posts_title" var="posts_title"/>
<spring:message code="posts_description" var="posts_description"/>
<spring:message code="posts_sub_title" var="posts_sub_title"/>
<spring:message code="posts_status" var="posts_status"/>
<spring:message code="posts_image" var="posts_image"/>
<h1>${title}</h1>
<form:form class="form-horizontal" modelAttribute="createPost"
	enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${posts_title}:</label>
		<div class="col-sm-10">
			<form:input path="title" class="form-control" placeholder="${posts_title}" />
			<form:errors path="title" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${posts_sub_title}</label>
		<div class="col-sm-10">
			<form:textarea path="subTitle" id="sub_title" class="form-control"
				placeholder="${posts_sub_title}" />
			<form:errors path="subTitle" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${posts_description}</label>
		<div class="col-sm-10">
			<form:textarea path="description" id="description"
				class="form-control" placeholder="${posts_description}" />
			<form:errors path="description" cssClass="error" element="div" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${posts_status}</label>
		<div class="col-sm-10">
			<form:select path="status" class="form-control">
				<form:option value="" label="${posts_status}" />
				<form:options items="${listStatus}" />
			</form:select>
			<form:errors path="status" cssClass="error" element="div" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="email">${posts_image}</label>
		<div class="col-sm-10" style="margin: 0px !important;padding: 0px !important;">
			<div class="row">
				<div class="col-sm-2">
					<img alt="" width="100px"
						src='<spring:url value='${post.getUrlImage()}'/>'>
					<form:input path="file" type="file" style="padding: 2px 13px;" />
					<form:errors path="file" cssClass="error" element="div" />
				</div>
			</div>
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 text-xs-left">
			<button type="submit" class="btn btn-primary">${txtSubmit}</button>
		</div>
	</div>
</form:form>
<script>
	window.onload = function() {
		CKEDITOR.replace('description');
	}
</script>
