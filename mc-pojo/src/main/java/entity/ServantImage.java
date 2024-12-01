package entity;

import lombok.Data;

@Data
public class ServantImage {
    //立绘表id
    private Integer id;

    //所属从者id
    private Integer sid;

    //立绘代表阶段
    private String stage;

    //立绘
    private String image;
}
