package top.hjh.log.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 16 22
 **/
@Data
@Accessors(chain = true)
@TableName("tb_user")
public class LogUser implements Serializable {
    private static  final long serialVersionUID=1L;
    private  String id;
    private  String username;
    private  String password;

    @TableLogic
    private  Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private  LocalDateTime updateTime;
}
