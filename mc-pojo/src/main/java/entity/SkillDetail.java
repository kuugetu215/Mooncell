package entity;

import lombok.Data;

@Data
public class SkillDetail {
    private Integer id;
    private Integer skillId;
    private String description;
    private String value;
    private Integer rankupNum;
}
