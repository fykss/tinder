package services;

import dao.DAO;
import dao.DAOUser;
import dao.DAOUserSQL;
import dto.User;

import java.sql.Connection;

public class ServiceUser {
    private DAOUser<User> daoUser;

    public ServiceUser(Connection connection) {
        this.daoUser = new DAOUserSQL(connection);
    }


}
