package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.QuoteRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {
    @Autowired
    private QuoteRepository quoteRepository;

    /**
     * List of quotes
     *
     * @return the list
     */
    @GetMapping("/quotes")
    public List<Quote> getAllQuotes()
    {
        return quoteRepository.findAll();
    }

    /**
     * Get quote by id
     *
     * @param quoteId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("quote/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable(value = "id") Integer quoteId) throws ResourceNotFoundException
    {
        Quote quote = quoteRepository.findById(quoteId)
            .orElseThrow(() -> new ResourceNotFoundException("Quote " + quoteId + " not found"));
        return ResponseEntity.ok().body(quote);
    }

    /**
     * Create quote
     *
     * @param quote
     * @return
     */
    @PostMapping("/quote")
    public Quote createQuote(@Validated @RequestBody Quote quote)
    {
        return quoteRepository.save(quote);
    }


    /**
     * Update 1 quote
     *
     * @param quoteId
     * @param quoteDetail
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/quote/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable(value = "id") Integer quoteId, @Validated @RequestBody Quote quoteDetail) throws ResourceNotFoundException
    {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Quote " + quoteId + " not found"));

        if (quoteDetail.get_v() != 0) {
            quote.set_v(quoteDetail.get_v());
        }
        if (quoteDetail.getCustomer() != null) {
            quote.setCustomer(quoteDetail.getCustomer());
        }
        if (quoteDetail.getObject() != null) {
            quote.setObject(quoteDetail.getObject());
        }
        if (quoteDetail.getProject() != null) {
            quote.setProject(quoteDetail.getProject());
        }
        if (quoteDetail.getState() != null) {
            quote.setState(quoteDetail.getState());
        }
        if (quoteDetail.getTotalCost() != 0) {
            quote.setTotalCost(quoteDetail.getTotalCost());
        }
        if (quoteDetail.getTotalPrice() != 0) {
            quote.setTotalPrice(quoteDetail.getTotalPrice());
        }
        quote.setUpdated_at(new Date());

        final Quote updatedQuote = quoteRepository.save(quote);
        return ResponseEntity.ok(updatedQuote);
    }

    /**
     * Delete the selected quote
     *
     * @param quoteId
     * @return
     */
    @DeleteMapping("/quote/{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable(value = "id") Integer quoteId)
    {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Quote " + quoteId + " not found"));

        quote.setDeleted(true);

        quoteRepository.save(quote);
        return ResponseEntity.ok("Quote successfully deleted");
    }
}
