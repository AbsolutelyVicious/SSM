package cn.cntl.usermanage.service;

import cn.cntl.usermanage.pojo.EasyUIResult;
import cn.cntl.usermanage.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    //分页查询用户信息
    public EasyUIResult queryUsersByPage(Integer pageNum, Integer pageSize);

    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize);

    public void addUser(User user1 , User user2);

    public Boolean saveUser(User user);

}
