<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:layout title="Search Customer Page">
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	<jsp:attribute name="body">
	<!-- START -->
	
		<header>
			<div class="page-header">
		  		<h1>Search Operator <small>Operator Management</small></h1>
			</div>	
		</header>
		 <a href="operator?action=getAllOperators" class="btn btn-info" >Get All Operators
		</a> <br><br>
		 <div class="btn-group" data-toggle="buttons">
		 <p class="bg-primary">Search Operator By Name</p>		
		</div> &nbsp;<br>
		 <form  action="operator" method="get">   
			 <div  id="btns">
			<input class="input-sm" type="text" name="operatorName" id="search" > 
			<input type="hidden" name="action" value="getOperatorByName">
			<button type="submit" class="btn btn-primary">Submit</button>
		   	</div>
		</form>
	<!-- END -->
	</jsp:attribute>
 
</t:layout>