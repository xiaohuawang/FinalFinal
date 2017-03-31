<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:layout title="Search Retailer Page">
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	<jsp:attribute name="body">
	<!-- START -->
	
		<header>
			<div class="page-header">
		  		<h1>Search Retailer <small>Retailer Management</small></h1>
			</div>	
		</header>
		 <a href="RetailerController?action=getAllRetailers" class="btn btn-info" >Get All Retailers
		</a> <br><br>
		 <div class="btn-group" data-toggle="buttons">
		 <p class="bg-primary">Search Retailer By Name</p>		
		</div> &nbsp;<br>
		 <form  action="RetailerController" method="get">   
			 <div  id="btns">
			<input class="input-sm" type="text" name="name" id="search" > 
			<input type="hidden" name="action" value="getRetailerByName">
			<button type="submit" class="btn btn-primary">Submit</button>
		   	</div>
		</form>
	<!-- END -->
	</jsp:attribute>
 
</t:layout>