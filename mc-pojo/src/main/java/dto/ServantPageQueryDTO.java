package dto;

import lombok.Data;

import java.util.List;

@Data
public class ServantPageQueryDTO {

    //页码数
    private Integer page;

    //页面大小
    private Integer pageSize;

    //职介
    private List<String> sclasses;

    //星级
    private List<Integer> ranks;

    //色卡
    private List<String> cards;

    //宝具色卡
    private List<Integer> npcards;

    //宝具类型
    private List<String> types;

    //获取途径
    private List<String> wayToGets;

    //搜索栏
    private String search;

    //排序方式 0编号升序 1编号降序 2atk升序 3atk降序 4hp升序 5hp降序
    private Integer sort;
}
