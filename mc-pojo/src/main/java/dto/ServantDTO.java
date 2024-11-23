package dto;

import entity.ServantImage;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ServantDTO {

    //从者id
    private Integer id;
    //从者头像
    private String image;
    //从者中文名
    private String cname;
    //从者日文名
    private String jname;
    //从者英文名
    private String ename;
    //从者职介
    private String sclass;
    //从者星级
    private Integer rank;
    //画师
    private String illustrator;
    //cv
    private String cv;
    //性别
    private Integer sex;
    //身高
    private Integer height;
    //体重
    private Integer weight;
    //属性
    private String property;
    //副属性
    private Character sideProperty;
    //获得方式
    private String wayToGet;

    //六维面板
    private String sixDemention;

    //能力
    //atk
    private Integer atk1;
    private Integer atkFull;
    private Integer atk90;
    private Integer atk100;
    private Integer atk120;

    //hp
    private Integer hp1;
    private Integer hpFull;
    private Integer hp90;
    private Integer hp100;
    private Integer hp120;

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
