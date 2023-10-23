package com.shop.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dao.TodoRepository;
import com.shop.model.ToDo;

import lombok.AllArgsConstructor;

import static org.apache.http.entity.ContentType.*;
import java.util.*;    

@Service
@AllArgsConstructor
public class TodoServiceImpl implements ToDoService {

    private final FileStore fileStore;
    private final TodoRepository repository;


	@Override
	public ToDo saveTodo(String title, String description, MultipartFile file) {
		
		
		
		   if (file.isEmpty()) {
	            throw new IllegalStateException("Cannot upload empty file");
	        }
	        //Check if the file is an image
//	        if (!Arrays.asList(I.getMimeType(),
//	                IMAGE_BMP.getMimeType(),
//	                IMAGE_GIF.getMimeType(),
//	                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
//	            throw new IllegalStateException("FIle uploaded is not an image");
//	        }
	        //get file metadata
	        Map<String, String> metadata = new HashMap<>();
	        metadata.put("Content-Type", file.getContentType());
	        metadata.put("Content-Length", String.valueOf(file.getSize()));
	        //Save Image in S3 and then save Todo in the database
	        String path = String.format("%s/%s", "shipmanage", UUID.randomUUID());
	        String fileName = String.format("%s", file.getOriginalFilename());
	        try {
	            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
	        } catch (IOException e) {
	            throw new IllegalStateException("Failed to upload file", e);
	        }
	        ToDo todo = ToDo.builder()
	                .description(description)
	                .title(title)
	                .imagePath(path)
	                .imageFileName(fileName)
	                .build();
	        
	        
	        
	        
	        
	        repository.save(todo);
	        return repository.findByTitle(todo.getTitle());		
		
		
		
		
	}
	
	
	
	
	

}
