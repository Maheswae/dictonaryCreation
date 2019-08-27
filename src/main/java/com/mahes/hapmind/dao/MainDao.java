package com.mahes.hapmind.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MainDao {

	Set<String> persistSet = null;
	
	public void persistData(String data){
		persistSet = new HashSet<>();
		data = data.replace(".", " ");
		data = data.replace("\n", " ");
		String[] splitBySpace = data.split(" ");
		for(int i = 0; i< splitBySpace.length;i++) {
				persistSet.add(splitBySpace[i]);
		}
		if(persistSet.contains(""))
			persistSet.remove("");
		
	}
	
	public boolean checkString(String str) {
		if(persistSet == null) {
			return false;
		}
		return persistSet.contains(str);
	}
	
	
	
}
