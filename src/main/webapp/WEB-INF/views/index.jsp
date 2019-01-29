<%--
  Created by IntelliJ IDEA.
  User: galkin
  Date: 15.12.18
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="${action}" method = "post">

     <input type="text" name="username" size="37" value="Surname, name"/>
     <br>
     <br>

     <label for="station-start">Станція посадки:</label>
     <input list="stations" id="station-start" name="station-start" />

     <datalist id="stations">
         <option value="Station1">
         <option value="Station2">
         <option value="Station3">
         <option value="Station4">
         <option value="Station5">
     </datalist>
     <br>
     <br>
     <label for="station-terminal">Станція висадки:</label>
     <input list="stations" id="station-terminal" name="station-terminal" />
     <br>
     <br>
     <input type = "submit"
            name="ok"
            value="                              вибрати                              "
            onclick = "document.getElementById('printtext').innerHTML=Date()"
     />
     <p id="printtext"></p>
</form>


</body>
</html>
