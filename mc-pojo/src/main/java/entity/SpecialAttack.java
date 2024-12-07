package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecialAttack {
    //特攻表id
    private Integer id;

    //从者id
    private Integer sid;

    //特攻类型 0状态特攻 1宝具特攻
    private Integer type;

    //特攻对象
    private String obj;
}
