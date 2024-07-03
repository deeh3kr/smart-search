package dpw.hackathon.smart_search.controller;

import dpw.hackathon.smart_search.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private ProductService productService;


    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(@RequestParam String query){
        log.info("Query: " + query);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save-dummy")
    public ResponseEntity<?> saveDummyProducts(@RequestParam int size){
        log.info("Request received to save dummy products!");
        productService.saveDummyProducts(size);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAllProducts(){
        productService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
