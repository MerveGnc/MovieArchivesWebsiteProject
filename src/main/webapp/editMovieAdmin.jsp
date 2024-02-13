<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.finalproject.model.Movie" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Film Güncelleme</title>
    <style>
body {
font-family: "Georgia", Serif;
    background-image: url("movie.jpeg");
  filter: contrast(3.5); 
  color: navy ; 
  font-weight: bold; 
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
    <h1>Admin Film Güncelleme Sayfası </h1>
     <form action="/update2" method="post">
    <input type="hidden" name="id" value="${movie.id}" />
    <div>
        <label for="title">Başlık:</label>
        <input type="text" name="title" value="${movie.title}" />
    </div>
    <div>
        <label for="director">Yönetmen:</label>
        <input type="text" name="director" value="${movie.director}" />
    </div>
    <div>
        <label for="year">Yıl:</label>
        <input type="text" name="year" value="${movie.year}" />
    </div>
    <div>
        <label for="category">Kategori:</label>
        <input type="text" name="category" value="${movie.category}" />
    </div>
    <button type="submit">Güncelle</button>
</form>
</body>
</html>
