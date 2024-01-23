package com.example.reservehaja.data.repo;

import com.example.reservehaja.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//ProductRepository가 JpaRepository를 상속받을 때는 대상 엔티티(Product)와 기본키 필드타입(Long number)을 지정해야함
public interface ProductRepository extends JpaRepository<Product, Long> {
}
