package karazuki.service;

import dto.LoginOrRegisterDTO;
import dto.UserDTO;
import entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param loginOrRegisterDto
     * @return
     */
    User login(LoginOrRegisterDTO loginOrRegisterDto);

    /**
     * 普通用户注册
     * @param loginOrRegisterDTO
     */
    void register(LoginOrRegisterDTO loginOrRegisterDTO);

    /**
     * 更改用户信息
     * @param userDTO
     */
    void update(UserDTO userDTO);

    /**
     * 根据id查找用户信息
     * @param id
     */
    User findById(Integer id);
}
