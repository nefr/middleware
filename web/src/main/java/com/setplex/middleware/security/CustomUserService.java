package com.setplex.middleware.security;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomUserService extends JdbcDaoImpl {

    private final static String SQL_ROLE = "SELECT username, role AS authority FROM user WHERE username = ?";
    private final static String SQL_USER = "SELECT username, password, enabled FROM user WHERE username = ?";

    public CustomUserService() {
        this.setAuthoritiesByUsernameQuery(SQL_ROLE);
        this.setUsersByUsernameQuery(SQL_USER);
    }
}
