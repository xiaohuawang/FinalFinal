<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout title="Manage Channel Packages">
   <jsp:attribute name="head">
      <!-- Add HTML content to page header here i.e. StyleSheets -->
      <link href="css/styles.css" rel="stylesheet">
   </jsp:attribute>
   <jsp:attribute name="body">
      <br>
      <!-- Add HTML content to page body here -->
      <!--3rd input field-->
      <div class="container">
         <div class="row">
            <div class="control-group" id="fields">
               <div class="controls">
                  <form method="post" action="channel-package">
                     <h2>Manage Channel Packages</h2>
                     <br>
                     <!--1st input field--Package Name-->
                     <div class="form-group">
                        <label for="inputdefault">Package Name</label>
                        <input class="form-control" id="inputdefault" type="text" name="packageName">
                     </div>
                     <!--2nd input field--Package Charging Type(Paid or FTA-->			
                     <div class="form-group">
                        <label for="inputdefault">Package Charging Type(Paid or FTA)</label>
                        <select class="form-control" id="sel1" name="packageChargingType">
                           <option>Paid</option>
                           <option>FTA</option>
                        </select>
                     </div>
                     <!--3rd input field--Package Transmission Type-->
                     <div class="form-group">
                        <label for="sel1">Package Transmission Type</label>
                        <select class="form-control" id="sel1" name="packageTransmissionType">
                           <option>HD</option>
                           <option>Standard</option>
                        </select>
                     </div>
                     <!--4th input field--Add Channels-->
                
                     <div class="form-group">
                        <label for="inputdefault">Add Channels</label>
                        <div class="checkbox">
                           <label><input name="standard" type="checkbox" value="standard">Standard</label>
                        </div>
                        <div class="checkbox">
                           <label><input name="hd" type="checkbox" value="highDefinition">High Definition</label>
                        </div>
                        <div class="checkbox">
                           <label><input name="hdRecorder" type="checkbox" value="HDRecorder">HD Recorder</label>
                        </div>
                        <div class="checkbox">
                           <label><input name="iptv" type="checkbox" value="IPTV">IPTV</label>
                        </div>
                     </div>
                     <!--5th input field--Package Cost-->
                     <div class="form-group">
                        <label for="inputdefault">Package Cost</label>
                        <input class="form-control" id="inputdefault" type="text" name="packageCost">
                     </div>
                     <!--6th input field--Package Available from Date-->	
                     <!--Add starting date-->
                     <div class="container">
                        <div class="row">
                           <label for="sel1">Package Available from Date</label>
                        </div>
                        <div class="row">
                           <div class='col-sm-3'>
                              <div class="form-group">
                                 <div class='input-group date' id='datetimepicker1'>
                                    <input type='date' class="form-control" name="packageAvailableFromDate"/>		              
                                 </div>
                              </div>
                           </div>
                        </div>
                        <!--7th input field-->		
                        <!--Add Ending date-->
                        <div class="row">
                           <label for="sel1">Package Available to Date</label>
                        </div>
                        <div class="row">
                           <div class='col-sm-3'>
                              <div class="form-group">
                                 <div class='input-group date' id='datetimepicker1'>
                                    <input type='date' class="form-control" name="packageAvailableToDate"/>		              
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     <br>
                     <!--8th input field-->
                     <label for="sel1">Added by default</label>
                     <input id= "sel12" type="radio" name="addByDefault" value="Yes" name="yes"> <span>Yes</span>
                     <input id= "sel1" type="radio" name="addByDefault" value="No" name="no"> <span>No</span><br>
                     <br>
                    
                     <!--9th input field-->
                     <div class="form-group" >
                        <label for="inputdefault">Package Category</label>
                        <div class="checkbox">
                           <label><input type="checkbox" value="" name="sports">Sports</label>
                        </div>
                        <div class="checkbox">
                           <label><input type="checkbox" value="" name="news">News</label>
                        </div>
                        <div class="checkbox">
                           <label><input type="checkbox" value="" name="kids">Kids</label>
                        </div>
                        <div class="checkbox">
                           <label><input type="checkbox" value="" name="nature">Nature</label>
                        </div>
                     </div>
                     <br>
                     <br>
                     
                     
                     <label class="control-label" for="field1">Add new Category</label>
                     <small>Press <span class="glyphicon glyphicon-plus gs"></span> to add another category</small>
                     <div class="entry input-group col-xs-3">
                        <input class="form-control" name="fields[]" type="text" placeholder="Type Category" />
                        <span class="input-group-btn">
                        <button class="btn btn-success btn-add" type="button" name="addNewCategory">
                        <span class="glyphicon glyphicon-plus"></span>
                        </button>
                        </span>
                     </div>
                     <br>
                     <br>
                        <input type="submit" class="btn btn-info" value="Submit" name="submit">
                     
                  </form>
               </div>
            </div>
         </div>
      </div>
      
      <br>
   </jsp:attribute>
</t:layout>