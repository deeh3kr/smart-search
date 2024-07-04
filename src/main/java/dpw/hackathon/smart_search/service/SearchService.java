package dpw.hackathon.smart_search.service;

import dpw.hackathon.smart_search.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SearchService {

    @Autowired
    private ProductService productService;

    public List<Product> processRawQuery(String rawQuery) {
        String sqlQuery = getSqlQueryFromUserQuery(rawQuery);
        log.info("Got SqlQuery: " + sqlQuery);
        return productService.getProductByQuery(sqlQuery);
    }

    private String getSqlQueryFromUserQuery(String rawQuery) {
        //TODO: Use AI model Here
        return rawQuery;
    }

}
