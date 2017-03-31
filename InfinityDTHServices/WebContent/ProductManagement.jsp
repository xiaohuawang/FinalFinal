<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Product Management">

	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<link href="css/styles.css" rel="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="body">
	<br>
	<br>

		<!-- Add HTML content to page body here -->
	<div class="container">
  		<h2>Product Management</h2><br>
  		<button type="button" class="btn btn-primary" value="Input Button" onclick="location.href = 'manageSetTopBox.jsp'">Manage STB Types</button>
  		<button type="button" class="btn btn-success" value="Input Button" onclick="location.href = 'ManageChannel.jsp'">Manage Channels</button>
  		<button type="button" class="btn btn-info" value="Input Button" onclick="location.href = 'ManageChannelPackages.jsp'">Manage Channel Packages</button>
	</div>
		
	</jsp:attribute>

</t:layout>