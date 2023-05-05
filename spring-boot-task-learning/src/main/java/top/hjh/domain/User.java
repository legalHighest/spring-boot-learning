package top.hjh.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 15 36
 **/
@SuppressWarnings("all")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
   @ExcelProperty(value = "id",index = 0)
   private Integer id;
   @ExcelProperty(value = "用户名",index = 1)
   private String username;
   @ExcelProperty(value = "密码",index = 2)
   private  String password;

}
