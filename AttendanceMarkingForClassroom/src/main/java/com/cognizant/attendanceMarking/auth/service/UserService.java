package com.cognizant.attendanceMarking.auth.service;

import com.cognizant.attendanceMarking.auth.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
    User updateUser(User passwordForm);
    User findUser(User resetPassword);
    User forgotUsername(User forgotUserUsername);
}
