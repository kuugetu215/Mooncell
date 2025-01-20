package karazuki.mapper;

import entity.ServantImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServantImageMapper {

    @Select("select * from servant_image where sid = #{sid}")
    List<ServantImage> findBySid(Integer sid);

    void insert(ServantImage servantImage);

    @Select("select * from servant_image where sid = #{sid} and stage = #{stage}")
    ServantImage findBySidAndStage(Integer sid, String stage);

    void update(ServantImage servantImage);

    @Delete("delete from servant_image where id = #{id}")
    void delete(Integer id);
}
