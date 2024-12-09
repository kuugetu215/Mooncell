package karazuki.mapper;

import entity.ServantDetail;
import enumeration.OperationType;
import karazuki.annotation.AutoFill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ServantDetailMapper {

    @Select("select * from servant_detail where sid = #{sid}")
    ServantDetail findBySid(Integer sid);

    @AutoFill(OperationType.TIMEUSER)
    void insert(ServantDetail servantDetail);

    @AutoFill(OperationType.TIMEUSER)
    void update(ServantDetail servantDetail);
}
