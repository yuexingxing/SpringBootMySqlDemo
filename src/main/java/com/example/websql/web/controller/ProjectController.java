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

        Res res = new Res();
        res.setData(map);
        res.setSuccess(0);
        return res;
    }

    @RequestMapping(value = "/projects/{project_id}")
    public Res queryUserById(@PathVariable String project_id) {

        Project project = projectService.getListById(project_id);

        Res res = new Res();
        res.setData(project);
        res.setSuccess(0);
        return res;
    }

    @PostMapping(value = "/add")
    public Res add(@RequestParam("name") String name, @RequestParam("type") String type) {

        Project project = new Project();
        project.setProject_id(Utils.getUUID());
        project.setName(name);
        project.setType(type);

        System.out.println(project.getProject_id());
        boolean flag = projectService.add(project);

        Res res = new Res();
        res.setSuccess(flag ? 0 : 1);
        if (flag) {
            res.setMessage("插入成功!");
        }

        return res;
    }

    @PostMapping(value = "/update")
    public Res update(@RequestParam("project_id") String project_id, @RequestParam("name") String name) {

        Project project = new Project();
        project.setProject_id(project_id);
        project.setName(name);

        boolean flag = projectService.update(project);

        Res res = new Res();
        res.setSuccess(flag ? 0 : 1);
        if (flag) {
            res.setMessage("更新成功!");
        } else {
            res.setMessage("用户不存在或更新失败");
        }

        return res;
    }

    @PostMapping(value = "/delete")
    public Map<String, Object> delete(@RequestParam("project_id") String project_id) {

        projectService.delete(project_id);

        Map<String, Object> map = new HashMap<>();
        map.put("data", null);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }
}
