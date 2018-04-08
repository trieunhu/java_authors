<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<h1>Tất cả bài viết</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Tiêu đề</th>
			<th>Trạng thái</th>
			<th>Chỉnh sửa</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td>${post.getTitle()}</td>
				<td>${post.getStatus()}</td>
				<td>
				<a href='<c:url value="/post/update/${post.getId()}"/>'>Chỉnh
						sửa</a> |
						<a onclick="return confirm('Are you sure?')" href='<c:url value="/post/delete/${post.getId()}"/>'>Xóa</a>
						</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ul class="pagination">
	<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
		<c:url var="pageUrl" value="/post/?p=${i}" />
		<c:choose>
			<c:when test="${i == currentIndex}">
				<li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${currentIndex == deploymentLog.totalPages}">
			<li class="disabled"><a href="#">&gt;</a></li>
			<li class="disabled"><a href="#">&gt;&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${nextUrl}">&gt;</a></li>
			<li><a href="${lastUrl}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
</ul>