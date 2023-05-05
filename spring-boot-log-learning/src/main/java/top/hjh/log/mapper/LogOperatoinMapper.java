package top.hjh.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.hjh.log.entity.LogOperation;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 16 21
 **/
@Repository
@Mapper
public interface LogOperatoinMapper extends BaseMapper<LogOperation> {
}
