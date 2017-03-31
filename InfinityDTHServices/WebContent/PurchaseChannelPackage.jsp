<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Purchase Channel Package">

	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<link href="css/styles.css" rel="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="body">
	<br><br>
	<!-- Add HTML content to page body here -->
	
	<h2>Purchase Channel Package</h2>
	<br>
	
	
	<div class="form-group">
		<label for="inputdefault">Customer Name</label>
		<input class="form-control" id="inputdefault" type="text">
	</div>
	<div class="form-group">
		<label for="inputdefault">Package details(auto filled from selected packages)</label>
		<input class="form-control" id="inputdefault" type="text">
	</div>
	<!--8th input field-->	
			<!--Add starting date-->
			<div class="container"> 
			<div class="row">
			<label for="sel1">Package Purchase Date</label>
			</div>
			
			<div class="row">
			<div class='col-sm-3'>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
			<input type='date' class="form-control" />		              
			</div>
			</div>
			</div>
			</div>
			</div>
			<!--Package Cost input field-->
			<div class="form-group">
			<label for="inputdefault">Total Package Cost</label>
			<input class="form-control" id="inputdefault" type="text">
			</div>
			<!--Total Amount input field-->
			<div class="form-group">
			<label for="inputdefault">Total Amount</label>
			<input class="form-control" id="inputdefault" type="text">
			</div>
	
	</jsp:attribute>
 
</t:layout>