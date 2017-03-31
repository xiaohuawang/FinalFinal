<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Retailer Registration">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<link href="css/styles.css" rel="stylesheet">
	</jsp:attribute>
	 
	<jsp:attribute name="body">
		<!-- Add HTML content to page body here -->
		<div class="container theme-showcase" role="main">
		
			<header>
				<div class="page-header">
			  		<h1>Infinity Retailer<small> Register</small></h1>
				</div>	
			</header>
			
			<div class="page-body">
				<div class="container">
				  <form id ="form" method ="post" action = "RetailerController">
					<input name="action" value="create" type="hidden">
				    <div class="form-group">
				      <label for="name">Name (Individual or Company)</label>
				      <input class="form-control" name="name" id="name" type="text" required autofocus>
				    </div>
				    <div class="form-group">
				      <label for="contactNo1">Contact No:1</label>
				      <input class="form-control input-sm input-success"  type="text" id="contactNo1" name="contactNo1" required>
				    </div>
				    <div class="form-group">
				      <label for="contactNo2">Contact No:2</label>
				      <input class="form-control input-sm" id="contactNo2" name="contactNo2" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="address1">Address 1</label>
				      <input class="form-control input-sm" id="address1" name="address1" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="address2">Address 2</label>
				      <input class="form-control" id="address2" name="address2" type="text">
				    </div>
				    <div class="form-group">
				      <label for="city">City</label>
				      <input class="form-control input-sm" id="city" name="city" type="text" required> 
				    </div>
				    <div class="form-group">
				      <label for="state">State</label>
				      <input class="form-control input-sm" id="state" name="state" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="zipcode">Zip Code</label>
				      <input class="form-control input-sm" id="zipcode" name="zipcode" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="stb">Set Top Box Limit</label>
				      <input class="form-control input-sm" id="stb" name="setTopBoxLimit" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="creditLimit">Credit Limit</label>
				      <input class="form-control input-sm" id="creditLimit" name="creditLimit" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="commissionPercentage">Commission Percentage</label>
				      <input class="form-control input-sm" id="commissionPercentage" name ="commissionPercentage" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="serviceCharges">Service Charges</label>
				      <input class="form-control input-sm" id="serviceCharges" name ="serviceCharges" type="text" required>
				    </div>
				    <div class="form-group">
						<label  for="inventoryList">Inventory List</label>
						<input id="inventoryList" type="file" accept=".csv" class="file" >
				    </div>
				    <div class="form-group">
				      <label for="theDate">Retailer Creation Date</label>
				      <input class="form-control input-sm1" type="date" id="theDate" name="retailerCreationDate" readonly>
				    </div>
				    <div class="form-group">
				      <label for="username">User Name</label>
				      <input class="form-control input-sm" id="username" name="username" type="text" required>
				    </div>
				    <div class="form-group">
				      <label for="password">Password</label>
				      <input class="form-control input-sm" id="password" name="password" type="password" required>
				    </div>
				    <button type="submit" class="btn btn-primary">Submit</button>
				  </form>
				</div>
			</div>
			
		</div>
	</jsp:attribute>
 
</t:layout>