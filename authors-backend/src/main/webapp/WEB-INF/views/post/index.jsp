<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<spring:message code="Posts.comfirmDelete" var="comfirmDelete" />
<h1>
	<spring:message code="Posts.all"></spring:message>
</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th><spring:message code="posts_image"></spring:message></th>
			<th><spring:message code="posts_title"></spring:message></th>
			<th><spring:message code="posts_status"></spring:message></th>
			<th><spring:message code="Post.view"></spring:message></th>
			<th><spring:message code="posts_action"></spring:message></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td><img alt="" width="100px"
					src='<spring:url value='${post.getUrlImage()}'/>'></td>
				<td>${post.getTitle()}</td>
				<td>${post.getStatusText(locale,messageSource)}</td>
				<td>${post.getViews()}</td>
				<td><a href='<c:url value="/post/update/${post.getId()}"/>'>Chỉnh
						sửa</a> | <a onclick="return confirm('${comfirmDelete}')"
					href='<c:url value="/post/delete/${post.getId()}"/>'>Xóa</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${endIndex > 1 }">
	<c:url var="nextUrl" value="/post/?p=${currentIndex+1}" />
	<c:url var="lastUrl" value="/post/?p=${endIndex}" />
	<c:url var="beginUrl" value="/post/?p=${beginIndex}" />
	<c:url var="nevUrl" value="/post/?p=${currentIndex -1}" />

	<ul class="pagination pull-left">
		<c:if test="${pagination[0] == 0 }">
			<li><a href="${beginUrl}">&lt;</a></li>
			<li><a href="${nevUrl}">&lt;&lt;</a></li>
		</c:if>
		<c:forEach var="i" begin="${pagination[1]}" end="${pagination[2]}">
			<c:url var="pageUrl" value="/post/?p=${i}" />
			<c:choose>
				<c:when test="${i == currentIndex}">
					<li class="active"><a href="${pageUrl}"><c:out
								value="${i}" /></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pagination[3] == 0 }">
			<li><a href="${nextUrl}">&gt;</a></li>
			<li><a href="${lastUrl}">&gt;&gt;</a></li>
		</c:if>
	</ul>
</c:if>