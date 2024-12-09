package karazuki.service.impl;

import dto.ServantDataDTO;
import entity.ServantData;
import karazuki.mapper.ServantDataMapper;
import karazuki.service.ServantDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServantDataServiceImpl implements ServantDataService {

    @Autowired
    private ServantDataMapper servantDataMapper;

    /**
     * 根据从者id查询从者资料
     * @param sid
     * @return
     */
    @Override
    public List<ServantData> findBySid(Integer sid) {
        //根据sid查询从者资料表
        List<ServantData> servantDataList = servantDataMapper.findBySid(sid);
        return servantDataList;
    }

    /**
     * 批量插入从者资料
     * @param servantDataDTOList
     */
    @Override
    @Transactional
    public void insertBatch(List<ServantDataDTO> servantDataDTOList) {
        for(ServantDataDTO servantDataDTO : servantDataDTOList){
            //查询该条资料是否已存在
            ServantData sd = servantDataMapper.findBySidAndCondition(servantDataDTO.getSid(), servantDataDTO.getCondition());

            //是，则抛出异常，不可插入
            if (sd != null){
                throw new RuntimeException("该条资料已存在:" + servantDataDTO.getDataKey());
            }

            //否，进行插入操作
            ServantData servantData = new ServantData();
            BeanUtils.copyProperties(servantDataDTO, servantData);
            servantDataMapper.insert(servantData);
        }
    }

    /**
     * 更新从者资料
     * @param servantDataDTO
     */
    @Override
    public void update(ServantDataDTO servantDataDTO) {
        ServantData servantData = new ServantData();
        BeanUtils.copyProperties(servantDataDTO, servantData);
        servantDataMapper.update(servantData);
    }
}
