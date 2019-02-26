package dao;

import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class DAOUserSQL implements DAOUser <User> {

    private Connection connection;

    public DAOUserSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public boolean check(User user) {
        boolean flag = false;
        try(PreparedStatement ps =(connection.prepareStatement("SELECT email, password FROM vlad_users_tinder where email = ? and password = ?"))) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String emailSql = resultSet.getString(1);
                String passwordSql = resultSet.getString(2);
                flag = user.getEmail().equals(emailSql) && user.getPassword().equals(passwordSql);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return flag;
    }


    @Override
    public int getId(User user) {
        return 0;
    }
}
