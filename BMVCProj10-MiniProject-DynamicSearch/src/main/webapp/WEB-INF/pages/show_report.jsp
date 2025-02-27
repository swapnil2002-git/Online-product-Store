<%@ page  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<h1 style="color:blue;text-align:center">Search Data dynamically</h1>

<frm:form action="search"  modelAttribute="stu">
	<table bgcolor="grey" align="center">
  <tr>
    <td>Student name</td>
    <td><frm:input path="name"/> </td>
  </tr>
  <tr>
    <td>Student year</td>
    <td><frm:input  path="year"/></td>
  </tr>
  <tr>
    <td>Student deprtment</td>
    <td><frm:input  path="dept"/></td>
  </tr>
  <tr>
  <td><input type="submit" value="submit"></td>
  <td><input type="reset" value="cancel"></td>
  </tr>
</table>
</frm:form>


<c:choose>
	<c:when test="${!empty list }">
	
		<h2 style="color:green ; text-align:center">Student Report</h2>
		<table  border="1" bgcolor="cyan" align="center">
			<tr>
				<th>Id</th>
				<th>NAME</th>
				<th>YEAR</th>
				<th>DEPATMENT</th>
			</tr>  
			<tr>
				<c:forEach var="stu" items="${list }">
				
					<tr>
						<td> ${stu.sid }</td>
						<td>${stu.name }</td>
						<td>${stu.year }</td>
						<td>${stu.dept }</td>
						<td>
						<a href="stu_edit?no=${stu.sid }">Edit</a>
						<a href="stu_delete?no=${stu.sid }">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			</tr>
		</table>
	</c:when>
		<c:otherwise>
			<h2 style="color:red;text-align:center">Student record not fount</h2>
		</c:otherwise>
</c:choose>

<br>
<br>
<h2 style="color:green; text-align:center">${resultMsg }</h2>
<br>
<br>
<br>
<h3 style="color:blue; text-align:center"><a href="register">Register student</a></h3>

    