package guru.springframework.services.reposervices;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"springdatajpa", "jpadao"})
public class ProductServiceRepoImpl implements ProductService {

  private ProductRepository productRepository;

  @Autowired
  public ProductServiceRepoImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<?> listAll() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(p -> products.add(p));
    return products;
  }

  @Override
  public Product getById(Integer id) {
    return productRepository.findOne(id);
  }

  @Override
  public Product saveOrUpdate(Product domainObject) {
    return productRepository.save(domainObject);
  }

  @Override
  public void delete(Integer id) {
    productRepository.delete(id);
  }
}
