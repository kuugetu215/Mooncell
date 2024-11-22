package karazuki.service.impl;

import entity.ServantData;
import karazuki.mapper.ServantDataMapper;
import karazuki.service.ServantDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
