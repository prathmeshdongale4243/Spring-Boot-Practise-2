package RamBasePackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import RamBasePackage.Entity.Product;

public interface productRepository extends JpaRepository<Product, Integer>{

}
