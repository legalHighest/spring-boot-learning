package top.hjh.util;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 18 29
 **/
@SpringBootTest
class ExcelUtilTest {
@Resource
private ExcelUtil excelUtil;
    @Test
    void createExcel() throws IOException {
        excelUtil.createExcel();
    }
}