package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialAttack {
    //特攻表id
    private Integer id;

    //从者id
    private Integer sid;

    //特攻范围 0职介特攻 1副属性特攻 2属性特攻 3通常特性特攻 4状态特攻 5自buff特攻 6被EA特攻 7对性别特攻
    private Integer range;

    //特攻类型 0状态特攻 1宝具特攻
    private Integer type;

    //特攻对象
    private String obj;
}
