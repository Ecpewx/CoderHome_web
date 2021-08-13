package com.zpc.coderhome.service.impl;

import com.zpc.coderhome.dao.FileMapper;
import com.zpc.coderhome.model.File;
import com.zpc.coderhome.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public void upload(String name, String path) {
        File file = new File();
        file.setName(name);
        file.setPath(path);
        fileMapper.insertSelective(file);
    }

    @Override
    public void update() {

    }
}
