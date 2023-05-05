package top.hjh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 19 14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    @Serial
    private static  final long serialVersionUID=1L;
    private  Integer id;
    private  String name;
    private  String phone;
}
