package com.leapfrog.jspjdbc.dao.impl;

import com.leapfrog.jspjdbc.constant.DBConstant;
import com.leapfrog.jspjdbc.dao.ClientDAO;
import com.leapfrog.jspjdbc.dbutil.DbConnection;
import com.leapfrog.jspjdbc.entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDAO {

    private DbConnection db = new DbConnection();

    @Override
    public int insert(Client c) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO tbl_clients"
                + "(name,email,contact_no,status) "
                + "VALUES(?,?,?,?)";

        db.open();
        PreparedStatement statement = db.initStatement(sql);

        statement.setString(1, c.getName());
        statement.setString(2, c.getEmail());
        statement.setString(3, c.getContactNo());
        statement.setBoolean(4, c.isStatus());

        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Client c) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE tbl_clients SET "
                + "name=?,email=?,contact_no=?,status=? "
                + "WHERE client_id=?";

        Class.forName(DBConstant.DB_DRIVER);
        Connection conn = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_password);
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, c.getName());
        statement.setString(2, c.getEmail());
        statement.setString(3, c.getContactNo());
        statement.setBoolean(4, c.isStatus());
        statement.setInt(5, c.getId());

        int result = statement.executeUpdate();
        conn.close();
        return result;

    }

    @Override
    public List<Client> getAll() throws ClassNotFoundException, SQLException {

        List<Client> clientList = new ArrayList<>();

        db.open();
        String sql = "SELECT * from tbl_clients";
        PreparedStatement statement = db.initStatement(sql);

        ResultSet rs = db.executeQuery();
        while (rs.next()) {

            Client client = new Client();
            client.setId(rs.getInt("client_id"));
            client.setName(rs.getString("name"));
            client.setEmail(rs.getString("email"));
            client.setContactNo(rs.getString("contact_no"));
            client.setAddedDate(rs.getDate("added_date"));
            client.setStatus(rs.getBoolean("status"));

            clientList.add(client);
        }
        db.close();
        return clientList;
    }
}
