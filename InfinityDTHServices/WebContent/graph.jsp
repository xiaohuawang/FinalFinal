<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Admin Page">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<link href="css/styles.css" rel="stylesheet">
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	
		<div class="jumbotron text-center">
		   <h1>Choose chart type</h1>
		   <!--  <p>Resize this responsive page to see the effect!</p> -->
		</div>
		
		<form method="post" action="GraphicalReportController" id="form">
			<div class="container">
			   <div class="row">
			      <div class="col-sm-4">
			         <h3>Customer</h3>
						<input type="radio" name="graphType" value="piec" checked> Retailer-wise total count of Customers<br>
						<input type="radio" name="graphType" value="barc"> Month-wise total Customers created for last 12 months<br>
			      </div>
			      <div class="col-sm-4">
			         <h3>Operator</h3>
						<input type="radio" name="graphType" value="pieo"> Total number of Operators in each shift<br>
						<input type="radio" name="graphType" value="baro"> Month-wise total Operators created for last 12 months<br>
			      </div>
			      <div class="col-sm-4">
			         <h3>Retailer</h3>
						<input type="radio" name="graphType" value="pier"> Total number of Retailers in each state<br>
						<input type="radio" name="graphType" value="barr"> Month-wise total Retailers created for last 12 months<br>
			      </div>
			   </div>
			</div>
			<input type="submit" class="btn btn-info" value="Submit">
		</form>
			
	<!-- END -->
	</jsp:attribute>
</t:layout>