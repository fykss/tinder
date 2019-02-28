package dao;

import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class DAOUserSQL implements DAOUser<User> {

    private Connection connection;

    public DAOUserSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User get(int id) {
        String sql = String.format("SELECT * FROM vlad_users_tinder where id = %d", id);
        User user = null;

        try (PreparedStatement ps = (connection.prepareStatement(sql))) {
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(name, surname, email, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public int getId(User user) {
        int id = 0;

        try {
            PreparedStatement ps = connection.prepareStatement("select id from vlad_users_tinder where email = ? and password = ?");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void put(User item) {

    }
}
