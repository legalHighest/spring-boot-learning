package top.hjh.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 14 14 40
 **/
@SpringBootTest
class StudentTest {
@Autowired
    private Student student;


@Test
    void test(){
    System.out.println(student);
}
}