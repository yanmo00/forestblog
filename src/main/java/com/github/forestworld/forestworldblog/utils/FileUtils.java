package com.github.forestworld.forestworldblog.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    public static final FileUtil fileUtil = new FileUtil();

    public static File switchFormat(MultipartFile file) throws IOException {
        File newFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(file.getBytes());
        return newFile;
    }

    public static String getOriginalFilename(File newfile) {
        return FileUtil.getName(newfile).replace(".md", "");
    }

    public static String getContent(File newfile) {
        return  FileUtil.readUtf8String(newfile);
    }
}
