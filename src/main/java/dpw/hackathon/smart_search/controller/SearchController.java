package dpw.hackathon.smart_search.controller;

import dpw.hackathon.smart_search.service.ProductService;
import dpw.hackathon.smart_search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService serviceService;


    @GetMapping("")
    public ResponseEntity<?> searchProducts(@RequestParam String rawQuery){
        log.info("Raw Query: " + rawQuery);

        return new ResponseEntity<>(serviceService.processRawQuery(rawQuery), HttpStatus.OK);
    }



}
