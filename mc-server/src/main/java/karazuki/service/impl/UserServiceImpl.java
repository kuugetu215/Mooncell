package karazuki.service.impl;

import context.BaseContext;
import dto.LoginOrRegisterDTO;
import dto.UserDTO;
import entity.User;
import karazuki.mapper.UserMapper;
import karazuki.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param loginOrRegisterDto
     * @return
     */
    @Override
    public User login(LoginOrRegisterDTO loginOrRegisterDto) {
        String username = loginOrRegisterDto.getUsername();
        String password = loginOrRegisterDto.getPassword();

        //1、根据用户名查询数据库中的数据
        User user = userMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对）
        if (user == null) {
            //账号不存在
            throw new RuntimeException("用户名不存在");
        }

        //密码比对
        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new RuntimeException("密码错误");
        }

        //3、返回实体对象
        return user;
    }

    /**
     * 普通用户注册
     * @param loginOrRegisterDTO
     */
    @Override
    public void register(LoginOrRegisterDTO loginOrRegisterDTO) {
        String username = loginOrRegisterDTO.getUsername();
        String password = loginOrRegisterDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        User u = userMapper.getByUsername(username);

        //2、处理异常情况（用户名已存在）
        if(u != null){
            throw new RuntimeException("用户名已存在");
        }

        User user = new User();

        //3、封装实体类并插入到用户表中
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        user.setUserType(0);

        userMapper.insert(user);
    }

    /**
     * 更改用户信息
     * @param userDTO
     */
    @Override
    public void update(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        userMapper.update(user);
    }

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    /**
     * 给予当前用户管理员权限
     * @param id
     */
    @Override
    public void changeAdmin(Integer id) {
        //查询操作用户id是否为最大管理员
        Integer AdminId = BaseContext.getCurrentId();

        //如果不是，抛出异常；是，则继续进行
        if (AdminId != 1){
            throw new RuntimeException("该用户没有该操作权限");
        }

        //查看当前用户权限类型
        User user = userMapper.findById(id);
        if (user == null){
            throw new RuntimeException("不存在该用户");
        } else if (user.getId() == 1){
            throw new RuntimeException("不能修改该用户为普通用户");
        }
        Integer userType = user.getUserType();
        if (userType == 0){
            //用户为普通用户，修改用户为管理员
            user.setUserType(1);
            userMapper.update(user);
        } else {
            //用户为管理员，修改用户为普通用户
            user.setUserType(0);
            userMapper.update(user);
        }
    }
}
