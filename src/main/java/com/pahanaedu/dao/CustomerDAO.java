package com.pahanaedu.dao;


import com.pahanaedu.model.customer;
import com.pahanaedu.util.DBUtil;
import java.sql.*;

public class CustomerDAO {
    public int addCustomer(customer c) throws Exception {
        String sql = "INSERT INTO customers (name, address, telephone, units_consumed) VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getTelephone());
            ps.setInt(4, c.getUnitsConsumed());
            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Insert failed, no rows affected.");
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int generatedId = keys.getInt(1);
                    c.setAccountNumber(generatedId);
                    return generatedId;
                } else {
                    throw new SQLException("Insert succeeded but no ID obtained.");
                }
            }
        }
    }
}
