<%@ page  isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h2 style="color:green; text-align:center">Update Student details</h2>

 <frm:form modelAttribute="stu">  
 	<table align="center" bgcolor="cyan">
 		<tr>
 			<td>Student Id</td>
 			<td> <frm:input path="sid" readonly="true" /> </td>
 		</tr>
 		<tr>
 			<td>Student name : : </td>
 			<td> <frm:input path="name"/> </td>
 		</tr>
 		<tr>
 			<td>Student year :: </td>
 			<td><frm:input path="year"/></td>
 		</tr>
 		<tr>
 			<td>Student dept</td>
 			<td><frm:input path="dept"/></td>
 		</tr>
 		<tr>
 		<td>
 		<input type="submit" value="update" />
 		</td>
 		<td>
 		<input type="reset" value="cancle" />
 		</td>
 		</tr>
 	</table>
 
 </frm:form>