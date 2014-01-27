<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<script type="text/javascript">
	
		$(document).ready(function(){
			
			var i = 1;
			
			 $('#addButton').on('click',function() {
				 console.log('add button clicked');
				 var thisRow = $(this).parent().parent();
			     newRow = thisRow.clone(true).insertAfter(thisRow);
			     newRow.find('input:not(#addButton)').val("");
			     newRow.find('#removeButton').show();
			    
			     $(this).attr('id','removeButton');//removeClass('addnew').addClass('remove');
			     $(this).val("Remove");
			     newRow.find('input.increment').val(parseInt(thisRow.find('input.increment').val())+1);
		      });
						 
			  /* $('#removeButton').click(function(){
					console.log('remove button clicked'); 
					$(this).parent().parent().remove();
			  });
			   */
			   
			  $('#removeButton').on('click', function(){
				  console.log('remove button clicked'); 
				  $(this).parent().parent().remove();
			  });
			
		});
		
	</script>

</head>
<body>

	<form:form method="post" action="worklog"
		modelAttribute="worklogWrapper" id="worklogForm">

		<form:errors path="*" cssClass="alert alert-danger" />

		<table id="worklogTable" class="table"
			style="position: absolute; left: 130px;">
			<tr>
				<th>Client/Internal</th>
				<th>Activity Type</th>
				<th>Project/Module</th>
				<th>Task Name</th>
				<th>Task Description</th>
				<th>Activity</th>
				<th>Hours Spent</th>
				<th>Status</th>
			</tr>

			<c:forEach items="${worklogWrapper.worklog}" var="worklog"
				varStatus="status">
				<tr>
					<td class="form-group"><form:select
							path="worklog[${status.index}].clientString" multiple="false">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${clients}" />
						</form:select></td>

					<td class="form-group"><form:select
							path="worklog[${status.index}].activityTypeSting"
							multiple="false">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${activityTypes}" />
						</form:select></td>

					<td class="form-group"><form:select
							path="worklog[${status.index}].moduleString" multiple="false">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${modules}" />
						</form:select></td>

					<td class="input-medium controls"><form:input
							path="worklog[${status.index}].taskName" /></td>
					<td class="form-group input-medium form-inline"><form:input
							path="worklog[${status.index}].taskDescription" /></td>

					<td class="input-medium"><form:select
							path="worklog[${status.index}].activityString" multiple="false">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${activities}" />
						</form:select></td>

					<td class="form-group"><form:input
							path="worklog[${status.index}].hoursSpent" /></td>

					<td class="form-group"><form:select
							path="worklog[${status.index}].statusString" multiple="false">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${statuses}" />
						</form:select></td>

					<td class="form-group" id="addAndRemoveButton">
						<button type="button" id="addButton" class="btn btn-info">Add</button>
					</td>
				</tr>
			</c:forEach>
			
			<tr><td><input type="submit" value="Save" class="btn btn-success"/></td></tr>
			
		</table>
		
		

	</form:form>

	<script type="text/javascript">
	 
 		$(document).ready(function() {
		    $("#administration").removeClass("active");
			$("#showWorklog").removeClass("active");
			$("#addWorklog").addClass("active");
		});
	 
	 </script>

</body>