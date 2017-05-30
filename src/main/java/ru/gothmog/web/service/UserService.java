package ru.gothmog.web.service;

import ru.gothmog.web.model.User;

/**
 * @author gothmog on 26.05.2017.
 */
public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);
}
