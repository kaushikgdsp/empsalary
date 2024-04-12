package com.shopping.productmanagement;

import java.util.List;

public interface ProductService  //service interface
{

	//service methods decalartions
	public Product saveProduct(Product product);
	
	public Product fetchProduct(Product product);
	
	
	public List<Product> fetchByPriceBetween(double lPrice, double uPrice);
	
	public Product fetchProductwithMaximumPrice();
	
	public Product fetchProductwithMinimumPrice();
	
}
