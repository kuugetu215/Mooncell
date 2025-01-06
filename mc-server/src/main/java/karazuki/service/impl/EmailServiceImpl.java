package karazuki.service.impl;

import context.BaseContext;
import dto.EmailSendDTO;
import entity.Email;
import entity.User;
import karazuki.mapper.EmailMapper;
import karazuki.mapper.UserMapper;
import karazuki.service.EmailService;
import karazuki.websocket.WebSocketServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.EmailVO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void insert(EmailSendDTO emailSendDTO) {
        //获取发信用户id
        Integer uid = BaseContext.getCurrentId();

        //将信息插入到数据库中
        Email email = Email.builder()
                .uid(uid)
                .receiveId(emailSendDTO.getReceiveId())
                .content(emailSendDTO.getContent())
                .status(1)
                .isRead(0)
                .build();
        emailMapper.insert(email);

        //调用websocket发送数据
        webSocketServer.sendToUser(email.getContent(), uid, email.getReceiveId());
    }

    @Override
    public List<EmailVO> list(Integer targetId) {
        //获取送信用户uid
        Integer uid = BaseContext.getCurrentId();

        //根据送信人uid和收信人uid获取消息列表
        List<Email> emailList = emailMapper.list(uid, targetId);
        List<EmailVO> emailVOList = new ArrayList<>();
        EmailVO emailVO = new EmailVO();

        //封装每条消息的用户昵称和头像
        for(Email email : emailList){
            BeanUtils.copyProperties(email, emailVO);
            User user = userMapper.findById(email.getUid());
            emailVO.setUsername(user.getName());
            emailVO.setUserImage(user.getImage());
            emailVOList.add(emailVO);
        }

        return emailVOList;
    }

    @Override
    public Boolean recall(Integer id) {
        Email email = emailMapper.getById(id);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime overtime = email.getCreateTime().plusMinutes(2);
        if (now.isAfter(overtime)){
            return false;
        } else {
            emailMapper.update(id);
            return true;
        }
    }
}
