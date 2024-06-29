package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		String description = request.getParameter("description");

		Connection conn = DbConnection.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into category values(?,?,?)");
			
			pstmt.setInt(1, categoryId);
			pstmt.setString(2, categoryName);
			pstmt.setString(3, description);
			
			int rowsAffected = pstmt.executeUpdate();
			
			System.out.println(rowsAffected + " rows inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
