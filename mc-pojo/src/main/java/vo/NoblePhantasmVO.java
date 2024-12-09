package vo;

import entity.NoblePhantasmDetail;
import lombok.Data;

import java.util.List;

@Data
public class NoblePhantasmVO {
    //宝具id
    private Integer id;

    //强化次数
    private Integer rankupNum;

    //强化本id
    private Integer rankupId;

    //TODO 强化本id更改成为强化本/幕间物语信息
    //private RankupInstance

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

    //宝具等级
    private String rank;

    //宝具类型(对城、对人……)
    private String type;

    //宝具详细信息
    private List<NoblePhantasmDetail> noblePhantasmDetails;
}
