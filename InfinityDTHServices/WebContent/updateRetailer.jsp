<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout title="Update Retailer">

	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	<jsp:attribute name="body">
		<div class="container">
			<header>
				<div class="page-header">
			  		<h1>Infinity Retailer Update<small> Retailer Management</small>
					</h1>
				</div>	
			</header>
		<form id="form" method="post" action="RetailerController">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="id" value="${retailers.userId}">
		    <div class="form-group">
		      <label for="name">Retailer Name</label>
		      <input class="form-control input-sm" id="name"
			type="text" name="name" value="${retailers.name}" >  
		    </div>
		    <div class="form-group">
		      <label for="contactNo1">Contact No1</label>
		      <input class="form-control input-sm" id="contactNo1" type="text"
			name="contactNo1"  value="${retailers.contactNo1}" >
			</div>
		    	<br>
		    	<br>
		     <button type="submit" class="btn btn-default">Submit</button>
	 	</form>
		</div>
			
	<!-- END -->
	</jsp:attribute>

</t:layout>