package karazuki.mapper;

import com.github.pagehelper.Page;
import dto.ServantDTO;
import dto.ServantPageQueryDTO;
import entity.Servant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import vo.ServantPageVO;

@Mapper
public interface ServantMapper {

    Page<ServantPageVO> page(ServantPageQueryDTO servantPageQueryDTO);

    @Select("select * from servant where id = #{id}")
    Servant findById(Integer id);

    void insert(Servant servant);

    void update(Servant servant);
}
