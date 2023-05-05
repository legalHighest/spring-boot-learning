package top.hjh.config;

import io.minio.*;
import io.minio.errors.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 10 15 10
 **/
@Configuration
public class MinIoConfig {
    private MinioClient instance;
    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @PostConstruct
    public void init() {
        instance = MinioClient.builder().endpoint(endPoint).credentials(accessKey, secretKey).build();

    }

    /**
     * 判断bucket 是否存在
     *
     * @param bucketName bucket 名称
     * @return boolean
     */
    public boolean bucketExists(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    public void makeBucket(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        boolean flat = bucketExists(bucketName);
        if (!flat) {
            instance.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 文件上传
     *
     * @param buketName  存储名称
     * @param objectName 文件名称，对象名称
     * @param filePath   文件路径
     * @return
     * @throws Exception
     */
    public ObjectWriteResponse uploadObject(String buketName, String objectName, String filePath) throws Exception {
        return instance.uploadObject(UploadObjectArgs.builder().bucket(buketName).object(objectName).filename(filePath).build());

    }

    public ObjectWriteResponse putObject(String buketName, String objectName, InputStream inputStream) throws Exception {
        return instance.putObject(PutObjectArgs.builder().bucket(buketName).object(objectName).stream(inputStream,-1,10485760).build());

    }

    /**
     * 删除文件
     * @param bucketName bucket 名称
     * @param objectName 对象名称
     * @throws Exception
     */
    public  void removeObject(String bucketName,String objectName) throws  Exception{
instance.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }



}
