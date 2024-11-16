package karazuki.controller;

import dto.LoginOrRegisterDTO;
import entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import karazuki.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import utils.JwtUtils;
import vo.LoginVO;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@Tag(name = "user", description = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param loginOrRegisterDto
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<LoginVO> login(@RequestBody LoginOrRegisterDTO loginOrRegisterDto){
        log.info("用户登录");

        //根据用户名、密码查询并返回用户信息
        User user = userService.login(loginOrRegisterDto);

        Map<String, String> map = new HashMap<>();
        map.put("id", "" + user.getId());
        map.put("username", user.getUsername());
        map.put("userType", "" + user.getUserType());

        String token = JwtUtils.getToken(map);

        LoginVO loginVO = LoginVO.builder().
                id(user.getId()).
                username(user.getUsername()).
                token(token).
                build();

        return Result.success(loginVO);
    }

    /**
     * 用户注册
     * @param loginOrRegisterDTO
     */
    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result<Object> register(@RequestBody LoginOrRegisterDTO loginOrRegisterDTO){
        log.info("用户注册");
        userService.register(loginOrRegisterDTO);
        return Result.success();
    }
}
