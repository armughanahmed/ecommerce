package com.armughanahmed.ecommerce.ecommerce.service.Imp;

import com.armughanahmed.ecommerce.ecommerce.domain.Product;
import com.armughanahmed.ecommerce.ecommerce.repository.ProductRepository;
import com.armughanahmed.ecommerce.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        productRepository.delete(existingProduct);
    }
}
