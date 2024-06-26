package com.bot.projects.controller;

import com.bot.projects.entity.Projects;
import com.bot.projects.model.ApiResponse;
import com.bot.projects.model.FilterModel;
import com.bot.projects.serviceinterface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ps/projects/")
public class ProjectController {
    @Autowired
    IProjectService iProjectService;

    @RequestMapping(value = "memberdetail/{employeeId}/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getMembersDetail(@PathVariable long employeeId,
                                                        @PathVariable int projectId) throws Exception {
        var result = iProjectService.getMembersDetailService(employeeId, projectId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @RequestMapping(value = "get/{managerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProjects(@PathVariable("managerId") long managerId) throws Exception {
        var result = iProjectService.getProjectService(managerId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @RequestMapping(value = "addUpdateProject/{projectId}", method = RequestMethod.PUT)
    public ResponseEntity<?> addUpdateProject(@RequestBody Projects project, @PathVariable int projectId) throws Exception {
        var result = iProjectService.addUpdateProjectService(projectId, project);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @RequestMapping(value = "getProjectDetail/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProjectDetail(@PathVariable int projectId) throws Exception {
        var result = iProjectService.getProjectDetailService(projectId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @RequestMapping(value = "getProjectMemberDetail/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getProjectMemberDetail(@PathVariable int projectId) throws Exception {
        var result = iProjectService.getProjectMembersService(projectId);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }

    @RequestMapping(value = "getProjectMemberByFilter", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> getProjectMemberByFilter(@RequestBody FilterModel filterModel) throws Exception {
        var result = iProjectService.getProjectMemberByFilterService(filterModel);
        return ResponseEntity.ok(ApiResponse.Ok(result));
    }
}
