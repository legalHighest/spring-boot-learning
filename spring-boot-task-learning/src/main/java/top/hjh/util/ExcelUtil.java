package top.hjh.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import jakarta.annotation.Resource;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.hjh.domain.User;
import top.hjh.mapper.UserMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.apache.poi.poifs.crypt.HashAlgorithm.none;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 15 52
 **/

@Configuration
public class ExcelUtil {
    @Resource
    private  UserMapper userMapper;

    public void createExcel() {
        List<User> users = userMapper.selectList(null);
        ArrayList list= (ArrayList) users;
        System.out.println(users);
        Consumer<ExcelWriter> consumer =writer ->
                writer.write(list,EasyExcel.writerSheet("报表").head(User.class).build());
        //调用方法去导出数据
     export("D:/报表.xlsx", consumer);

    }
    public static void export(String fileName, Consumer<ExcelWriter> writerConsumer) {
        ExcelWriter writer = EasyExcel.write(fileName)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .build();
        writerConsumer.accept(writer);
        writer.finish();
    }




}
