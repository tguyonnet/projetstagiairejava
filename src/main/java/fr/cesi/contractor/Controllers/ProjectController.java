package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.CustomerRepository;
import fr.cesi.contractor.Repository.ProjectRepository;
import fr.cesi.contractor.Repository.QuoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProjectController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/projects")
    public List<Project> allProjects() {
      return projectRepository.findByIsDeletedEquals(false);
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
        project.setUpdated_at();

        final Project updateProject = projectRepository.save(project);
        return ResponseEntity.ok(updateProject);
    }

    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project " + id + " not found"));

        //Quand on supprime le projet, on supprime les devis qui y sont liés
        List<Quote> quotes = quoteRepository.findAllByProject(project);
        project.safeDeleted(quotes);
        for (Quote quote:quotes) {
            quoteRepository.save(quote);
        }
        projectRepository.save(project);
        return ResponseEntity.ok("Project successfully deleted");
    }
}
