package vo;

import entity.SkillDetail;
import lombok.Data;

import java.util.List;

@Data
public class SkillVO {
    //技能id
    private Integer id;

    //技能类型 0技能 1职介技能 2追加技能
    private Integer skillType;

    //技能编号
    private Integer number;

    //充能回合变化
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

    private List<SkillDetail> skillDetails;
}
