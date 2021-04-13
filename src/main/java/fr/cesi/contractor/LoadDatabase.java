package fr.cesi.contractor;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.CustomerRepository;
import fr.cesi.contractor.Repository.ProjectRepository;
import fr.cesi.contractor.Repository.QuoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuoteRepository quoteRepository, CustomerRepository customerRepository, ProjectRepository projectRepository) {

        //--> Customer
        Customer c1 = new Customer(
                "Client 1",
                "ienCli",
                "toto@email.fr",
                "0123456789",
                "Mr",
                "TotoAdrresse",
                79200,
                "totoVille",
                "Customer",
                false,
                "1",
                new Date(),
                new Date()
        );
        Customer c2 = new Customer(
                "Eren",
                "Jager",
                "lachouette@eldien.fr",
                "0123456789",
                "Mr",
                "TotoAdrresse",
                79200,
                "totoVille",
                "Customer",
                false,
                "1",
                new Date(),
                new Date()
        );
        Customer c3 = new Customer(
                "Ackerman",
                "Mikassa",
                "Mikassa@Ackerman.fr",
                "0123456789",
                "Mme",
                "TotoAdrresse",
                79200,
                "totoVille",
                "Customer",
                false,
                "1",
                new Date(),
                new Date()
        );
        Customer c4 = new Customer(
                "Ackerman",
                "Livai",
                "Livai@Ackerman.fr",
                "0123456789",
                "Non-Binaire",
                "TotoAdrresse",
                79200,
                "totoVille",
                "Customer",
                false,
                "1",
                new Date(),
                new Date()
        );
        //--> Project
        Project p1 = new Project(
                "Projet 1",
                null,
                "rue test",
                44444,
                "NANTES",
                new Date(),
                "en cours",
                false,
                1,
                new Date()
        );
        Project p2 = new Project(
                "Projet 2",
                null,
                "rue test 2",
                66666,
                "SATAN",
                new Date(),
                "terminé",
                false,
                1,
                new Date()
        );
        Project p3 = new Project(
                "Projet 3",
                null,
                "rue test 3",
                99999,
                "EROSLAND",
                new Date(),
                "terminé",
                false,
                1,
                new Date()
        );
        //--> Quote
        Quote q1 = new Quote(
                "Devis 1",
                "En Attente",
                150000,
                182000,
                new Date(),
                new Date(),
                false,
                1,
                c1,
                p1
        );
        Quote q2 = new Quote(
                "Devis 2",
                "En Attente",
                17206,
                19954,
                new Date(),
                new Date(),
                false,
                1,
                c2,
                p2
        );

        return args -> {
            //log.info("Preloading " + projectRepository.save());
        };
    }
}
