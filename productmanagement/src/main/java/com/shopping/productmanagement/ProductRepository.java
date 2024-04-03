package com.shopping.productmanagement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

	//all the methods of CrudRepository, JpaRepository, PagingAndSorting and QueryByExampleExecutor are inherited
	
	public List<Product> findByPriceBetween(double lPrice, double uPrice); //derived query method
	
}

