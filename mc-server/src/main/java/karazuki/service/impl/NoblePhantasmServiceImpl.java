package karazuki.service.impl;

import dto.NoblePhantasmDTO;
import entity.NoblePhantasm;
import entity.NoblePhantasmDetail;
import karazuki.mapper.NoblePhantasmDetailMapper;
import karazuki.mapper.NoblePhantasmMapper;
import karazuki.service.NoblePhantasmService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vo.NoblePhantasmVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoblePhantasmServiceImpl implements NoblePhantasmService {

    @Autowired
    private NoblePhantasmMapper noblePhantasmMapper;

    @Autowired
    private NoblePhantasmDetailMapper noblePhantasmDetailMapper;

    /**
     * 根据从者id查询宝具信息
     * @param sid
     * @return
     */
    @Override
    public NoblePhantasmVO findBySid(Integer sid) {
        NoblePhantasmVO noblePhantasmVO = new NoblePhantasmVO();
        //根据从者id查询宝具基本信息
        NoblePhantasm noblePhantasm = noblePhantasmMapper.findBySid(sid);
        BeanUtils.copyProperties(noblePhantasm, noblePhantasmVO);

        //获取宝具id并根据宝具id查询详细信息
        List<NoblePhantasmDetail> noblePhantasmDetails = noblePhantasmDetailMapper.findByNId(noblePhantasm.getId());
        noblePhantasmVO.setNoblePhantasmDetails(noblePhantasmDetails);
        return noblePhantasmVO;
    }

    /**
     * 插入从者宝具信息
     * @param noblePhantasmDTO
     */
    @Override
    @Transactional
    public void insert(NoblePhantasmDTO noblePhantasmDTO) {
        NoblePhantasm noblePhantasm = new NoblePhantasm();
        BeanUtils.copyProperties(noblePhantasmDTO, noblePhantasm);

        //插入宝具信息并获取返回的宝具id
        noblePhantasmMapper.insert(noblePhantasm);
        Integer nid = noblePhantasm.getId();

        //设置详情表的宝具id并逐条插入
        List<NoblePhantasmDetail> noblePhantasmDetailList = noblePhantasmDTO.getNoblePhantasmDetailS();
        if (noblePhantasmDetailList != null && noblePhantasmDetailList.size() > 0){
            noblePhantasmDetailList.forEach(noblePhantasmDetail -> {
                noblePhantasmDetail.setNid(nid);
            });
            noblePhantasmDetailMapper.insertBatch(noblePhantasmDetailList);
        }
    }

    /**
     * 从者宝具信息更新
     * @param noblePhantasmDTO
     */
    @Override
    public void update(NoblePhantasmDTO noblePhantasmDTO) {
        //更新宝具表
        NoblePhantasm noblePhantasm = new NoblePhantasm();
        BeanUtils.copyProperties(noblePhantasmDTO, noblePhantasm);
        noblePhantasmMapper.update(noblePhantasm);

        //更新宝具详情表
        List<NoblePhantasmDetail> noblePhantasmDetailList = noblePhantasmDTO.getNoblePhantasmDetailS();
        if (noblePhantasmDetailList != null && noblePhantasmDetailList.size() > 0){
            for (NoblePhantasmDetail noblePhantasmDetail : noblePhantasmDetailList){
                noblePhantasmDetailMapper.update(noblePhantasmDetail);
            }
        }
    }
}
