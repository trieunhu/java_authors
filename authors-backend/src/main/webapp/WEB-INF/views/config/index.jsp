<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<spring:message code="Posts.comfirmDelete" var="comfirmDelete" />
<h1>
	<spring:message code="configAll.Title"></spring:message>
</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th><spring:message code="Config.name"></spring:message></th>
			<th><spring:message code="Config.content"></spring:message></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${configs}" var="config">
			<tr>
				<td>${config.getName()}</td>
				<td>${config.getContent()}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
