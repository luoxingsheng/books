package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileService {

//    文件上传
    public String fileupload(byte[] file,String path,String fileName)throws FileNotFoundException,IOException{
        File test=null;

        if(file!=null){
//           String fileName=file.getOriginalFilename();
            test=new File(path);
            if(!test.exists()){
                System.out.println("文件"+path);
                test.mkdir();
            }

            FileOutputStream out=new FileOutputStream(path);
            System.out.println(out);
            out.write(file);
            System.out.println("写入成功");
            out.flush();
            out.close();
            return test.getName();
        }
        else
            return "上传失败，文件为空！";
    }

    public boolean deleteFile(String path){
        String p="src/resource/static/"+path;
        File file=new File(p);
        if(file.exists()){
            return file.delete();
        }else
            return false;
    }




}
