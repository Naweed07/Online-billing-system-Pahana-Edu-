package com.pahanaedu.servlet;

import com.pahanaedu.dao.CustomerDAO;
import com.pahanaedu.model.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        String unitsStr = req.getParameter("units_consumed");

        if (name == null || name.isBlank() || unitsStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required fields");
            return;
        }

        int unitsConsumed;
        try {
            unitsConsumed = Integer.parseInt(unitsStr);
        } catch (NumberFormatException e) {
            unitsConsumed = 0;
        }

        Customer customer = new Customer(name.trim(), address == null ? "" : address.trim(),
                                         telephone == null ? "" : telephone.trim(),
                                         unitsConsumed);

        try {
            CustomerDAO dao = new CustomerDAO();
            int accountNumber = dao.addCustomer(customer);
            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
