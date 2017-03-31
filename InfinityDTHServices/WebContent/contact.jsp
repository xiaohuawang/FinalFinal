<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout title="Infinity DTH Services - About">
   <jsp:attribute name="head">
      <!-- Add HTML content to page header here i.e. StyleSheets -->
      <link href="css/contact.css" rel="stylesheet">
   </jsp:attribute>
   <jsp:attribute name="body">
      <div class="row">
         <div class="col-md-6">
            <div class="well well-sm">
               <form class="form-horizontal" method="post">
                  <fieldset>
                     <legend class="text-center header">Contact us</legend>
                     <div class="form-group">
                        <div class="col-md-10 col-md-offset-1">
                           <input id="fname" name="name" type="text" placeholder="First Name" class="form-control">
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-10 col-md-offset-1">
                           <input id="lname" name="name" type="text" placeholder="Last Name" class="form-control">
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-10 col-md-offset-1">
                           <input id="email" name="email" type="text" placeholder="Email Address" class="form-control">
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-10 col-md-offset-1">
                           <input id="phone" name="phone" type="text" placeholder="Phone" class="form-control">
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-10 col-md-offset-1">
                           <textarea class="form-control" id="message" name="message" placeholder="Enter your massage for us here. We will get back to you within 2 business days." rows="7"></textarea>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-md-12 text-center">
                           <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                        </div>
                     </div>
                  </fieldset>
               </form>
            </div>
         </div>
         <div class="col-md-6">
            <div>
               <div class="panel panel-default">
                  <div class="text-center header">Our Office</div>
                  <div class="panel-body text-center">
                     <h4>Address</h4>
                     <div>
                        1000 Summit Dr<br />
                        Milford OH<br />
                        #(513) 677-6500<br />
                        service@infinityDTHservices.com<br />
                     </div>
                     <hr />
                     <div id="contact-map" class="map">
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </jsp:attribute>
   <jsp:attribute name="scripts">
      <!-- Google Maps API -->
      <script src="http://maps.google.com/maps/api/js?key=AIzaSyDlgV_iUy5wVGqvjT5McIKG4_bGlmmxjxE"></script>
      <script src="js/contact.js"></script>
   </jsp:attribute>
</t:layout>