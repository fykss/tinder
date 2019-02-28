package services;

import dao.DAO;
import dto.User;

public class ServiceUser {
    private DAO<User> dao;

    public ServiceUser(DAO<User> dao) {
        this.dao = dao;
    }

    public boolean userCheck(User user) {
        return dao.get(dao.getId(user)) != null;
    }

    public boolean checkPassword(User user) {
        return dao.get(dao.getId(user)).getPassword().equals(user.getPassword());
    }

    public User get(int id) {
        return dao.get(id);
    }

    public int getId(String mail, String password) {
        User user = new User(mail, password);
        return dao.getId(user);
    }
}
