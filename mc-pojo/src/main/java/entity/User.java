package entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    //用户id
    private Integer id;
    //用户名
    private String username;
    //用户密码
    private String password;
    //用户昵称
    private String name;
    //用户头像
    private String image;
    //用户注册时间
    private LocalDateTime createTime;
    //用户类型 0用户 1管理员
    private Integer userType;
}
