package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServantDetail {
    //从者详情表id
    private Integer id;

    //所属从者id
    private Integer sid;

    //能力
    //atk
    private Integer atk1;
    private Integer atk90;
    private Integer atk100;
    private Integer atk120;

    //hp
    private Integer hp1;
    private Integer hp90;
    private Integer hp100;
    private Integer hp120;

    //六维面板
    private String sixDemention;

    //指令卡
    private String card;

    //hit信息
    private String qHit;
    private String aHit;
    private String bHit;
    private String exHit;
    private String npHit;

    //np率
    private String npRate;
    //受击np
    private String hitNp;

    //出星率
    private String starRate;

    //被即死率
    private String deathRate;

    //暴击星分配权重
    private String starAssign;

    //特性
    private String chara;

    //人形
    private Integer isHumanForm;
    //被ea特攻
    private Integer isEaEffective;
    //猪化有效
    private Integer isPigchangeEffective;

    //实装时间
    private LocalDate createTime;
}
