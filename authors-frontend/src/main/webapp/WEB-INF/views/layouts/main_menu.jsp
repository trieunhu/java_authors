<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="imageTop" value="/resources/images/vietnam.gif"/>
<c:set var="imageBottom" value="/resources/images/anh.png"/>
<c:set var="linkBottom" value="?loc=en"/>
<c:set var="linkTop" value="?loc=vi"/>
<c:if test="${pageContext.response.locale == 'en'}">
	<c:set var="imageTop" value="/resources/images/anh.png"/>
	<c:set var="imageBottom" value="/resources/images/vietnam.gif"/>
	<c:set var="linkBottom" value="?loc=vi"/>
	<c:set var="linkTop" value="?loc=en"/>
</c:if>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href='<c:url value="/"/>'><tiles:insertAttribute name="nameApp" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="<c:url value="/"/>"><spring:message code="home"/><span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/tac-gia/"/>"><spring:message code="author"/></a></li>
				</li>
				<li class="dropdown nav-item">
				<a href="<c:url value="${linkTop}"/>" class="nav-link dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">
					<img alt="" width="20px" src="<c:url value="${imageTop}" />">
					 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a class="nav-link" href='<c:url value="${linkBottom}"></c:url>'>
						<img alt="" width="20px" src="<c:url value="${imageBottom }" />"></a>
									</li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>