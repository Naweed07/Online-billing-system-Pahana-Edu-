package com.pahanaedu.servlet;


import com.pahanaedu.dao.CustomerDAO;
import com.pahanaedu.model.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        String unitsStr = req.getParameter("units_consumed");

        // basic validation
        if (name == null || name.isBlank() || unitsStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required fields");
            return;
        }
        int units = 0;
        try { units = Integer.parseInt(unitsStr); } catch (NumberFormatException e) { units = 0; }

        customer c = new customer(name.trim(), address == null ? "" : address.trim(), telephone == null ? "" : telephone.trim(), units);
        try {
            CustomerDAO dao = new CustomerDAO();
            int accountNumber = dao.addCustomer(c);
            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("customer", c);
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
