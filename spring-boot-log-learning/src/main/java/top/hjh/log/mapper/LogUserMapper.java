package top.hjh.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.hjh.log.entity.LogUser;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 16 30
 **/

@Repository

public interface LogUserMapper extends BaseMapper<LogUser> {
}
