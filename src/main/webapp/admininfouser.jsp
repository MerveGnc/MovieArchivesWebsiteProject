<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	Kullanıcı Bilgileri</title>
  <style>
body {
font-family: "Georgia", Serif;
    background-image: url("movie.jpeg");
  filter: contrast(3.5); /* Kontrastı artırma */
  color: navy ; /* Yazı rengi beyaz */
  font-weight: bold; /* Yazı kalınlığı */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 90vh;
}

.container {
  text-align: center;
  margin-top: 20px;
  font-weight: bold;
}
h1 {
  font-size: 40px;
}

p {
  font-size: 20px;
}
</style>
</head>

<body>
 <h1>Kullanıcı Bilgileri</h1>
    <table>
        <tr>
            <th>Kullanıcı Adı</th>
            <th>İsim</th>
            <th>Soyisim</th>
            <th>Email</th>
            <th>Telefon</th>
        
           
           
        </tr>
         <c:forEach var="user" items="${users}">
             <tr>
              <td>${user.username}</td> 
              <td>${user.firstName}</td> 
              <td>${user.lastName}</td> 
                <td>${user.email}</td> 
                <td>${user.phone}</td>
       
              
             </tr> 
             
          </c:forEach>




    </table>

</body>
</html>