package dpw.hackathon.smart_search.service;

import dpw.hackathon.smart_search.entity.Product;
import dpw.hackathon.smart_search.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class ProductService {

    private final List<String> categories = Arrays.asList("Electronics", "Fashion", "Food");

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(Integer id){
        return productRepository.findById(id).orElseThrow(() -> null);
    }

    public List<Product> getProductByQuery(String query){
        TypedQuery<Product> query1 = entityManager.createQuery(query, Product.class);
        return query1.getResultList();
    }


    @Transactional
    public void saveDummyProducts(int size) {
        Random random = new Random();
        for(int i=0;i<size;i++){
            Product product = new Product();
            int randomInt = random.nextInt(categories.size());
            product.setCategory(categories.get(randomInt));
            product.setName("product" + i);
            product.setPrice(BigDecimal.valueOf(random.nextDouble(3000)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            product.setRating(random.nextInt(6));
            product.setIsActive(random.nextBoolean());
            productRepository.save(product);
            log.info("Saved " + i + "th Product!");
        }
    }

    @Transactional
    public void deleteAllProducts(){
        productRepository.deleteAll();
    }


}
