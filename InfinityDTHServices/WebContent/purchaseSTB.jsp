<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Home">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	 <form>

	  <div class="container">
 		 <h2> Purchase Set Top Box </h2>
 	  </div>
			<br><br>
            
	   <div class="form-group">
	     <label for="selectPaymentMethod"> Select A Payment Method :</label>
	      <select class="form-control input-sm" id="selectPaymentMethod" name="selectPaymentMethod">
	        <option> Pre Paid </option>
	        <option> Post Paid </option>
              </select>
      </div>
        		<br>
                
       <div class="form-group1">      
	     <label for="searchSetTopBoxes"> Search Set Top Box Type :</label>
	      <select class="form-control input-sm" id="searchSetTopBoxes" name="searchSetTopBoxes">
            	<option> Standard </option>
           	<option> HD </option>
            	<option> HD Plus </option>
            	<option> IPTV </option>
	      </select>
	    </div>
                <br>	
        
        <div class="form-group2">
	      <label for="channelCharge"> Refundable Deposit Amount (Post Paid Only) :</label>
	      <input class="form-control" type="text" id="channelCharge" name="channelCharge" readonly>
			
        </div>
        	    <br>
            
        <div class="form-group3">
	      <label for="custName"> Customer Name :</label>
	      <input class="form-control input-sm" id="custName" type="text" name="custName" readonly>
		  
	    </div>
        	    <br>
            
        <div class="form-group4">
	      <label for="stbType"> STB Type :</label>
	      <input class="form-control input-sm" id="stbType" type="text" name="stbType" readonly>
		  
	    </div>
        	    <br>
                
        <div class="form-group5">
	      <label for="stbMacID"> STB Mac ID :</label>
	      <input class="form-control input-sm" id="stbMacID" type="text" name="stbMacID" readonly>
		  
	    </div>
        	    <br>
                
        <div class="form-group6">
	      <label for="stbSerial"> STB Serial Number :</label>
	      <input class="form-control input-sm" id="stbMacID" type="text" name="stbMacID" readonly>
		  
	    </div>
        	    <br>
                
        <div class="form-group7">
	      <label for="stbPrice"> STB Price :</label>
	      <input class="form-control input-sm" id="stbPrice" type="text" name="stbPrice" readonly>
		  
	    </div>
        	    <br>
                
        <div class="form-group8">
	      <label for="installCharge"> Installation Charge :</label>
	      <input class="form-control input-sm" id="installCharge" type="text" name="installCharge" readonly>
		  
	    </div>
        	    <br>
           <br>
                <!-- (Viewable if Post Paid Selected Only) -->
           <div class="form-group9">
	      <label for="deposit">Deposit :</label>
	      <input class="form-control input-sm" id="deposit" type="text" name="deposit" readonly>
		  
	    </div>
        		<br>
        		
        		<div class="form-group10">
	      <label for="discount">Discount :</label>
	      <input class="form-control input-sm" id="discount" type="text" name="discount" readonly>
		  
	    </div>
        		<br>
                
      	<div class="form-group11">
	      <label for="deposit">Tax :</label>
	      <input class="form-control input-sm" id="deposit" type="text" name="deposit" readonly>
		  
	    </div>
        		<br>
        <div class="form-group12">
	      <label for="aPayable">Amount Payable :</label>
	      <input class="form-control input-sm" id="aPayable" type="text" name="aPayable" readonly>
		  
	    </div>     
         
        
        
            
 
	</form>
 </body>
		
		






			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>