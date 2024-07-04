package dpw.hackathon.smart_search.controller;

import dpw.hackathon.smart_search.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

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
