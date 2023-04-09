package Services;

import java.sql.SQLException;

import Dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean authenticateUser(String name, String password) throws SQLException {
        return userDao.checkUser(name, password);
    }
}