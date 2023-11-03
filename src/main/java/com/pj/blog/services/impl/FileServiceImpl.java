package com.pj.blog.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pj.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {


		String name = file.getOriginalFilename();
		String randomId=UUID.randomUUID().toString();
		String fileName1= randomId.concat(name).substring(name.lastIndexOf("."));
		
		String filePath = path+File.separator + fileName1;
		
		
//		creat efolder if not existed
		File f= new File(path);
		
		if(!f.exists())
		{
			f.mkdir();
		}
		
//		copy file
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}

	@Override
	public InputStream getResource(String path, String filename) throws FileNotFoundException {
		
		return null;
	}

}
