<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout title="Update Operator">

	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	<jsp:attribute name="body">
		<div class="container">
			<header>
				<div class="page-header">
			  		<h1>Infinity Operator Update<small> Operator Management</small>
					</h1>
				</div>	
			</header>
		<form id="form" method="post" action="operator">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="id" value="${operators.userId}">
		    <div class="form-group">
		      <label for="firstname1">First Name</label>
		      <input class="form-control input-sm" id="firstname1"
			type="text" name="firstName" value="${operators.firstName}" >  
		    </div>
		    <div class="form-group">
		      <label for="lastname1">Last Name</label>
		      <input class="form-control input-sm" id="lastname" type="text"
			name="lastName"  value="${operators.lastName}" >
			</div>
		    <div class="form-group">
		      <label for="phonenumber1">Phone Number</label>
		      <input class="form-control input-sm" id="phoneNumber"
			type="text" name="phoneNumber"  value="${operators.phoneNumber}" >
		    </div>
		    	<br>
		    	<br>
		     <button type="submit" class="btn btn-default">Submit</button>
	 	</form>
		</div>
			
	<!-- END -->
	</jsp:attribute>

</t:layout>