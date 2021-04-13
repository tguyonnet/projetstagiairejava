package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {
    @Autowired
    private QuoteRepository quoteRepository;

    /**
     * List of quotes
     *
     * @return the list
     */
    @GetMapping("/index")
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
    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable(value = "id") Long quoteId) throws ResourceNotFoundException
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
    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable(value = "id") Long quoteId, @Validated @RequestBody Quote quoteDetail) throws ResourceNotFoundException
    {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Quote " + quoteId + " not found"));

        quote.set_v(quoteDetail.get_v());
        quote.setCreated_at(quoteDetail.getCreated_at());
        quote.setCustomer(quoteDetail.getCustomer());
        quote.setObject(quoteDetail.getState());
        quote.setProject(quoteDetail.getProject());
        quote.setState(quoteDetail.getState());
        quote.setTotalCost(quoteDetail.getTotalCost());
        quote.setTotalPrice(quoteDetail.getTotalPrice());
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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable(value = "id") Long quoteId)
    {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Quote " + quoteId + " not found"));

        quote.setDeleted(true);

        quoteRepository.save(quote);
        return ResponseEntity.ok("Quote successfully deleted");
    }
}
