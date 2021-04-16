package fr.cesi.contractor.Repository;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    public List<Quote> findAllByProject(Project project);
    public List<Quote> findByIsDeletedEquals(boolean b);
}
