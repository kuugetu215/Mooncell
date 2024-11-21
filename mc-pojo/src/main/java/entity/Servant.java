package entity;

import lombok.Data;

@Data
public class Servant {

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

    //性别 0男性 1女性 2不明
    private Integer sex;

    //身高
    private Integer height;

    //体重
    private Integer weight;

    //属性 如：守序·善
    private String property;

    //副属性 如：天、地、人
    private Character sideProperty;

    //获取方式
    private String wayToGet;
}
