package services;

import dao.DAO;
import dto.User;

public class ServiceUser {
    private DAO<User> daoUser;

    public ServiceUser(DAO<User> daoUser) {
        this.daoUser = daoUser;
    }

    public boolean userCheck(User user) {
        return daoUser.get(daoUser.getId(user)) != null;
    }

    public boolean checkPassword(User user){
        return daoUser.get(daoUser.getId(user)).getPassword().equals(user.getPassword());
    }

    public User get(int id) {
        return daoUser.get(id);
    }

    public int getId(User user) {
        return daoUser.getId(user);
    }
}
