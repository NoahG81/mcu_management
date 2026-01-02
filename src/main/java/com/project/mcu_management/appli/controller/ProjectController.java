package com.project.mcu_management.appli.controller;

import com.project.mcu_management.appli.ProjectApplication;
import com.project.mcu_management.appli.bean.MediaTypeBean;
import com.project.mcu_management.appli.bean.ProjectBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    private final ProjectApplication projectApplication;

    public ProjectController(ProjectApplication projectApplication) {
        this.projectApplication = projectApplication;
    }

    @PostMapping(consumes = "multipart/form-data")
    public void createProject(
            @RequestParam String titre,
            @RequestParam("ordreVisionnage") Integer ordreVisionnage,
            @RequestParam("dureeMinutes") Integer dureeMinutes,
            @RequestParam("dateSortie")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateSortie,
            @RequestParam("typeMedia") MediaTypeBean typeMedia,
            @RequestParam("phaseId") Long phaseId,
            @RequestPart("affiche") MultipartFile afficheFile) throws IOException {
        ProjectBean media = new ProjectBean(titre, ordreVisionnage, dureeMinutes, dateSortie,
                    typeMedia, phaseId, afficheFile.getBytes(), "", "Optionnel");

        projectApplication.insert(media);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProjectBean> getProjectById(@PathVariable("id") Long id) {
        return projectApplication.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Map<String, List<ProjectBean>>> getAllProject() {
        try {
            var projects = projectApplication.getAllProjects();
            return ResponseEntity.ok(projects);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
