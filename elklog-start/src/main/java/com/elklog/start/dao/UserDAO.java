package com.elklog.start.dao;

import com.elklog.start.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    public User getUser(String code) {
        return new User(code, "bin");
    }
}
