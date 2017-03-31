<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout title="Customer Registration">
   <jsp:attribute name="head">
      <link href="css/customer.css" rel="stylesheet">
   </jsp:attribute>
   <jsp:attribute name="body">
      <!-- ------------------------------------------------------------------------------ -->
      <div class="page-body">
         <div class="container">
            <h2>New Customer Registration</h2>
            <form id="form" method="post" action="customer">
               <!-- name -------------------------------------------------------------------------------------- -->
               <div class="row">
                  <div class="col-md-8">
                     <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                           <i class="icon-calendar"></i>
                           <h3 class="panel-title">Name:</h3>
                        </div>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="firstName" type="text" name="firstName" value="${customer.firstName}" required autofocus placeholder="First name">
                        </div>
                        <div class="col-xs-6">
                           <input class="form-control" id="lastName" type="text" name="lastName" value="${customer.lastName}" required placeholder="Last name">
                        </div>
                        <br>
                        <br>
                        <br>
                     </div>
                  </div>
               </div>
               <!-- Contact Information  --------------------------------------------------------------------------- -->
               <div class="row">
                  <div class="col-md-8">
                     <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                           <i class="icon-calendar"></i>
                           <h3 class="panel-title">Contact Information:</h3>
                        </div>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="emailId" type="text" name="emailId" value="${customer.emailAddress}" required placeholder ="E-mail ID">
                        </div>
                        <div class="col-xs-6">
                           <input class="form-control" id="phoneNumber" type="text" place name="phoneNumber" value="${customer.phoneNumber}" required placeholder="Phone Number">
                        </div>
                        <br>
                        <br>
                        <br>
                     </div>
                  </div>
               </div>
               <!-- New user name and Password --------------------------------------------------------------------------- -->
               <div class="row">
                  <div class="col-md-8">
                     <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                           <i class="icon-calendar"></i>
                           <h3 class="panel-title">Create User Name and Password :</h3>
                        </div>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="UserName" type="text" name="userName" value="${user.username}" required placeholder="User Name">
                        </div>
                        <br>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="passwword" type="password" name="password" value="${user.password}" required placeholder="New Password">
                        </div>
                        <div class="col-xs-6">
                           <input class="form-control" id="password" type="password" name="password" value="${user.password}" required placeholder="Re-Type Password">
                        </div>
                        <br>
                        <br>
                        <br>
                     </div>
                  </div>
               </div>
               <!-- Customer Address --------------------------------------------------------------------------- -->
               <div class="row">
                  <div class="col-md-8">
                     <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                           <i class="icon-calendar"></i>
                           <h3 class="panel-title">Address:</h3>
                        </div>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="address" type="text" name="address" required placeholder="Streeet Address">
                        </div>
                        <div class="col-xs-6">
                           <input class="form-control" id="address1" type="text" name="address1" value="${address.address1}" placeholder="cont. Address">
                        </div>
                        <br>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="address2" type="text" name="address2" value="${address.address2}" placeholder="cont. Address">
                        </div>
                        <div class="col-xs-6">
                           <input class="form-control" id="landMark" type="text" name="landMark" value="${address.landMark}" placeholder="Land Mark">
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control" id="pinCode" type="text" name="pinCode" value="${address.pinCode}" required placeholder= "Pin Code">
                        </div>
                        <div class="col-xs-6">
                           <input class="form-control" id="city" type="text" name="city" value="${address.city}" required placeholder="City">
                        </div>
                        <br>
                        <br>
                        <div class="col-xs-6">
                           <select class="form-control" for="input-lg" id="state" name="state" required>
                              <option value="AL">State</option>
                              <option value="AL">Alabama</option>
                              <option value="AK">Alaska</option>
                              <option value="AZ">Arizona</option>
                              <option value="AR">Arkansas</option>
                              <option value="CA">California</option>
                              <option value="CO">Colorado</option>
                              <option value="CT">Connecticut</option>
                              <option value="DE">Delaware</option>
                              <option value="DC">District of Columbia</option>
                              <option value="FL">Florida</option>
                              <option value="GA">Georgia</option>
                              <option value="HI">Hawaii</option>
                              <option value="ID">Idaho</option>
                              <option value="IL">Illinois</option>
                              <option value="IN">Indiana</option>
                              <option value="IA">Iowa</option>
                              <option value="KS">Kansas</option>
                              <option value="KY">Kentucky</option>
                              <option value="LA">Louisiana</option>
                              <option value="ME">Maine</option>
                              <option value="MD">Maryland</option>
                              <option value="MA">Massachusetts</option>
                              <option value="MI">Michigan</option>
                              <option value="MN">Minnesota</option>
                              <option value="MS">Mississippi</option>
                              <option value="MO">Missouri</option>
                              <option value="MT">Montana</option>
                              <option value="NE">Nebraska</option>
                              <option value="NV">Nevada</option>
                              <option value="NH">New Hampshire</option>
                              <option value="NJ">New Jersey</option>
                              <option value="NM">New Mexico</option>
                              <option value="NY">New York</option>
                              <option value="NC">North Carolina</option>
                              <option value="ND">North Dakota</option>
                              <option value="OH">Ohio</option>
                              <option value="OK">Oklahoma</option>
                              <option value="OR">Oregon</option>
                              <option value="PA">Pennsylvania</option>
                              <option value="RI">Rhode Island</option>
                              <option value="SC">South Carolina</option>
                              <option value="SD">South Dakota</option>
                              <option value="TN">Tennessee</option>
                              <option value="TX">Texas</option>
                              <option value="UT">Utah</option>
                              <option value="VT">Vermont</option>
                              <option value="VA">Virginia</option>
                              <option value="WA">Washington</option>
                              <option value="WV">West Virginia</option>
                              <option value="WI">Wisconsin</option>
                              <option value="WY">Wyoming</option>
                           </select>
                        </div>
 						<br>
                        <br>
                        <br>
                        <br>
                     </div>
                  </div>
               </div>
               <!-- --------------------------------------------------------------------------- -->
               <div class="row">
                  <div class="col-md-8">
                     <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                           <i class="icon-calendar"></i>
                           <h3 class="panel-title">Retailer Creation Date:</h3>
                        </div>
                        <br>
                        <div class="col-xs-6">
                           <input class="form-control input-sm" type="date" name="date" id="theDate" readonly>
                        </div>
                        <br>
                        <br>
                     </div>
                  </div>
               </div>
               <!-- Submit -------------------------------------------------------------------------------------- -->
               <div class="col-md-8">
                  	<input type="submit" class="btn btn-primary btn-lg btn-block" name="action" value="insert" />
					<input type="submit" class="btn btn-primary btn-lg btn-block" name="action" value="updateupdate" />
               </div>  
 				<br>
               <br>
               <br>
            </form>
 			</div>
      </div>
      </body>
   </jsp:attribute>
</t:layout>