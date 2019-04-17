package com.example.websql.dao;

import com.example.websql.entity.Project;
import com.example.websql.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectDao {

    List<Project> getList();

    Project getListById(String projectId);

    int insert(Project user);

    int update(Project user);

    int delete(String projectId);

}
