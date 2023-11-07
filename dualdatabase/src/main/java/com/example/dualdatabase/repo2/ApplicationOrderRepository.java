package com.example.dualdatabase.repo2;

import com.example.dualdatabase.entity2.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationOrderRepository extends JpaRepository<Orders, Integer> {
}
