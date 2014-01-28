<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<script type="text/javascript">
	 
 		$(document).ready(function() {
		    $("#administration").removeClass("active");
			$("#showWorklog").addClass("active");
			$("#addWorklog").removeClass("active");
		});
	 
	 </script>
</head>
<body>
	<span style="right: 0px; position: absolute; color: rgb(0, 143, 255);">Hello
		<c:out value="${sessionScope.user}"></c:out>
	</span>
	
	<c:choose>
		<c:when test="${empty worklogs}">
			Please Add your worklogs in the "Add Worklog" tab above			
		</c:when>
		<c:otherwise>
			<table class="table table-striped" style="top: 50px; position: relative; left: 31px;">
				<tr>
					<th>Date</th>
					<th>Client/ Internal</th>
					<th>Activity Type</th>
					<th>Project/Module</th>
					<th>Task Name</th>
					<th>Task Description</th>
					<th>Activity</th>
					<th>Hours Spent</th>
					<th>Status</th>
				</tr>
		
				<c:forEach items="${worklogs}" var="worklog" varStatus="status">
					<tr>
						<td><c:out value="${worklog.date}" /></td>
						<td><c:out value="${worklog.client.name}" /></td>
						<td><c:out value="${worklog.activityType.name}" /></td>
						<td><c:out value="${worklog.module.name}" /></td>
						<td><c:out value="${worklog.taskName}" /></td>
						<td><c:out value="${worklog.taskDescription}" /></td>
						<td><c:out value="${worklog.activity.name}" /></td>
						<td><c:out value="${worklog.hoursSpent}" /></td>
						<td><c:out value="${worklog.status.name}" /></td>
					</tr>
				</c:forEach>
		
			</table>
						
		</c:otherwise>	
	</c:choose>
</body>