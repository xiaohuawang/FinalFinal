<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <t:layout title="STB Box management">
            <jsp:attribute name="head">
                <!-- Add HTML content to page header here i.e. StyleSheets -->
                <link href="css/stbmanagement.css" rel="stylesheet">
            </jsp:attribute>
            <jsp:attribute name="body">
                <!-- START -->
                <div class="page-header">
                <h1>
					Set Top Box Management   
				</h1>  
				</div>
 <!-- ----------------------------------------------------------------------------------- -->
      <form method="post" action="set-top-box" id="form" >
         <!--  STB types -->
         <div class="row">
            <div class="col-md-8">
               <div class="panel panel-default">
                  <div class="panel-heading clearfix">
                     <i class="icon-calendar"></i>
                     <h3 class="panel-title"><b>STB types</b></h3>
                  </div>
                  <br>
                  <div class="col-xs-6">
                     <select class="form-control" id="exampleSelect1" name="setTopBoxType" required autofocus>
                        <option selected>
                           Choose...
                        </option>
                        <option value="1">
                          Standard
                        </option>
                        <option value="2">
                           High Definition
                        </option>
                        <option value="3">
                           High Definition Recorder
                        </option>
                        <option value="4">
                           Internet Protocol Television (IPTV)
                        </option>
                     </select>
                  </div>
                  <!--  stb dimensions -->
                  <br>
                  <br>
                  <br>
               </div>
            </div>
         </div>
  <!-- ---------------------------------------------------------------------------- -->
         <!--  stb dimensions -->
         <div class="row">
            <div class="col-md-8">
               <div class="panel panel-default">
                  <div class="panel-heading clearfix">
                     <i class="icon-calendar"></i>
                     <h3 class="panel-title"><b>STB Dimensions</b></h3>
                  </div>
                  <br>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Length</span> 
                        <input class="form-control" type="text" name="boxLength" required>
                     </div>
                  </div>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Breadth</span> 
                        <input class="form-control" type="text" name="boxBreadth" required>
                     </div>
                  </div>
                  <br>
                  <br>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Width:</span> 
                        <input class="form-control" type="text" name="boxWidth" required>
                     </div>
                  </div>
                  <br>
                  <br>
                  <br>
               </div>
            </div>
         </div>
 <!-- -------------------------------------------------------------------- -->
         <div class="row">
            <div class="col-md-8">
               <div class="panel panel-default">
                  <div class="panel-heading clearfix">
                     <i class="icon-calendar"></i>
                     <h3 class="panel-title"><b>Cost and Other Charges</b></h3>
                  </div>
                  <br>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Price:</span>
                        <input class="form-control" type="text" name="price" required>
                     </div>
                  </div>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Installation Charges:</span>
                        <input class="form-control" type="text" name="installationCharge" required>
                     </div>
                  </div>
                  <br>
                  <br>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Upgradation Charges:</span> 
                        <input class="form-control" type="text" name="upgradationCharge" required>
                     </div>
                  </div>
                  <div class="col-xs-6">
                     <div class="input-group">
                        <span class="input-group-addon">Discount (%):</span> 
                        <input class="form-control" type="text" name="discount" required>
                     </div>
                  </div>
                  <br>
                  <br>
                  <br>
               </div>
            </div>
         </div>
  <!-- ------------------------------------------------------------------------------------- -->
         <!--   type  -->
         <div class="row">
            <div class="col-md-8">
               <div class="panel panel-default">
                  <div class="panel-heading clearfix">
                     <i class="icon-calendar"></i>
                     <h3 class="panel-title"><b>Billing Type</b></h3>
                  </div>
                  <br>
                  <div>
                     <div class="col-xs-6">
                        <select class="form-control" id="exampleSelect1" name="billingType" required>
                           <option selected> </option>
                           <option value="1">
                              Pre-paid 
                           </option>
                           <option value="2">
                              Post-paid
                           </option>
                        </select>
                     </div>
                     <!--  stb dimensions -->
                     <br>
                     <br>
                     <br>
                  </div>
               </div>
            </div>
   <!-- ------------------------------------------------------------------------- --> 
            <!--  STB Inventory Details --> 
            <div class="row">
               <div class="col-md-8">
                  <div class="panel panel-default">
                     <div class="panel-heading clearfix">
                        <i class="icon-calendar"></i>
                        <h3 class="panel-title"><b>Set Top Box Details: </b></h3>
                     </div>
                     <br>
                     <div class="col-xs-6">
                        <div class="input-group">
                           <span class="input-group-addon">Serial Number:</span> 
                           <input class="form-control" type="text" name="serialNumber" required>
                        </div>
                     </div>
                     <div class="col-xs-6">
                        <div class="input-group">
                           <span class="input-group-addon">Mac ID:</span> 
                           <input class="form-control" type="text" name="macId" required>
                        </div>
                        <br>
                     </div>
                     <div class="col-xs-6">
                        <div class="input-group">
                           <span class="input-group-addon">Remote Contorl ID :</span> 
                           <input class="form-control" type="text" name="rcAssetId" required >
                        </div>
                     </div>
                     <br>
                     <br>
                     <div class="col-xs-6">
                        <div class="input-group">
                           <span class="input-group-addon">Dish Asset ID :</span>
                           <input class="form-control" type="text" name="dAssetId" required>
                        </div>
                     </div>
                     <br>
                     <br>
                     <br>
                  </div>
               </div>
            </div>
   <!-- ----------------------------------------------------------------------------------- -->
            <!--  STB status -->
            <div class="row">
               <div class="col-md-8">
                  <div class="panel panel-default">
                     <div class="panel-heading clearfix">
                        <i class="icon-calendar"></i>
                        <h3 class="panel-title"><b>Set Top Box Status:</b> </h3>
                     </div>
                     <br>
                     <div class="col-xs-6">
                        <select class="form-control" id="exampleSelect1" name="setTopBoxStatus" required>
                           <option selected>
                              Unassigned
                           </option>
                           <option value="1">
                              Assigned
                           </option>
                        </select>
                     </div>
                     <br>
                     <br>
                     <br>
                  </div>
               </div>
            </div>
            <div class="col-md-8">
               <input type="submit" class="btn btn-primary btn-lg btn-block" value="Submit">
            </div>
         </div>
         </div>
         </div>
      </form>
      <br>
      <br>
      <br>
      <br>
      <br>
      <!-- END -->
   </jsp:attribute>
</t:layout>