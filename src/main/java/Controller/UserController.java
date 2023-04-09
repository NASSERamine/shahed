package Controller;

import java.sql.SQLException;


import Services.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
		this.userService = new UserService();
	}

    public boolean authenticateUser(String name, String password) throws SQLException {
        return userService.authenticateUser(name, password);
    }
}
