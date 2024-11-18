package karazuki.mapper;

import com.github.pagehelper.Page;
import dto.ServantPageQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import vo.ServantPageVO;

@Mapper
public interface ServantMapper {

    Page<ServantPageVO> page(ServantPageQueryDTO servantPageQueryDTO);
}
