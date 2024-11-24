package dto;

import entity.SkillDetail;
import lombok.Data;

import java.util.List;

@Data
public class SkillDTO {

    //技能id
    private Integer id;

    //从者id
    private Integer sid;

    //技能类型 0技能 1职阶技能 2追加技能
    private Integer skillType;

    //技能编号
    private Integer number;

    //技能充能回合数变化
    private String chargeRank;

    //技能中文名
    private String cname;

    //技能日文名
    private String jname;

    //强化次数
    private Integer rankupNum;

    //技能开放条件
    private String condition;

    //强化本id
    private Integer rankId;

    //技能详细信息
    private List<SkillDetail> skillDetailList;
}
