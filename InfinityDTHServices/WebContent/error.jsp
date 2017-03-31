<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Create Sample">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
		
		<div class="container">
		  <div class="row">
		    <div class="span12">
		      <div class="jumbotron center">
		          <h1>Oops! <small><font face="Tahoma" color="red">Sorry about that...</font></small></h1>
		          <br />
		          <p>The page you requested could not be found, either contact your webmaster or go die. Use your browsers <b>Back</b> button to navigate to the page you have prevously come from</p>
		          <p><b>Or you could just press this neat little button:</b></p>
		          <a href="index.jsp" class="btn btn-large btn-primary"><i class="icon-home icon-white"></i> Take Me Home</a>
		        </div>
		        <br />
		      </div>
		  </div>
		</div>
			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>