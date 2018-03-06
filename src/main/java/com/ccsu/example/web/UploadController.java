package com.ccsu.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件上传
 * Created by mutoulazy on 2018/3/2.
 */
@Controller
public class UploadController {
    @RequestMapping("/uploadPage")
    public String uploadPage(){
        return "uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model m){
        try {
            // 根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            //通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName=request.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;
            //创建文件目录
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //把文件名放在model里，以便后续显示用
            m.addAttribute("fileName",fileName);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return "上传失败,文件未找到" + e.getMessage();
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        System.out.println("上传成功");
        return "uploadPage";
    }
}
