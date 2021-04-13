package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    };

    @GetMapping("show/{id}")
    public Optional<Project> getProjectById(@PathVariable(value = "id") Long id) {
        return projectRepository.findById(id);
    };

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
      ;  return projectRepository.save(project);
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return "Projet "+ id + " supprimé ";
    };
}
