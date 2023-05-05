package top.hjh.controller;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 10 13 58
 **/
@RestController
public class FileUploadController {

    @Value("${web.upload-path}")
    private  String uploadPath;


     DateFormat df=new SimpleDateFormat("yyyyMMdd");


    @PostMapping("/upload")
    public  String upload(MultipartFile uploadFile,HttpServletRequest request) throws IOException {
    //创建子目录,实现在uploadPath 目录中果果容器对上传的文件归类保存
    String format=df.format(new Date());

        File folader=new File(uploadPath+format);
//判断folader是否是一个目录
        if (!folader.isDirectory()){
            folader.mkdirs();
        }

        //对上传文件重命名，避免冲突
        String oldName=uploadFile.getOriginalFilename();//原始文件名
        String newName = null;
        if (oldName!=null){
            newName=UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
        }
       //上传：文件复制
        uploadFile.transferTo(new File(folader,newName));

        //拼接返回上传后的访问路径
//http://localhost:8080/20230410/44442342432423.jpg
       //获取协议+默认+域名+端口号
        String fileName=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+format+"/"+newName;
        return fileName;


    }


}
