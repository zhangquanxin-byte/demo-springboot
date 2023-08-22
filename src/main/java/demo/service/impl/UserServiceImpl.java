package demo.service.impl;

import demo.dao.UserMapper;
import demo.pojo.User;
import demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public String addUser(User user) {
        return "1";
    }

}
