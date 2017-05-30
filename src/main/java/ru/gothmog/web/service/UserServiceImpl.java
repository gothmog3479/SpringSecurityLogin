package ru.gothmog.web.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gothmog.web.model.Role;
import ru.gothmog.web.model.User;
import ru.gothmog.web.repository.RoleRepository;
import ru.gothmog.web.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author gothmog on 26.05.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl() {
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
