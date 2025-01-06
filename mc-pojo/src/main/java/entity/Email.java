package entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Email {
    private Integer id;
    private Integer uid;
    private Integer receiveId;
    private String content;
    private Integer status;
    private Integer isRead;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
