$(document).ready(function() {
	function init_map() {
        var myLocation = new google.maps.LatLng(38.885516, -77.09327200000001);
        var mapOptions = {
            center: myLocation,
            zoom: 16
        };
        var marker = new google.maps.Marker({
            position: myLocation,
            title: "Property Location"
        });
        var map = new google.maps.Map(document.getElementById("contact-map"),
            mapOptions);
        marker.setMap(map);
    }
    init_map(); 
});