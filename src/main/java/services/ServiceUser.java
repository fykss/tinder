package services;

import dao.DAOUser;
import dto.User;

public class ServiceUser {
    private DAOUser<User> daoUser;

    public ServiceUser(DAOUser<User> daoUser) {
        this.daoUser = daoUser;
    }

    public boolean userCheck(User user) {
        return daoUser.get(daoUser.getId(user)) != null;
    }

    public boolean checkPassword(User user) {
        return daoUser.get(daoUser.getId(user)).getPassword().equals(user.getPassword());
    }

    public User get(int id) {
        return daoUser.get(id);
    }

    public int getId(String mail, String password) {
        User user = new User(mail, password);
        return daoUser.getId(user);
    }
}
