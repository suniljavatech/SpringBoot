package com.shop.service;

import org.springframework.web.multipart.MultipartFile;

import com.shop.model.ToDo;

public interface ToDoService {
    ToDo saveTodo(String title, String description, MultipartFile file);

}
