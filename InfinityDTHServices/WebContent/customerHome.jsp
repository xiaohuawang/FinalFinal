<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout title="Customer Home">
   <jsp:attribute name="head">
   </jsp:attribute>
   <jsp:attribute name="body">
      <!-- START--------------------------------------------------------------------------- -->
      <div class="row">
      	 <div class="jumbotron">
		    <h1>Welcome ${loggedUser.username}</h1>
		    <p class="lead">Here you can order new Set Top Boxes and set up your Set Top Box Channels.</p>
		 </div>
         <div class="col-md-8 col-centered">
            <div class="panel panel-default">
               <div class="panel-heading clearfix">
                  <i class="icon-calendar"></i>
                  <h3 class="panel-title"><b>Select a plan</b> </h3>
               </div>
               <br>
               <div class="col-xs-6">
                  <select class="form-control" id="exampleSelect1" name="setTopBoxType" required autofocus>
                     <option selected>
                        Choose...
                     </option>
                     <option value="1">
                        Pre-Paid ( No deposit Required)
                     </option>
                     <option value="1">
                        Post-Paid ( No deposit Required)
                     </option>
                  </select>
                  <!------ -->
               </div>
               <br>
               <br>
               <br>
            </div>
         </div>
      </div>
      <!--  STB types ------------>
      <div class="row">
         <div class="col-md-8 col-centered">
            <div class="panel panel-default">
               <div class="panel-heading clearfix">
                  <i class="icon-calendar"></i>
                  <h3 class="panel-title"><b>Select a STB and Pick a package</b> </h3>
               </div>
               <br>
               <div class="col-xs-6">
                  <select class="form-control" id="exampleSelect1" name="setTopBoxType" required autofocus>
                     <option selected>
                        Choose...
                     </option>
                     <option value="1">
                        High Definition
                     </option>
                     <option value="2">
                        High Definition Recorder
                     </option>
                     <option value="3">
                        Internet Protocol Television (IPTV)
                     </option>
                  </select>
               </div>
               <!--  pick package  -->
               <div class="col-xs-6">
                  <select class="form-control" id="exampleSelect1" name="setTopBoxType" required autofocus>
                     <option selected>
                        Choose...
                     </option>
                     <option value="1">
                        Basic
                     </option>
                     <option value="2">
                        Entertainment
                     </option>
                     <option value="3">
                        X-tra
                     </option>
                     <option value="4">
                        Ultimate
                     </option>
                     <option value="5">
                        Premium plus Ultimate
                     </option>
                  </select>
               </div>
               <br>
               <br>
               <br>
            </div>
         </div>
      </div>
      <!-- --- --------------------------------------------------->
      <div class="row">
         <div class="col-md-8 col-centered">
            <div class="panel panel-default">
               <div class="panel-heading clearfix">
                  <i class="icon-calendar"></i>
                  <h3 class="panel-title"><b>Select add-ons</b> </h3>
               </div>
               <br>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > Sports - 9.99/ month 
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox"  ng-click="checkAll()" > International - Spanish - 9.99/month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > International - Arabic - 9.99/month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > Hindi - 9.99/ month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > International - Spanish - 9.99/month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox"  ng-click="checkAll()" > International - French - 9.99/month
               </div>
               <br>
               <br>
               <br>
               <br>
            </div>
         </div>
      </div>
      <!-- END -------------------------------------------------------------------------------------->
      <div class="row">
         <div class="col-md-8 col-centered">
            <div class="panel panel-default">
               <div class="panel-heading clearfix">
                  <i class="icon-calendar"></i>
                  <h3 class="panel-title"><b>Select premium channels</b></h3>
               </div>
               <br>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > HBO - 5.99/ month 
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox"  ng-click="checkAll()" > International - 9.99/month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > Fox-Soccer - 9.99/month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > NFL - 9.99/ month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox" ng-model="selectedAll.value" ng-click="checkAll()" > Show Time -  9.99/month
               </div>
               <div class="col-xs-6">               
                  <input type="checkbox"  ng-click="checkAll()" > Transvision -  9.99/month
               </div>
               <br>
               <br>
               <br>
               <br>
            </div>
         </div>
      </div>
      <!-- END -------------------------------------------------------------------------------------->
      <div class="col-md-2 col-centered">
         <input type="submit" class="btn btn-primary btn-lg btn-block" value="Submit">
      </div>
      <br>
      <br>
      <br>
   </jsp:attribute>
</t:layout>