package com.mahes.hapmind.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mahes.hapmind.dao.MainDao;

@RestController
public class MainController {
	
	@Autowired
	MainDao mainDao;
	
	@PostMapping
	public void getFile(@RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			String list = new String(file.getBytes());
			mainDao.persistData(list);
		}
	}
	
	@GetMapping
	public boolean checkWord(@RequestParam("str") String str) {
		return mainDao.checkString(str);
	}
	
}
