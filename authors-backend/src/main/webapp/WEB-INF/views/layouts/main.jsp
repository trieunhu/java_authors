<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <tiles:insertAttribute name="header" />
  </head>

  <body>
	 
   <tiles:insertAttribute name="menu" />

    <div class="container">

      <div class="starter-template">
        <tiles:insertAttribute name="body" />
      </div>

    </div><!-- /.container -->
	<tiles:insertAttribute name="footer" />
  </body>
</html>
