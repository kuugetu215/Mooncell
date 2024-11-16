package vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户登录")
public class LoginVO {

    @Schema(description = "用户id")
    private Integer id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "jwt")
    private String token;
}
