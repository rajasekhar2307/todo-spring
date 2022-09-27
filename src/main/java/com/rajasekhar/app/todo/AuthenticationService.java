package com.rajasekhar.app.todo;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("rajasekhar2307");
        boolean isValidPassword = password.equalsIgnoreCase("1234");

        return isValidPassword && isValidUsername;
    }
}
