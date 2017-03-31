<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Manage Channels">
   <jsp:attribute name="head">
      <!-- Add HTML content to page header here i.e. StyleSheets -->
   </jsp:attribute>
   <jsp:attribute name="body">
      <!-- START -->
      <!-- Main component for a primary marketing message or call to action -->
      <div>
         <form method="post" action="channel">
            <div class="container">
               <br>
               <br>
               <h2> Manage Channels </h2>
            </div>
            <br>
            <div class="form-group">
               <label for="channelName">Channel Name</label>
               <input class="form-control input-sm" id="channelName"
                  type="text" name="channelName">
            </div>
            <br>
            <div class="form-group1">
               <label for="channelBand">Select Channel Band :</label>
               <select class="form-control input-sm" id="channelBand"
                  name="channelBand">
                  <option> Band I </option>
                  <option> Band II </option>
                  <option> Band III </option>
                  <option> Band IV </option>
               </select>
            </div>
            <br>
            <div class="form-group2">
               <label for="videoCarrierFreq">Video Carrier Frequency (between 40Mhz and 225Mhz):</label>
               <input type="number" name="videoCarrierFreq" min="40" max="225"><br>
            </div>
            <br>
            <div class="form-group3">
               <label for="audioCarrierFreq">Audio Carrier Frequency (between 45Mhz and 230Mhz):</label>
               <input type="number" name="audioCarrierFreq" min="45" max="230">
               <br> 
            </div>
            <br>
            <div class="form-group4">
               <label for="channelChargeType">Channel Charge Type</label>
               <select class="form-control input-sm" id="channelChargeType"
                  name="channelChargeType">
                  <option> FTA (Free to Air) </option>
                  <option> Paid </option>
               </select>
            </div>
            <br>
            <div class="form-group5">
               <label for="channelTransType">Channel Transmission Type</label>
               <select class="form-control input-sm" id="channelTransType"
                  name="channelTransType">
                  <option> Standard </option>
                  <option> High Definition </option>
               </select>
            </div>
            <br>
            <div class="form-group6">
               <label for="channelCharge">Channel Charge</label>
               <input class="form-control" type="text" id="channelCharge"
                  name="channelCharge" value="2.00" readonly>
            </div>
            <br>
            <button type="submit" id="submit" name="submit" class="btn btn-default">Submit</button>
            <br><br>
         </form>
      </div>
      <br><br>	
      <!-- END -->
   </jsp:attribute>
</t:layout>