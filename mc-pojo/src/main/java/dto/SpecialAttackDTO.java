package dto;

import lombok.Data;

@Data
public class SpecialAttackDTO {

    //从者id
    private Integer sid;

    //特攻类型 0状态特攻 1宝具特攻
    private Integer type;

    //特攻对象
    private String obj;
}
