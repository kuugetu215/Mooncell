package dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
@Schema(description = "用户登录或注册时DTO")
public class LoginOrRegisterDTO {

    @Schema(description = "用户名")
    String username;

    @Schema(description = "密码")
    String password;
}
