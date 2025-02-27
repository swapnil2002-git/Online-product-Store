<%@ page  isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>


<h2 style="color:red;text-align:center">Registration form</h2>
<br>
<br>
<br>
<h3 style="color:green; text-align:center">${resultMsg }</h3>
<br>
<br>    
<frm:form modelAttribute="stu" >
<table >  
  <tr>
    <td>Student Name : </td>
    <td><frm:input path="name"/></td>
  </tr>
  <tr>
    <td>Student year : </td>
    <td><frm:input path="year"/></td>
  </tr>
  <tr>
    <td>Student department : </td>
    <td><frm:input path="dept"/> </td>
  </tr>
  <tr>
  <td> <input type="submit" value="submit"> </td>
  <td> <input type="Reset" value="cancel"> </td>
  </tr>
 
</table>
</frm:form>

