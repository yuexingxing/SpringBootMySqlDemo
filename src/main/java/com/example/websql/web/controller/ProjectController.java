package com.example.websql.web.controller;

import com.example.websql.Res;
import com.example.websql.entity.Project;
import com.example.websql.service.ProjectService;
import com.example.websql.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //查询所有数据
    @GetMapping(value = "/projects")
    public Res getProject() {

        List<Project> list = projectService.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);

        return Res.build(0, 0, "查询成功", map);
    }

    @RequestMapping(value = "/projects/{project_id}")
    public Res queryById(@PathVariable String project_id) {

        Project project = projectService.getListById(project_id);
        return Res.build(0, 0, "查询成功", project == null ? new HashMap<>() : project);
    }

    @PostMapping(value = "/add")
    public Res add(@RequestParam("name") String name, @RequestParam("type") String type) {

        Project project = new Project();
        project.setProject_id(Utils.getUUID());
        project.setName(name);
        project.setType(type);

        boolean flag = projectService.add(project);
        return Res.build(0, 0, flag ? "插入成功!" : "插入失败!", null);
    }

    @PostMapping(value = "/update")
    public Res update(@RequestParam("project_id") String project_id, @RequestParam("name") String name) {

        Project project = new Project();
        project.setProject_id(project_id);
        project.setName(name);

        boolean flag = projectService.update(project);
        return Res.build(flag ? 0 : 1, 0, flag ? "更新成功" : "更新失败", null);
    }

    @PostMapping(value = "/delete")
    public Res delete(@RequestParam("project_id") String project_id) {

        boolean flag = projectService.delete(project_id);
        return Res.build(flag ? 0 : 1, 0, flag ? "删除成功" : "删除失败", null);
    }
}
