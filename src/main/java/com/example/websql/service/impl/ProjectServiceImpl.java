package com.example.websql.service.impl;

import com.example.websql.dao.ProjectDao;
import com.example.websql.entity.Project;
import com.example.websql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getList() {

        return projectDao.getList();
    }

    @Override
    public Project getListById(String projectId) {
        return projectDao.getListById(projectId);
    }

    @Transactional
    @Override
    public boolean add(Project project) {

        if (project == null) {
            return false;
        }

        int effectNum = projectDao.add(project);
        if (effectNum > 0) {
            return true;
        }

        return false;
    }

    @Transactional
    @Override
    public boolean update(Project user) {

        int effectNum = projectDao.update(user);
        if (effectNum > 0) {
            return true;
        }

        return false;
    }

    @Transactional
    @Override
    public boolean delete(String projectId) {

        int effectNum = projectDao.delete(projectId);
        if (effectNum > 0) {
            return true;
        }

        return false;
    }
}
