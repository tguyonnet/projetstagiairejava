package fr.cesi.contractor;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.CustomerRepository;
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
    CommandLineRunner initDatabase(QuoteRepository quoteRepository, CustomerRepository custermeRepository) {

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
                    null,
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
                    null,
                    null
            )));
            log.info("Preloading " + custermeRepository.save(new Customer(
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
        };
    }

}
