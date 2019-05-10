package org.itstep.service;

import org.itstep.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User update(User user);
    User findOne(Integer id);
    List<User> findAll();
    void delete(User user);

}
