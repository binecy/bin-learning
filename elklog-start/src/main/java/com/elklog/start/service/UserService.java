package com.elklog.start.service;

import com.elklog.start.dao.UserDAO;
import com.elklog.start.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;

    public User getUser(String code) {
        return dao.getUser(code);
    }
}
