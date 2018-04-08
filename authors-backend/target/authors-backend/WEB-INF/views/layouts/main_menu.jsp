<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.backend.common.Utils"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/"></c:url>">Tin tức</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Bài viết <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/post/create"></c:url>'>Tạo
								bài viết mới</a></li>
						<li><a href='<c:url value="/post/"></c:url>'>Tất cả bài viết</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> <%=Utils.getUserLogined()%> <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/user/create"></c:url>'>Tạo
								người dùng mới</a></li>
						<li><a href='<c:url value="/user/update"></c:url>'>Cập
								nhật thông tin</a></li>
						<li><a href='<c:url value="/user/changepassword"></c:url>'>Đổi
								mật khẩu</a></li>
						<li><a href='<c:url value="/logout"></c:url>'>Đăng xuất</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>