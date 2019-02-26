package services;

import dao.DAO;
import dto.User;

public class ServiceUser {
    private DAO<User> daoUser;

    public ServiceUser(DAO<User> daoUser) {
        this.daoUser = daoUser;
    }

    public boolean userCheck(User user) {
        return daoUser.get(user.getId()) != null;
    }
}
