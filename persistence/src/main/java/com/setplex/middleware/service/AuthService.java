package com.setplex.middleware.service;

import com.setplex.middleware.util.PasswordHelper;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private String hash = "93pu7p+l9cTtJVUMRUDy2v26D5C1xsnDdGbxyw6KT6N9rvWhVa0mVwGCIHrD2nP1Ih03cn7eOmyWgsXMflzhmw==";
  private String salt = "z47ClQ/lKBYDutdFAQJg68NRi3+qKWUddGhBWEaHJdTixiEnK7EufALzn8dao/VGlJuOpP5csDRlu8rjb7Oi1s12mJOGZYqgaRcMBl3BbVg6yRgt0TQz2Y8ExW2H/iEqEOUSaNfZxahW+UUo+kIku/JHHxDq+dCaJiB9rReU4w8=";

    //password - pwd
    public boolean checkPassword(String login, String password){
      return PasswordHelper.check(password, hash, salt);
  }
}
