package top.hjh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 17 14 15
 **/
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Certificate {
private  String name;
@DateTimeFormat(pattern = "YYYY-MM-dd")
private Date date;

private  String price;

}
