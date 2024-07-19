<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Управління цитатами</title>
</head>
<body>
<h1>Довільна цитата</h1>
<p>${randomQuote.text} - ${randomQuote.author}</p>

<h2>Усі цитати</h2>
<ul>
    <c:forEach var="quote" items="${quotes}">
        <li>${quote.id}) ${quote.text} - ${quote.author} (${quote.category})</li>
    </c:forEach>
</ul>

<h2>Додати цитату</h2>
<form method="post" action="quotes">
    <input type="hidden" name="action" value="add">
    <input type="text" name="quoteText" placeholder="Текст цитати" required>
    <input type="text" name="quoteAuthor" placeholder="Автор" required>
    <input type="text" name="quoteCategory" placeholder="Категорія" required>
    <button type="submit">Додати</button>
</form>

<h2>Редагувати цитату</h2>
<form method="post" action="quotes">
    <input type="hidden" name="action" value="edit">
    <input type="number" name="quoteId" placeholder="ID цитати" required>
    <input type="text" name="quoteText" placeholder="Текст цитати" required>
    <input type="text" name="quoteAuthor" placeholder="Автор" required>
    <input type="text" name="quoteCategory" placeholder="Категорія" required>
    <button type="submit">Редагувати</button>
</form>

<h2>Видалити цитату</h2>
<form method="post" action="quotes">
    <input type="hidden" name="action" value="delete">
    <input type="number" name="quoteId" placeholder="ID цитати" required>
    <button type="submit">Видалити</button>
</form>
</body>
</html>
