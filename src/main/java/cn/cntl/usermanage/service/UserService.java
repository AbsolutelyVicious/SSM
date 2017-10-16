package cn.cntl.usermanage.service;

import cn.cntl.usermanage.pojo.EasyUIResult;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    //分页查询用户信息
    public EasyUIResult queryUsersByPage(Integer pageNum, Integer pageSize);

    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize);

}
