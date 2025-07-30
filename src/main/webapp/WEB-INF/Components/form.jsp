
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="Cat" scope="request" type="java.util.List"/>--%>

<div class="container" >

    <h1>Add a new Dog</h1>

    <form action="${pageContext.request.contextPath}/dog" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name :</label>
                <input type="text" class="form-control" id="name" name="name" >
            </div>
            <div class="mb-3">
                <label for="breed" class="form-label">Breed :</label>
                <input type="text" class="form-control" id="breed" name="breed">
            </div>

            <div class="mb-3">
                <label for="favMeal" class="form-label">Favorite Meal :</label>
                <input type="text" class="form-control" id="favMeal" name="favMeal">
            </div>
            <div class="mb-3">
                <label for="dateOfBirth" class="form-label">Birth Date :</label>
                <input type="date" class="form-control" id="dateOfBirth"  name="dateOfBirth">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>


