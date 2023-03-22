package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1, "Telefon Kılıfı", 10, 30.50, "poco x3 pro kılıfı"));
        products.add(new Product(2, "Kulaklık", 10, 4500, "steelseries"));
        products.add(new Product(3, "Windows 11", 5, 2000, "microsoft windows 11"));
        products.add(new Product(4, "Pes2023", 7, 50, "PC oyunu"));
        products.add(new Product(5, "HDMI kablosu", 10, 69.99, "Tüm cihazlar için uyumludur"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId()==id) {
                return product;
            }
        }
        return null;

    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        for (Product products : products) {
            if (products.getId()==id) {
                products.setName(product.getName());
                products.setQuantity(product.getQuantity());
                products.setUnitPrice(product.getUnitPrice());
                products.setDescription(product.getDescription());
                return products;
            }
        }
        return null;

    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if (product.getId()==id) {
                products.remove(product);
            }
        }
    }
}
