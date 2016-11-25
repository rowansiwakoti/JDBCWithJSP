
package com.leapfrog.jspjdbc.dao;

import com.leapfrog.jspjdbc.entity.Client;
import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
  
    int insert(Client c) throws ClassNotFoundException, SQLException;
    int update(Client c) throws ClassNotFoundException, SQLException;
    List<Client> getAll() throws ClassNotFoundException, SQLException;
}
