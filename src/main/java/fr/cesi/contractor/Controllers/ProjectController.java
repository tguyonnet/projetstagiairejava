package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/index")
    public List<Project> allProjects() {
      return projectRepository.findAll();
    }

    @GetMapping("show/{id}")
    public Optional<Project> getProjectById(@PathVariable(value = "id") Long id) {
        return projectRepository.findById(id);
    }

    @PostMapping("/create")
    public Project createProject(@Validated @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long id, @Validated @RequestBody Project changeProject) throws ResourceNotFoundException
    {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote " + id + " not found"));

        project.setName(changeProject.getName());
        project.setAddress(changeProject.getAddress());
        project.setPostCode(changeProject.getPostCode());
        project.setCity(changeProject.getCity());
        project.setDateBeginSite(changeProject.getDateBeginSite());
        project.setState(changeProject.getState());
        project.setIsDeleted(changeProject.getIsDeleted());
        project.set_v(changeProject.get_v());

        final Project updateProject = projectRepository.save(project);
        return ResponseEntity.ok(updateProject);
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return "Projet "+ id + " supprimé ";
    }
}
