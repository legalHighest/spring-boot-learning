package top.hjh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.hjh.domain.User;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 19 15
 **/

public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE id = #{value}")
    User get(Integer id);

    @Select("SELECT * FROM tb_user ")
    List<User> findAll();

    @Select("SELECT * FROM tb_user WHERE name LIKE concat('%', #{name}, '%')")
    List<User> findAllByNameLike(@Param("name") String name);

    @Update("UPDATE  tb_user Set name =#{name} WHERE id =#{id}")
    void updateById(User user);
}
