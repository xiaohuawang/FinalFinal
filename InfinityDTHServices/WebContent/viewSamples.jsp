<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:layout title="Create Sample">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
		<div class="jumbotron">
		  <h2>Samples</h2>
		  <c:forEach items="${sampleList}" var="sample">
		    <ul class="list-group">
		      <li class="list-group-item">
		      	<span class="badge">${sample.sampleId}</span>
		      	Sample Id
		      </li>
		      <li class="list-group-item">
		      	<span class="badge">${sample.sampleName}</span>
		      	Sample Name
		      </li>
		    </ul>
		  </c:forEach>
		</div>
	<!-- END -->
	</jsp:attribute>
 
</t:layout>