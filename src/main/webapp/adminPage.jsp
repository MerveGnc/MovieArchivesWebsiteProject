<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Film Güncelleme/Silme Sayfası</title>
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
    <h1>Tüm Filmler</h1>
    <table>
        <thead>
            <tr>
                <th>Başlık</th>
                <th>Yönetmen</th>
                <th>Yıl</th>
                <th>Kategori</th>
                <th>Güncellle</th>
                <th>Sil</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.year}</td>
                    <td>${movie.category}</td>
                    <td>
                        <a href="/edit2?id=${movie.id}">Güncelle</a>
                         <td><a href="/delete2/${movie.id}">Sil</a></td>  
                </tr>
                   
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

