package ieti.orders.repository;

import models.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProductRepository extends MongoRepository<ProductDocument, String>{
}
