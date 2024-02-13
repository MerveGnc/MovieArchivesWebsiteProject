<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Kontrol Paneli</title>
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
}
h1 {
  font-size: 40px;
}
h2 {
  font-size: 30px;
}

p {
  font-size: 20px;
}
</style>
</head>
<body>
    <h1>Admin Kontrol Paneli</h1>
    
    <h2>Admin Kullanıcılar:</h2>
<c:forEach items="${adminUsers}" var="user">
    <p>${user.username} - Admin</p>
    <form action="/makeNonAdmin" method="post">
        <input type="hidden" name="userId" value="${user.id}">
        <button type="submit">Non-Admin Yap</button>
    </form>
</c:forEach>

<h2>Non-Admin Kullanıcılar:</h2>
<c:forEach items="${nonAdminUsers}" var="user">
    <p>${user.username} - Non-Admin</p>
    <form action="/makeAdmin" method="post">
        <input type="hidden" name="userId" value="${user.id}">
        <button type="submit">Admin Yap</button>
    </form>
</c:forEach>
    


    

</body>
</html>
