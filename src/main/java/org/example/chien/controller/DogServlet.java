package org.example.chien.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.chien.model.Dog;
import org.example.chien.service.DogService;
import org.example.chien.service.InterfaceDogService;
import jakarta.servlet.ServletException;
import org.example.chien.util.HibernateSession;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/dog")
public class DogServlet extends HttpServlet {

    private InterfaceDogService dogService;


    @Override
    public void init() throws ServletException {
        dogService = new DogService(HibernateSession.getSessionFactory());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("dogList", dogService.getAll());
        req.getRequestDispatcher("/WEB-INF/Components/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des inputs pour ajouter un chien
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String favMeal = req.getParameter("favMeal");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        // Creation d'un chien
        Dog dog = new Dog(name, breed, favMeal, dateOfBirth);
        // Ajout du chien a la liste
        dogService.addDog(dog);
        resp.sendRedirect(getServletContext().getContextPath()+"/dog");
    }
}