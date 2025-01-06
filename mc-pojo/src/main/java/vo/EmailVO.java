package vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmailVO {
    private Integer id;
    private Integer uid;
    private String username;
    private String userImage;
    private String content;
    private Integer status;
    private Integer isRead;
    private LocalDateTime createTime;
}
