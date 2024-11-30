package vo;

import lombok.Data;

@Data
public class SpecialAttackSearchVO {
    //从者id
    private Integer sid;

    //从者职介
    private String sclass;

    //从者头像
    private String image;

    //从者姓名
    private String name;

    //特攻类型
    private Integer type;

    //特攻对象
    private String obj;
}
