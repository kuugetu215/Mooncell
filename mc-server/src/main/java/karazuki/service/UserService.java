package karazuki.service;

import dto.LoginOrRegisterDTO;
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
}
