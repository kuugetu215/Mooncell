package karazuki.mapper;

import com.github.pagehelper.Page;
import dto.ServantDTO;
import dto.ServantPageQueryDTO;
import entity.Servant;
import karazuki.annotation.FillTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import vo.ServantPageVO;

@Mapper
public interface ServantMapper {

    Page<ServantPageVO> page(ServantPageQueryDTO servantPageQueryDTO);

    @Select("select * from servant where id = #{id}")
    Servant findById(Integer id);

    @FillTime
    void insert(Servant servant);

    @FillTime
    void update(Servant servant);
}
