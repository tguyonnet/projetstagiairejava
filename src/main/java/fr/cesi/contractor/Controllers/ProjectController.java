package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> allProjects() {
      return projectRepository.findAll();
    }

    @GetMapping("/project/show/{id}")
    public Optional<Project> getProjectById(@PathVariable(value = "id") Integer id) {
        return projectRepository.findById(id);
    }

    @PostMapping("/project/create")
    public Project createProject(@Validated @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/project/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Integer id, @Validated @RequestBody Project changeProject) throws ResourceNotFoundException
    {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project " + id + " not found"));

        if(changeProject.getName() !=null) {
            project.setName(changeProject.getName());
        }
        if(changeProject.getAddress() !=null) {
            project.setAddress(changeProject.getAddress());
        }
        if(changeProject.getPostCode() !=null) {
            project.setPostCode(changeProject.getPostCode());
        }
        if(changeProject.getCity() !=null) {
            project.setCity(changeProject.getCity());
        }
        if(changeProject.getDateBeginSite() !=null) {
            project.setDateBeginSite(changeProject.getDateBeginSite());
        }
        if(changeProject.getState() !=null) {
            project.setState(changeProject.getState());
        }
        if(changeProject.getIsDeleted() !=null) {
            project.setIsDeleted(changeProject.getIsDeleted());
        }
        project.setUpdated_at(new Date());

        final Project updateProject = projectRepository.save(project);
        return ResponseEntity.ok(updateProject);
    }

    @DeleteMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Integer id) {
        projectRepository.deleteById(id);
        return "Projet "+ id + " supprimé ";
    }
}
