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

        return args -> {
            log.info("Preloading " + quoteRepository.save(new Quote(
                    "Devis 1",
                    "En Attente",
                    150000,
                    182000,
                    new Date(),
                    new Date(),
                    false,
                    1,
                    customerRepository.getOne(3),
                    null
            )));
            log.info("Preloading " + quoteRepository.save(new Quote(
                    "Devis 2",
                    "En Attente",
                    17206,
                    19954,
                    new Date(),
                    new Date(),
                    false,
                    1,
                    customerRepository.getOne(2),
                    null
            )));
            log.info("Preloading " + customerRepository.save(new Customer(
                    "Client 1",
                    "ienCli",
                    "toto@email.fr",
                    "0123456789",
                    "Mr",
                    "Customer",
                    false,
                    "1",
                    new Date(),
                    new Date()
            )));
            log.info("Preloading " + customerRepository.save(new Customer(
                    "Eren",
                    "Jager",
                    "lachouette@eldien.fr",
                    "0123456789",
                    "Mr",
                    "Customer",
                    false,
                    "1",
                    new Date(),
                    new Date()
            )));
            log.info("Preloading " + customerRepository.save(new Customer(
                    "Ackerman",
                    "Mikassa",
                    "Mikassa@Ackerman.fr",
                    "0123456789",
                    "Mme",
                    "Customer",
                    false,
                    "1",
                    new Date(),
                    new Date()
            )));
            log.info("Preloading " + customerRepository.save(new Customer(
                    "Ackerman",
                    "Livai",
                    "Livai@Ackerman.fr",
                    "0123456789",
                    "Non-Binaire",
                    "Customer",
                    false,
                    "1",
                    new Date(),
                    new Date()
            )));

            log.info("Preloading " + projectRepository.save(new Project(
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
            )));
            log.info("Preloading " + projectRepository.save(new Project(
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
            )));
            log.info("Preloading " + projectRepository.save(new Project(
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
            )));
        };
    }

}
