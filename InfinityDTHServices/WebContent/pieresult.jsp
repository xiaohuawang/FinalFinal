<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
<t:layout title="Create Sample">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	<header>
		<div class="page-header">
	  		<h1>Graph</h1>
		</div>	
	</header>
		
		<!-- Main component for a primary marketing message or call to action -->
		<div id=plot style="width: 600px; height: 500px;">
			<script type="text/javascript">
				var x = new Array();
		    	var y = new Array();
			
		    	<c:forEach var="item" items="${data}">
		    		y.push("${item.count}"); 
		    		x.push("${item.name}");
		        </c:forEach>
		    
				var data = [{
				  values: y,
				  labels: x,
				  type: 'pie'
				}];

				var layout = {
				  height: 500,
				  width: 600
				};

				Plotly.newPlot('plot', data, layout);
  			</script>
		</div>
	<!-- END -->
	</jsp:attribute>
 
</t:layout>