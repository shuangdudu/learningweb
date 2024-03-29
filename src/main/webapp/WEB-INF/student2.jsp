<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息查询</title>
</head>
<body>
当前 用户：${activeUser } <a href="${pageContext.request.contextPath }/logout.do">退出</a>
<form action="deletestu.do" method="post">
<input type="submit" value="批量删除"/>

<table width="100%" border=1>
  <tr>
  	<td>选择</td>
  	<td>姓名 </td>
  	<td>年龄</td>
  	<td>出生日期</td>
  	<td>操作</td>
  </tr>
 <c:forEach items="${list}" var="stu">
    <tr> 
    <td><input type="checkbox" name="deleteid" value="${stu.id }"/></td>
  	<td>${stu.name } </td>
  	<td>${stu.age } </td>
  	<td><fmt:formatDate value="${stu.birthday }" pattern="yyyy-MM-dd"/> </td>
  	<td><a href="editstudent/${stu.id }.do">修改</a></td>
  </tr>
 </c:forEach>
</table>
</form>

</body>
</html>