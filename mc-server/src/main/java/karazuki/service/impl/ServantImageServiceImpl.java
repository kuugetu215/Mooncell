package karazuki.service.impl;

import dto.ServantDTO;
import dto.ServantImageDTO;
import entity.ServantImage;
import karazuki.mapper.ServantImageMapper;
import karazuki.service.ServantImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServantImageServiceImpl implements ServantImageService {

    @Autowired
    private ServantImageMapper servantImageMapper;

    @Override
    @Transactional
    public void insert(List<ServantImageDTO> servantImageDTOS) {

        ServantImage servantImage = new ServantImage();

        //分条插入立绘信息
        for (ServantImageDTO servantImageDTO : servantImageDTOS){
            if (servantImageMapper.findBySidAndStage(servantImageDTO.getSid(), servantImageDTO.getStage()) == null){
                BeanUtils.copyProperties(servantImageDTO, servantImage);
                servantImageMapper.insert(servantImage);
            } else {
                throw new RuntimeException("该阶段立绘已存在");
            }

        }
    }

    @Override
    public void update(ServantImageDTO servantImageDTO) {
        ServantImage servantImage = new ServantImage();
        BeanUtils.copyProperties(servantImageDTO, servantImage);
        servantImageMapper.update(servantImage);
    }

    @Override
    public void delete(Integer id) {
        servantImageMapper.delete(id);
    }
}
