package cn.cntl.usermanage.service.impl;

import cn.cntl.usermanage.mapper.UserMapper;
import cn.cntl.usermanage.pojo.EasyUIResult;
import cn.cntl.usermanage.pojo.User;
import cn.cntl.usermanage.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public EasyUIResult queryUsersByPage(Integer pageNum, Integer pageSize) {
        EasyUIResult easyUIResult = new EasyUIResult();
        List<User> userList = this.userMapper.queryUsersByPage((pageNum-1)*pageSize,pageSize);
        easyUIResult.setRows(userList);
        easyUIResult.setTotal(3l);
        return easyUIResult;
    }

    @Override
    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize) {
        // 在查询方法调用之前，调用分页插件的静态方法，中间最好不要隔任何代码
        PageHelper.startPage(pageNum, pageSize);
        // 第一个参数是从那条开始，第二个参数是查询多少条
        // List<User> userList = this.userMapper.queryUsersByPage((pageNum-1)*pageSize, pageSize);
        List<User> userList = this.userMapper.queryUserAll();
        // 初始化pageInfo对象，所有的分页参数都可以在该对象中获取
        PageInfo<User> pageInfo = new PageInfo<>(userList);

        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(pageInfo.getTotal());
        easyUIResult.setRows(pageInfo.getList());

        return easyUIResult;

    }

    @Override
    public void addUser(User user1, User user2) {
        this.userMapper.addUser(user1);
//        int i=1/0;
        this.userMapper.addUser(user2);
    }

    @Override
    public Boolean saveUser(User user) {
        int count = this.userMapper.addUser(user);
        if(count>0){
            return true;
        }
        return false;
    }
}
