<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Infinity DTH Services - About">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
	</jsp:attribute>
	 
	<jsp:attribute name="body">
		
		<!-- Jumbotron -->
		<div class="jumbotron">
		   <h1>Site Map</h1>
		   <p class="lead">All pages that have been created.</p>
		</div>
		<div class="row">
	        <div class="col-md-3 col-sm-3 col-xs-12">
	            <strong><h3>User Management</h3></strong>
	            <h5>Module 1</h5>
	            <ul class="list-group">
	              <a href="signin.jsp" class="list-group-item">Sign In</a>
	              <a href="index.jsp" class="list-group-item">Home Page</a>
	              <a href="admin.jsp" class="list-group-item">Admin Home Page</a>
	              <a href="graph.jsp" class="list-group-item">Admin Reports</a>
	              <a href="customerHome.jsp" class="list-group-item">Customer Home Page</a>
	              <a href="searchCustomer.jsp" class="list-group-item">Customer Search</a>
	              <a href="customer.jsp" class="list-group-item">Customer Create</a>
	              <a href="retailer.jsp" class="list-group-item">Retailer Create</a>
	              <a href="searchRetailer.jsp" class="list-group-item">Retailer Search</a>
	              <a href="operatorHome.jsp" class="list-group-item">Operator Home Page</a>
	              <a href="operatorSearch.jsp" class="list-group-item">Operator Search</a>
	              <a href="operator.jsp" class="list-group-item">Operator Create</a>
	              <a href="error.jsp" class="list-group-item">Error Page</a>
	            </ul>            
	        </div>
	        <div class="col-md-3 col-sm-3 col-xs-12">
	            <strong><h3>Product Management</h3></strong>
	            <h5>Module 2</h5>
	            <ul class="list-group">
	              <a href="ProductManagement.jsp" class="list-group-item">Product Management</a>
	              <a href="manageSetTopBox.jsp" class="list-group-item">Set Top Box Management</a>
	              <a href="ManageChannel.jsp" class="list-group-item">Channel Management</a>
	              <a href="ManageChannelPackages.jsp" class="list-group-item">Channel Package Management</a>
	            </ul>            
	        </div>
	        <div class="col-md-3 col-sm-3 col-xs-12">
	            <strong><h3>Package and Charging</h3></strong>
	            <h5>Module 3</h5>
	            <ul class="list-group">
	              <a href="purchaseSTB.jsp" class="list-group-item">Purchase Set Top Box</a> 
	              <a href="PurchaseChannelPackage.jsp" class="list-group-item">Purchase Channel Package</a>            
	            </ul>            
	        </div>
	        <div class="col-md-3 col-sm-3 col-xs-12">
	            <strong><h3>Infinity Delight</h3></strong>
	            <h5>Module 4</h5>
	            <ul class="list-group">
	              <a href="infinity.jsp" class="list-group-item">Infinity Distributor</a>
	              <a href="contact.jsp" class="list-group-item">Contact</a>
	              <a href="map.jsp" class="list-group-item">Map</a>           
	            </ul>            
	        </div>
		</div>
		
	</jsp:attribute>
</t:layout>