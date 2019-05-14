package org.itstep.service;

import org.itstep.dao.UserDAO;
import org.itstep.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User save(User user) {
        if (userDAO.findOne(user.getId()) == null){
            user.setId(userDAO.save(user));
            return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        if (userDAO.findOne(user.getId()) != null){
            return userDAO.update(user);
        }
        return null;
    }

    @Override
    public User findOne(Integer id) {
        return userDAO.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        User user = findOne(id);
        if (user != null) {
            userDAO.delete(findOne(id));
        }
    }
}
