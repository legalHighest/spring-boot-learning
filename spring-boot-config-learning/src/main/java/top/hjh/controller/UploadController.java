package top.hjh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.hjh.service.UploadService;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 16 18 01
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadController {

    private  final UploadService uploadService;

    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){
        return uploadService.ossUpload(file);
    }
}
