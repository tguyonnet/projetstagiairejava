package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Item;
import fr.cesi.contractor.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemRepository itemsRepository;
    /**
     * List of items
     *
     * @return the list
     */
    @GetMapping("/items")
    public List<Item> getAllItems(){return itemsRepository.findAll();}

}
