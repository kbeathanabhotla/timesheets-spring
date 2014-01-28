<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div style="position:relative;top:80px;left:18%;">
		<c:forEach items="${months}" var="month" varStatus="status">
			<a href="./showWorklog?month=${month}" class="btn btn-primary btn-info btn-lg" style="width:150px;bottom">${month}</a><br />
		</c:forEach>
	</div>
</body>