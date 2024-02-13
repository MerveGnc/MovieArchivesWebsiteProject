<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.finalproject.model.Movie" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Film Arama Sonuçları</title>
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
    <h1>Film Arama Sonuçları</h1>
    <table>
            <thead>
        <tr>
            <th>Film Adı</th>
            <th>Yıl</th>
            <th>Yönetmen</th>
            <th>Tür</th>
        </tr>
                </thead>
                <tbody>  
        <c:forEach var="film" items="${filmler}">
            <tr>
                <td>${film.title}</td>
                <td>${film.year}</td>
                <td>${film.director}</td>
                <td>${film.category}</td>        
            </tr>
            
        </c:forEach>
                </tbody>
        
    </table>
</body>
</html>