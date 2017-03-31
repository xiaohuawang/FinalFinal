<!DOCTYPE html>
<%@tag description="layout" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@attribute name="title"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>

<html lang="en">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>${title}</title>
		
	    <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	    
	    <link href="css/styles.css" rel="stylesheet">
	     
	    <!-- Page specific stylesheet -->
	    <jsp:invoke fragment="head"/>
	</head>
	<body>
		
		<!-- Fixed navbar -->
		<nav class="navbar navbar-default navbar-fixed-top">
		  <div class="container">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="index.jsp">Infinity DTH Services</a>
		    </div>
		    <div id="navbar" class="navbar-collapse collapse">
		      <ul class="nav navbar-nav">
		        <li class=><a href="index.jsp">Home</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <c:if test="${loggedUser.roleId eq 1}">
		      		<li><a href="admin.jsp">Hello, ${loggedUser.username}</a>
		      	</c:if>
		      	<c:if test="${loggedUser.roleId eq 2}">
		      		<li><a href="operatorHome.jsp">Hello, ${loggedUser.username}</a>
		      	</c:if>
		      	<c:if test="${loggedUser.roleId eq 3}">
		      		<li><a href="#">Hello, ${loggedUser.username}</a>
		      	</c:if>
		      	<c:if test="${loggedUser.roleId eq 4}">
		      		<li><a href="customerHome.jsp">Hello, ${loggedUser.username}</a>
		      	</c:if>
		        
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Help<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="contact.jsp">Contact Us</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="map.jsp">Site Map</a></li>
		          </ul>
		        </li>
	              
             	<c:if test="${loginstatus eq true}">
                	<li class="active"><a href="login?action=logout">Sign out<span class="sr-only">(current)</span></a></li>
                </c:if>  
                <c:if test="${(loginstatus eq false) || (loginstatus eq null)}">
                	<li class="active"><a href="login?action=login">Sign in<span class="sr-only">(current)</span></a></li>
                </c:if>

		      </ul>
		    </div><!--/.nav-collapse -->
		  </div>
		</nav>
		
		<div class="container">

			<jsp:invoke fragment="body"/>
			
			<hr />
			<footer class="footer">
				<p>&copy; 2017 Infinity DTH Services, Inc.</p>
			</footer>
		
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    
	    <!-- TODO: Will probably use these later on -->
	    <!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	    
	    <!-- Custom JavaScript -->
	    <script src="js/scripts.js"></script>
	    
	    <jsp:invoke fragment="scripts"/>
	</body>
</html>