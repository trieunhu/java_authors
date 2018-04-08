<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page import="com.backend.common.Utils"%>
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
<c:set var="username" value="${Utils.getUserLogined()}" />
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				 <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				   <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/"></c:url>">
				<tiles:insertAttribute name="nameApp" />
			</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> <spring:message code="Posts" /><span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/post/create"></c:url>'><spring:message
									code="Posts.new" /></a></li>
						<li><a href='<c:url value="/post/"></c:url>'><spring:message
									code="Posts.all" /></a></li>
					</ul></li>
					
					<sec:authorize access="hasRole('ADMIN')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> <spring:message code="Config" /><span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/config/create"></c:url>'><spring:message
									code="configCreate.Title" /></a></li>
						<li><a href='<c:url value="/config/"></c:url>'><spring:message
									code="configAll.Title" /></a></li>
					</ul></li>
					</sec:authorize>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> ${username} <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/user/update"></c:url>'><spring:message
									code="Users.update" /></a></li>
						<li><a href='<c:url value="/user/changepassword"></c:url>'><spring:message
									code="Users.changepassword" /></a></li>
						<li><a href='<c:url value="/logout"></c:url>'><spring:message
									code="Users.logout" /></a></li>
					</ul></li>
				<li class="dropdown">
				<a href="<c:url value="${linkTop}"/>" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">
					<img alt="" width="20px" src="<c:url value="${imageTop}" />">
					 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="${linkBottom}"></c:url>'>
						<img alt="" width="20px" src="<c:url value="${imageBottom }" />"></a>
									</li>
					</ul></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>