package karazuki.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import dto.ServantDTO;
import dto.ServantPageQueryDTO;
import entity.Servant;
import entity.ServantDetail;
import entity.ServantImage;
import karazuki.mapper.ServantClassMapper;
import karazuki.mapper.ServantDetailMapper;
import karazuki.mapper.ServantMapper;
import karazuki.service.ServantService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import result.PageResult;
import vo.ServantPageVO;
import vo.ServantVO;

import java.util.List;

@Slf4j
@Service
public class ServantServiceImpl implements ServantService {

    @Autowired
    private ServantMapper servantMapper;

    @Autowired
    private ServantDetailMapper servantDetailMapper;

    @Autowired
    private ServantClassMapper servantClassMapper;

    /**
     * 从者列表分页查询
     * @param servantPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(ServantPageQueryDTO servantPageQueryDTO) {
        PageHelper.startPage(servantPageQueryDTO.getPage(), servantPageQueryDTO.getPageSize());
        Page<ServantPageVO> page = servantMapper.page(servantPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据id查询从者信息
     * @param id
     * @return
     */
    @Override
    public ServantVO findById(Integer id) {
        //根据id查找从者基本信息
        Servant servant = servantMapper.findById(id);

        //TODO 根据从者id查询立绘信息

        //根据id查询从者详细信息并根据补正计算并封装数值
        ServantDetail servantDetail = servantDetailMapper.findBySid(id);

        ServantVO servantVO = new ServantVO();

        BeanUtils.copyProperties(servant, servantVO);
        BeanUtils.copyProperties(servantDetail, servantVO);

        servantVO.setId(id);

        //查询职介补正信息并填充到VO当中
        Float cor = servantClassMapper.findCftByEname(servant.getSclass());
        servantVO.setAtk1Cor((int)(servantDetail.getAtk1() * cor));
        servantVO.setAtkFullCor((int)(servantDetail.getAtkFull() * cor));
        servantVO.setAtk90Cor((int)(servantDetail.getAtk90() * cor));
        servantVO.setAtk100Cor((int)(servantDetail.getAtk100() * cor));
        servantVO.setAtk120Cor((int)(servantDetail.getAtk120() * cor));

        return servantVO;
    }

    /**
     * 插入从者信息
     * @param servantDTO
     */
    @Override
    @Transactional
    public void insert(ServantDTO servantDTO) {
        //将DTO数据封装进Servant和ServantDetail中
        Servant servant = new Servant();
        ServantDetail servantDetail = new ServantDetail();
        BeanUtils.copyProperties(servantDTO, servant);
        BeanUtils.copyProperties(servantDTO, servantDetail);

        //设置ServantDetail中剩余数据
        servantDetail.setId(null);
        servantDetail.setSid(servantDTO.getId());

        //插入数据
        servantMapper.insert(servant);

        servantDetailMapper.insert(servantDetail);
    }

    /**
     * 更新从者信息
     * @param servantDTO
     */
    @Override
    @Transactional
    public void update(ServantDTO servantDTO) {
        //将DTO数据封装进Servant和ServantDetail中
        Servant servant = new Servant();
        ServantDetail servantDetail = new ServantDetail();
        BeanUtils.copyProperties(servantDTO, servant);
        BeanUtils.copyProperties(servantDTO, servantDetail);

        //设置ServantDetail中剩余数据
        servantDetail.setId(null);
        servantDetail.setSid(servantDTO.getId());

        //更新数据
        servantMapper.update(servant);
        servantDetailMapper.update(servantDetail);
    }

    /**
     * 删除所有从者相关信息
     * @param id
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        //删除从者表数据

        Integer sid = id;
        //删除从者详情表数据

        //TODO 删除其他关联表数据
    }
}
