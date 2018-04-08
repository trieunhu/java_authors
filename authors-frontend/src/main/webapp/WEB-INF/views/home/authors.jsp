<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1 class="my-4">
	<spring:message code="all_authors"/>
</h1>
<div class="row">

	<div class="col-sm-8 blog-main">
		<div class="row post-authors">
				<c:forEach items="${users}" var="user">
					<div class="row border rounded" style="padding: 6px 0px;margin-bottom: 5px;">
						<div class="col-sm-3 p-0 pl-1">
							<a href="#"><img class="card-img-top" style="max-height: 150px;"
					src="<c:url value='${user.getUrlImage()}'/>" alt=""></a>
						</div>
						<div class="col-sm-9">
							<a href='<c:url value="${user.getUrl()}"/>'>${user.getFullname()}</a>
							<p>
							<spring:message code="countPostUser" arguments="${user.getPosts().size()};" argumentSeparator=";" htmlEscape="false" />
							</p>
						</div>
					</div>
				</c:forEach>

			</div>
	</div>

</div>
<c:if test="${endIndex > 1 }">
	<c:url var="nextUrl" value="/tac-gia/${currentIndex+1}" />
	<c:url var="lastUrl" value="/tac-gia/${endIndex}" />
	<c:url var="beginUrl" value="/tac-gia/${beginIndex}" />
	<c:url var="nevUrl" value="/tac-gia/${currentIndex -1}" />

	<ul class="pagination justify-content-center">
		<c:if test="${pagination[0] == 0 }">
			<li class="page-item"><a class="page-link" href="${beginUrl}">&lt;</a></li>
			<li class="page-item"><a class="page-link" href="${nevUrl}">&lt;&lt;</a></li>
		</c:if>
		<c:forEach var="i" begin="${pagination[1]}" end="${pagination[2]}">
			<c:url var="pageUrl" value="/tac-gia/${i}" />
			<c:choose>
				<c:when test="${i == currentIndex}">
					<li class="page-item active"><a class="page-link" href="${pageUrl}"><c:out
								value="${i}" /></a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pagination[3] == 0 }">
			<li class="page-item"><a class="page-link" href="${nextUrl}">&gt;</a></li>
			<li class="page-item"><a class="page-link" href="${lastUrl}">&gt;&gt;</a></li>
		</c:if>
	</ul>
</c:if>