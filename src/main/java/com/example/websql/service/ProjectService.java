package com.example.websql.service;


import com.example.websql.entity.Project;
import com.example.websql.entity.User;

import java.util.List;

public interface ProjectService {

    List<Project> getList();
    Project getListById(String projectId);

    boolean add(Project project);

    boolean update(Project project);

    boolean delete(String projectId);
}
