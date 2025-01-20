package dto;

import lombok.Data;

@Data
public class ServantImageDTO {
    //立绘表id
    private Integer id;

    //所属从者id
    private Integer sid;

    //立绘代表阶段
    private String stage;

    //中文名
    private String cname;

    //日文名
    private String jname;

    //英文名
    private String ename;


    //立绘
    private String image;
}
