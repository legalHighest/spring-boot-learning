package top.hjh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 14 46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Min(value = 4,message = "文章id最小不能小于4")
    private  Integer id;

    @NotEmpty(message = "文章不能为空")
    private String title;

    @Length(min = 2,max = 10,message = "姓名长度必须在[2,10]之间")
    private String author;

    @Email(message = "无效邮箱")
    private  String email;

    @Future(message = "不是未来时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;




}
