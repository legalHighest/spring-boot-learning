package top.hjh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.util.pattern.PathPattern;

import java.util.Date;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 18 14 22
 **/
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article {
    private Integer id;
    private  String title;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
