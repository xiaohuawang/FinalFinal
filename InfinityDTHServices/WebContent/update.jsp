<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="com.dao.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Search Table</title>
	<!-- Bootstrap -->
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="css/styles.css" rel="stylesheet">  
 </head>
<body>
	<br>
		<div class="container">
		   <div class="row">
		   		<h1 class="bg-success"> Welcome to the Search Page</h1>
		   		<h1 class="col-xs-6 col-offset-3">Update Table Page</h1>
		        <table class="table table-bordered" >
		            <thead class="thead-default">
			            <tr>
			                <th>#</th>
			                <th>Name</th>
			                <th>Email</th>
			                <th>Profession</th>
			            </tr>
		            </thead>
		            <tbody>
		            </tbody>
		        </table>
	      </div>
    </div>
    	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="js/bootstrap.min.js"></script>
	    <!-- Custom JavaScript -->
	    <script src="js/scripts.js"></script>
 </body>
</html>