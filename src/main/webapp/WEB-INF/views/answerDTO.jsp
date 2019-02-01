<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <table>
       <tr>
           <td>idUser</td>
           <td>nameUser</td>
       </tr>
       <c:forEach items="${requestScope.list}" var="item">
           <tr>
               <td>${item}</td>
           </tr>
       </c:forEach>
   </table>

   <table>
       <tr>
           <td>idDTO_User</td>
           <td>nameDTO_User</td>
       </tr>
       <c:forEach items="${requestScope.list2}" var="item">
           <tr>
               <td>${item}</td>
           </tr>
       </c:forEach>
   </table>


</body>
</html>
