<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<style>
body
	{
		background: url('http://sunshinehairdesigns.com/wp-content/uploads/2015/04/trend-video-background.jpg')no-repeat center fixed;
    	background-size: cover;
   	 	padding: 0;
    	margin: 0;
	}
	
	caption
	{
		font-style: italic;
		color: aqua;
		font-size: larger;
		margin: 10;
		padding: 10;
	}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<body ng-app="myApp" ng-controller="myCtrl">
<div>
<input type="text" class="form-control" placeholder="Search Here" ng-model="search">
</div>
<table align ="center" border="7">
<caption>Product Details</caption>
<th>Product_ID</th>
<th>Product_Name</th>
<th>Brand</th>
<th>Price</th>
<th>Description</th>
<th>View Details</th>
<tr ng-repeat="x in list | filter:search">
<td>{{x.product_id}}</td>
<td>{{x.name}}</td>
<td>{{x.brand}}</td>
<td>{{x.price}}</td>
<td>{{x.description}}</td>
<td><a href="/MyObsession/ProductDetails/{{x.product_id}}"><i class="material-icons" style="color:purple";>info</i></a></td>
</tr>
</table>


<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.list=${pr}
});
</script>

</body>
</html>
