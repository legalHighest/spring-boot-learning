package top.hjh.log.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.hjh.log.entity.LogUser;
import top.hjh.log.mapper.LogUserMapper;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 16 50
 **/
@Service
public class LogUserServiceImpl extends ServiceImpl<LogUserMapper,LogUser> implements ILogUserService {


}
