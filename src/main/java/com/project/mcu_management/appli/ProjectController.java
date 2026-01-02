package com.project.mcu_management.appli;

import com.project.mcu_management.appli.bean.MediaTypeBean;
import com.project.mcu_management.appli.bean.ProjectBean;
import com.project.mcu_management.appli.mapper.ProjectBeanMapper;
import com.project.mcu_management.domain.api.ManageProject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    private final ManageProject projectManager;
    private final ProjectBeanMapper projectBeanMapper;

    public ProjectController(ManageProject projectManager, ProjectBeanMapper projectBeanMapper) {
        this.projectManager = projectManager;
        this.projectBeanMapper = projectBeanMapper;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ProjectBean> createProject(
            @RequestParam String titre,
            @RequestParam("ordreVisionnage") Integer ordreVisionnage,
            @RequestParam("dureeMinutes") Integer dureeMinutes,
            @RequestParam("dateSortie")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateSortie,
            @RequestParam("typeMedia") MediaTypeBean typeMedia,
            @RequestParam("phaseId") Long phaseId,
            @RequestPart("affiche") MultipartFile afficheFile) throws IOException {

        try {
            ProjectBean media = new ProjectBean(titre, ordreVisionnage, dureeMinutes, dateSortie,
                    typeMedia, phaseId, afficheFile.getBytes());

            projectManager.insert(projectBeanMapper.mapToDomain(media));

            return ResponseEntity.of(Optional.empty());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProjectBean> getProjectById(@PathVariable("id") Long id) {
        var project = projectManager.getById(id);
        return project
                .map(projectBeanMapper::map)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
