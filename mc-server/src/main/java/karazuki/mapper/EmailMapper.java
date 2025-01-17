package karazuki.mapper;

import entity.Email;
import enumeration.OperationType;
import karazuki.annotation.AutoFill;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmailMapper {

    @AutoFill(OperationType.INSERT)
    @Insert("insert into email (uid, receive_id, content, status, is_read, create_time, update_time) VALUES (#{uid}, #{receiveId}, #{content}, #{status}, #{isRead}, #{createTime}, #{updateTime})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void insert(Email email);

    @Select("select * from email where (uid = #{uid} and receive_id = #{targetId}) or (receive_id = #{uid} and uid = #{targetId}) order by create_time")
    List<Email> list(Integer uid, Integer targetId);

    @Select("select * from email where id = #{id}")
    Email getById(Integer id);

    @AutoFill(OperationType.UPDATE)
    @Update("update email set status = 0 where id = #{id}")
    void update(Integer id);

    @Delete("delete from email where status = 0")
    void delete();
}
