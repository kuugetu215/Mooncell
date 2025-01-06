package karazuki.service;

import dto.EmailSendDTO;
import vo.EmailVO;

import java.util.List;

public interface EmailService {

    /**
     * 发送消息
     * @param emailSendDTO
     */
    void insert(EmailSendDTO emailSendDTO);

    /**
     * 列出消息列表
     * @param targetId
     * @return
     */
    List<EmailVO> list(Integer targetId);

    /**
     * 撤回消息
     * @param id
     * @return
     */
    Boolean recall(Integer id);
}
