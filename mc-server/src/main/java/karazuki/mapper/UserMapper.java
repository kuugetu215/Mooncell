package karazuki.mapper;

import entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    void insert(User user);

    void update(User user);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);
}