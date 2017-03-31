<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout title="Create Sample">
	<jsp:attribute name="head">
      <!-- Add HTML content to page header here i.e. StyleSheets -->
   </jsp:attribute>
	<jsp:attribute name="body">
      
      <h1 id="searchBar"> Search </h1>
      <div class="row">
      </div>
      <!-- /.col-lg-6 -->
      <div class="col-lg-6">
         <div class="input-group">
         	 <div>
		  		<a href="customer?action=getAllCustomers"><h2>get all customer</h2></a>
		  	</div>
		  	 <div>
		  		<a href="customer?action=getCustomerByName"><h2>get customer by name</h2></a>
		  	</div>
         	<form action="customer" name="getCustomerByName" method="get">
           		 <input type="text" name="customerName"
						class="form-control" placeholder="Search for...">
           		 <span class="input-group-btn">
           		<input type="submit" class="btn btn-info" value="submit">
            	</span>
            </form>
         </div>
         
         	<div class="jumbotron">
		 	 	<h2>Customer</h2>
		  		<c:forEach items="${customers}" var="customer">
		    		<ul class="list-group">
		      		<li class="list-group-item">
		      			<span class="badge">${customer.firstName}</span>
		      			First Name
		      		</li>
		     	 	<li class="list-group-item">
		      			<span class="badge">${customer.lastName}</span>
		      			Last Name
		      		</li>
		    		</ul>
		  		</c:forEach>
			</div>
         <!-- /input-group -->
      </div>
      <!-- /.col-lg-6 -->
      <!-- END -->
   </jsp:attribute>
</t:layout>