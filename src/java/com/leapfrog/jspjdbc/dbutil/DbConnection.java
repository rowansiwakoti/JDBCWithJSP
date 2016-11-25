package com.leapfrog.jspjdbc.dbutil;

import com.leapfrog.jspjdbc.constant.DBConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

    private Connection conn = null;
    private PreparedStatement stmt = null;

    public void open() throws ClassNotFoundException, SQLException {
        Class.forName(DBConstant.DB_DRIVER);
        conn = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_password);
    }

    public PreparedStatement initStatement(String sql) throws SQLException {

        stmt = conn.prepareStatement(sql);
        return stmt;
    }

    public int executeUpdate() throws SQLException {
        return stmt.executeUpdate();
    }

    public ResultSet executeQuery() throws SQLException {
        return stmt.executeQuery();
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }
}
