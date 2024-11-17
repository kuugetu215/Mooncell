package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户DTO")
public class UserDTO {

    @Schema(description = "用户id")
    private Integer id;

    @Schema(description = "用户密码")
    private String password;

    @Schema(description = "用户昵称")
    private String name;

    @Schema(description = "用户头像")
    private String image;
}
