package demo.dao;

import demo.pojo.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User>, InsertListMapper<User> {
}