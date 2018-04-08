<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white"><tiles:insertAttribute name="contentFooter" /></p>
	</div>
	<!-- /.container -->
</footer>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>