
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" >
    <h1>Dogs List</h1>

    <ul class="list-group" >
        <c:forEach var="dog" items="${dogList}">
            <li class="list-group-item">
                <strong>${dog.name}</strong>
                <p>Breed : ${dog.breed} </p>
                <p>Favorite Meal : ${dog.favMeal}</p>
                <p>Birthdate : ${dog.dateOfBirth}</p>

            </li>

        </c:forEach>

        <c:if test="${dogList.size() == 0}">
            <p>No dogs found</p>
        </c:if>
    </ul>
</div>

