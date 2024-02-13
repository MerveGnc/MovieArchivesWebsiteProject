<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.finalproject.model.Movie" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Bütün Filmler</title>
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
<div class="container">
    <h1>Tüm Filmler</h1>
    <table>
        <thead>
            <tr>
                <th>Başlık</th>
                <th>Yönetmen</th>
                <th>Yıl</th>
                <th>Kategori</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movies}" var="movie">
                 <tr style="padding-bottom: 20px;">
    <td style="font-weight: bold;">${movie.title}</td>
    <td style="font-weight: bold;">${movie.director}</td>
    <td style="font-weight: bold;">${movie.year}</td>
    <td style="font-weight: bold;">${movie.category}</td>
</tr>


            </c:forEach>
        </tbody>
    </table>
    </div>
</body>
</html>
