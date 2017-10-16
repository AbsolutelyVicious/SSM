package cn.cntl.usermanage.mapper;

import cn.cntl.usermanage.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public User queryUserById(Long id);

    public List<User> queryUsersByPage(@Param("start") Integer start, @Param("size") Integer size);

    public List<User> queryUserAll();

    public int addUser(User user);

}
