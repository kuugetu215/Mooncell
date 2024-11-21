package karazuki.service.impl;

import entity.NoblePhantasm;
import entity.NoblePhantasmDetail;
import karazuki.mapper.NoblePhantasmDetailMapper;
import karazuki.mapper.NoblePhantasmMapper;
import karazuki.service.NoblePhantasmService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.NoblePhantasmVO;

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
        NoblePhantasm noblePhantasm = noblePhantasmMapper.findBySid(sid);
        BeanUtils.copyProperties(noblePhantasm, noblePhantasmVO);

        List<NoblePhantasmDetail> noblePhantasmDetails = noblePhantasmDetailMapper.findByNId(noblePhantasm.getId());
        noblePhantasmVO.setNoblePhantasmDetails(noblePhantasmDetails);
        return noblePhantasmVO;
    }
}
