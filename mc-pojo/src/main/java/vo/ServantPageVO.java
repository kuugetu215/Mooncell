package vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "从者分页查询信息")
public class ServantPageVO {

    @Schema(description = "从者id")
    private Integer id;

    @Schema(description = "从者头像")
    private String image;

    @Schema(description = "从者中文名")
    private String cname;

    @Schema(description = "从者日文名")
    private String jname;

    @Schema(description = "从者英文名")
    private String ename;

    @Schema(description = "从者宝具色卡")
    private String npcard;

    @Schema(description = "从者宝具类型")
    private String type;

    @Schema(description = "从者职介")
    private String sclass;

    @Schema(description = "从者色卡")
    private String card;

    @Schema(description = "从者副属性")
    private Character sideProperty;

    @Schema(description = "从者获取方式")
    private String wayToGet;

    @Schema(description = "从者90级atk")
    private Integer atk90;

    @Schema(description = "从者90级hp")
    private Integer hp90;
}
