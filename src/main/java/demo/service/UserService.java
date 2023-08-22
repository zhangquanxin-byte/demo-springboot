package demo.service;

import demo.pojo.User;

public interface UserService {
    int save(User user);

    String addUser(User user);
}
