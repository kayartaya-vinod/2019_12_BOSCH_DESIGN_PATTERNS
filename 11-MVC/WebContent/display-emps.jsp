<%@ include file="./header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>List of all employees</h3>

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email id</th>
			<th>Salary</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${emps}" var="e">
		<tr>
			<td>
			
			<a href="./delete-employee?id=${e.id}" class="btn btn-danger">x</a>
			
			${e.firstname}</td>
			<td>${e.lastname}</td>
			<td>${e.email}</td>
			<td>${e.salary}</td>
		</tr>
		</c:forEach>
	</tbody>
	
</table>

<%@ include file="./footer.jsp" %>