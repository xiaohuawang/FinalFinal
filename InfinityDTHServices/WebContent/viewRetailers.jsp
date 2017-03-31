<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:layout title="View Retailer">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	
		<header>
			<div class="page-header">
		  		<h1>View Retailer<small> Retailer Management</small></h1>
			</div>	
		</header>
		
		<div class="row">
			<table class="table table-bordered" >
			   <thead class="thead-default">
			      <tr>
			         <th>Name</th>
			         <th>Contact No</th>
			         <th>Action</th>
			      </tr>
			   </thead>
			   <c:forEach items="${retailers}" var="retailer">
			      <tbody>
			         <tr>
			            <td>
			               <span class="badge">${retailer.name}</span>
			            </td>
			            <td>
			               <span class="badge">${retailer.contactNo1}</span>
			            </td>
			            <td>
			               <a class="btn btn-sm btn-primary" href="RetailerController?action=getRetailerById&id=${retailer.userId}" role="button">Update</a>
			               <a class="btn btn-sm btn-danger" href="RetailerController?action=delete&id=${retailer.userId}&source=${source}" role="button">Delete</a>
			            </td>
			         </tr>
			      </tbody>
			   </c:forEach>
			</table>
			<a class="btn btn-sm btn-primary" href="admin.jsp"> Go Back to Admin Page</a>
      </div>
			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>