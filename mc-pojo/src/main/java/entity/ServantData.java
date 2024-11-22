package entity;

import lombok.Data;

@Data
public class ServantData {
    //从者信息表id
    private Integer id;

    //从者id
    private Integer sid;

    //从者信息key
    private String dataKey;

    //开放条件
    private String condition;

    //资料文本-中文
    private String dataText;

    //资料文本-日文
    private String dataTextJ;

    //开放副本id
    private Integer openId;
}
