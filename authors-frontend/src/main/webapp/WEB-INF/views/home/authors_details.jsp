<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Page Heading -->
<h1 class="my-4">${title}</h1>

<div class="row">
	<c:forEach items="${posts}" var="post">
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="<c:url value='${post.getUrlImage()}'/>" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href='<c:url value="${post.getUrl()}"/>'>${post.getTitle()}</a>
					</h4>
					<p class="card-text">${post.getSubtitle()}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<!-- /.row -->
<c:if test="${endIndex > 1 }">
	<c:url var="nextUrl" value="${link}${currentIndex+1}" />
	<c:url var="lastUrl" value="${link}${endIndex}" />
	<c:url var="beginUrl" value="${link}${beginIndex}" />
	<c:url var="nevUrl" value="${link}${currentIndex -1}" />
	<ul class="pagination justify-content-center">
		<c:if test="${pagination[0] == 0 }">
			<li class="page-item"><a class="page-link" href="${beginUrl}">&lt;</a></li>
			<li class="page-item"><a class="page-link" href="${nevUrl}">&lt;&lt;</a></li>
		</c:if>
		<c:forEach var="i" begin="${pagination[1]}" end="${pagination[2]}">
			<c:url var="pageUrl" value="${link}${i}" />
			<c:choose>
				<c:when test="${i == currentIndex}">
					<li class="page-item active"><a class="page-link"
						href="${pageUrl}"><c:out value="${i}" /></a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="${pageUrl}"><c:out
								value="${i}" /></a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pagination[3] == 0 }">
			<li class="page-item"><a class="page-link" href="${nextUrl}">&gt;</a></li>
			<li class="page-item"><a class="page-link" href="${lastUrl}">&gt;&gt;</a></li>
		</c:if>
	</ul>
</c:if>