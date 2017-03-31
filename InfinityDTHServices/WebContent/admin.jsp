<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Admin Page">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	
		<div class="jumbotron text-center">
		   <h1>Welcome ${loggedUser.username}</h1>
		   <h3><a href="graph.jsp">Generate Reports</a></h3>
		   <!--  <p>Resize this responsive page to see the effect!</p> -->
		</div>
		<div class="container">
		   <div class="row">
		      <div class="col-sm-4">
		         <h3>Customer Management</h3>
		         <p><a href="customer.jsp">Create Customer</a></p>
		         <p><a href="searchCustomer.jsp">Update/Search Customer</a></p>
		      </div>
		      <div class="col-sm-4">
		         <h3>Operator Management</h3>
		         <p><a href="operator.jsp">Create Operator</a></p>
		         <p><a href="searchOperator.jsp">Update/Search Operator</a></p>
		      </div>
		      <div class="col-sm-4">
		         <h3>Retailer Management</h3>
		         <p><a href="retailer.jsp">Create Retailer</a></p>
		         <p><a href="searchRetailer.jsp">Update/Search Retailer</a></p>
		      </div>
		   </div>
		</div>
			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>