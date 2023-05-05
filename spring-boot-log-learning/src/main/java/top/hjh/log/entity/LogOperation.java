package top.hjh.log.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 16 26
 **/
@Data
@Accessors(chain = true)
@TableName("tb_log")
public class LogOperation implements Serializable {
    private  static final long serialVersionUID=7925874058046995566L;

    private  String id;
    private  String userId;
    private  String username;
    private  String loginIp;

    private  int type;

    private  String url;

    private  String operation;

    @TableField
    private LocalDateTime createTime;

    private  String remark;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private  LocalDateTime updateTime;
}
