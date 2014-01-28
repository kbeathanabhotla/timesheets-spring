<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=IE9">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<link rel="stylesheet" href="/timesheets/pages/css/bootstrap.min.css">
<script src="/timesheets/pages/js/jquery-1.10.2.min.js"></script>
<script src="/timesheets/pages/js/bootstrap.min.js"></script>
  
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>
	
	<div class="navbar" style="height:7%">
		<div class="container">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
	</div>

	<div style="height:87%">
		<div style="position: absolute; left:0px; width:11%;padding-left:5px;">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
		<div style="position: absolute; left:10%; width:87%">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</div>

	<div id="footer" style="bottom:0px; position:absolute; height:5%">
		<div class="container">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>

</body>
</html>