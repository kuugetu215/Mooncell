package dto;

import entity.NoblePhantasmDetail;
import lombok.Data;

import java.util.List;

@Data
public class NoblePhantasmDTO {
    //宝具id
    private Integer id;

    //所属从者id
    private Integer sid;

    //宝具色卡
    private Integer card;

    //中文名
    private String cname;
    //平假名
    private String hname;
    //片假名
    private String kname;
    //英文名
    private String ename;

    //宝具类型(单体、全体、辅助)
    private String kind;

    //宝具等级
    private String rank;

    //宝具类型(对城、对人……)
    private String type;

    //强化次数
    private Integer rankupNum;

    //强化本id
    private Integer rankupId;

    //宝具详细信息
    private List<NoblePhantasmDetail> noblePhantasmDetailS;

}
