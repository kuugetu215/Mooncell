package dto;

import lombok.Data;

@Data
public class EmailSendDTO {
    private Integer receiveId;
    private String content;
}
