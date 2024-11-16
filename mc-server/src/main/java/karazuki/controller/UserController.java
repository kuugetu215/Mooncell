package karazuki.controller;

import dto.LoginOrRegisterDTO;
import dto.UserDTO;
import entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import karazuki.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Result register(@RequestBody LoginOrRegisterDTO loginOrRegisterDTO){
        log.info("用户注册");
        userService.register(loginOrRegisterDTO);
        return Result.success();
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Operation(summary = "根据id查询用户信息")
    @GetMapping("/user/{id}")
    public Result<User> findById(@PathVariable Integer id){
        log.info("根据id查询用户信息");
        User user = userService.findById(id);
        return Result.success(user);
    }

    /**
     * 更改用户信息
     * @param userDTO
     * @return
     */
    @Operation(summary = "更改用户信息")
    @PutMapping("/user/upadte")
    public Result update(@RequestBody UserDTO userDTO){
        log.info("更改用户信息");
        userService.update(userDTO);
        return Result.success();
    }
}
