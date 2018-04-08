<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1 class="my-4">${post.getTitle()}</h1>
<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="blog-post">
			<p>${post.getSubtitle()}</p>
			${post.getDescription()}
		</div>
		<div class="fb-like" data-href="${post.getUrl()}" data-layout="box_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
		<!-- /.blog-post -->
		<h2><spring:message code="newPost"/></h2>
		<div class="row">
			<c:forEach items="${postsDesc}" var="post">
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
	</div>
	<!-- /.blog-main -->

	<div class="col-sm-3 offset-sm-1 blog-sidebar">
		<div class="sidebar-module sidebar-module-inset">
			<h4>${user.getFullname()}</h4>
			<p>
			<spring:message code="countPostUser" arguments="${user.getPosts().size()};" argumentSeparator=";" htmlEscape="false" />
			</p>
		</div>
		<div class="sidebar-module">
			<h4><spring:message code="postAuthor" /></h4>
			<div class="row post-authors">
				<c:forEach items="${postsAuthor}" var="post">
					<div class="row border rounded"
						style="padding: 6px 0px; margin-bottom: 5px;">
						<div class="col-sm-3 p-0 pl-1">
							<a href="#"><img class="card-img-top"
							src="<c:url value='${post.getUrlImage()}'/>" alt=""></a>
						</div>
						<div class="col-sm-9">
							<a href='<c:url value="${post.getUrl()}"/>'>${post.getTitle()}</a>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<!-- /.blog-sidebar -->

</div>