package fr.cesi.contractor;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Item;
import fr.cesi.contractor.Models.Project;
import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.CustomerRepository;
import fr.cesi.contractor.Repository.ItemRepository;
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
    CommandLineRunner initDatabase(QuoteRepository quoteRepository, CustomerRepository customerRepository, ProjectRepository projectRepository, ItemRepository itemRepository) {

        return args -> {
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
            log.info("Preloading " + customerRepository.save(c1));

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
            log.info("Preloading " + customerRepository.save(c2));
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
            log.info("Preloading " + customerRepository.save(c3));
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
            log.info("Preloading " + customerRepository.save(c4));
            //--> Project
            Project p1 = new Project(
                    "Projet 1",
                    c1,
                    "rue test",
                    44444,
                    "NANTES",
                    new Date(),
                    "en cours",
                    false,
                    1,
                    new Date(),
                    new Date()
            );
            log.info("Preloading " + projectRepository.save(p1));
            Project p2 = new Project(
                    "Projet 2",
                    c2,
                    "rue test 2",
                    66666,
                    "SATAN",
                    new Date(),
                    "terminé",
                    false,
                    1,
                    new Date(),
                    new Date()
            );
            log.info("Preloading " + projectRepository.save(p2));
            Project p3 = new Project(
                    "Projet 3",
                    c3,
                    "rue test 3",
                    99999,
                    "EROSLAND",
                    new Date(),
                    "terminé",
                    false,
                    1,
                    new Date(),
                    new Date()
            );
            log.info("Preloading " + projectRepository.save(p3));
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
            log.info("Preloading " + quoteRepository.save(q1));
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
            log.info("Preloading " + quoteRepository.save(q2));
            Quote q3 = new Quote(
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
            log.info("Preloading " + quoteRepository.save(q3));
            // -> Item
            Item i1 = new Item(
                    "Article Démo",
                    60,
                    "Usage unique",
                    50.6f,
                    45.5f
            );
            log.info("Preloading "+itemRepository.save(i1));
            Item i2 = new Item(
                    "Article Démo",
                    80,
                    "Echantillon",
                    50.8f,
                    44.5f
            );
            log.info("Preloading "+itemRepository.save(i2));
            Item i3 = new Item(
                    "Article Démo",
                    60,
                    "Usage demo",
                    52.6f,
                    43.5f
            );
            log.info("Preloading "+itemRepository.save(i3));
        };
    }
}
