<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<h1>${title}</h1>
<form:form class="form-horizontal" modelAttribute="createPost" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Tiêu đề:</label>
		<div class="col-sm-10">
			<form:input path="title" class="form-control" placeholder="Tiêu đề" />
			<form:errors path="title" cssClass="error" element="div" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Nội dung</label>
		<div class="col-sm-10">
			<form:textarea path="description" class="form-control"
				placeholder="Nội dung" />
			<form:errors path="description" cssClass="error" element="div" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Trạng thái</label>
		<div class="col-sm-10">
			<form:select path="status" class="form-control">
				<form:option value="NONE" label="Trạng thái" />
				<form:options items="${createPost.listStatus()}" />
			</form:select>
			<form:errors path="description" cssClass="error" element="div" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Hình ảnh</label>
		<div class="col-sm-10">
		<form:input path="file" type="file"/>
		<form:errors path="file" cssClass="error" element="div" />
		</div>
	</div>
	

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 text-xs-left">
			<button type="submit" class="btn btn-primary">${txtSubmit}</button>
		</div>
	</div>
</form:form>