package com.devsuperior.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.vendas.entities.Sale;
@Repository
public interface SaleRepository extends JpaRepository<Sale,Long>{

}
