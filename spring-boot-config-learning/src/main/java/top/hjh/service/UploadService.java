package top.hjh.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.hjh.config.OssConfig;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 16 17 40
 **/

@Service
public class UploadService {
    @Autowired
  public OssConfig ossConfig ;



    public String ossUpload(MultipartFile file) {
        String endpoint = ossConfig.getEndpoint();
        String accessKeyId = ossConfig.getAk();
        String accessKeySecret = ossConfig.getSecret();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();
        System.out.println(endpoint+accessKeyId+accessKeySecret+bucket+dir+host);

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String uploadPath = dir + file.getOriginalFilename();

        InputStream inputStream = null;


        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ossClient.putObject(bucket, uploadPath, inputStream);
        ossClient.shutdown();
        return host + uploadPath;

    }
}
