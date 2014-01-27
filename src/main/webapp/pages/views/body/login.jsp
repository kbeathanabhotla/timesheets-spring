<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
	<form:form action="login" method="POST" modelAttribute="login">
		<form:select path="name" multiple="false">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${persons}" />
			<input type="submit" value="Login" />
		</form:select>
	</form:form>
	
	<script type="text/javascript">
	 
 		$(document).ready(function() {
		    $("#administration").hide();
			$("#showWorklog").hide();
			$("#addWorklog").hide();
			$("#logout").hide();
		});
	 
	 </script>
	
</body>
