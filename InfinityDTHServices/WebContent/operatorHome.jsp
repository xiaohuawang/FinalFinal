<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Operator Page">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	
		<div class="jumbotron text-center">
		   <h1>Welcome ${loggedUser.username}</h1>
		   <!--  <p>Resize this responsive page to see the effect!</p> -->
		</div>
		<div class="container">
		   <div class="row">
		      <div class="col-sm-4 col-md-offset-2">
		         <h3>Customer Management</h3>
		         <p><a href="customer.jsp">Create Customer</a></p>
		         <p><a href="searchCustomer.jsp">Update/Search Customer</a></p>
		      </div>
		      <div class="col-sm-4 col-md-offset-1">
		         <h3>Retailer Management</h3>
		         <p><a href="retailer.jsp">Create Retailer</a></p>
		         <p><a href="searchRetailer.jsp">Update/Search Retailer</a></p>
		      </div>
		   </div>
		</div>
			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>