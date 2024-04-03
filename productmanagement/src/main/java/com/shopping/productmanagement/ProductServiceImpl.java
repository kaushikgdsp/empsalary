package com.shopping.productmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	ProductRepository pRepo;
	
	@Override
	public Product saveProduct(Product product)
	{
		Product p=new Product();
		
		p=pRepo.save(product);
		
		if(p!=null)
		{
			return p;
		}
		else
		{
			return null;
		}
		
	}
	
	@Override
	public Product fetchProduct(Product product)
	{
		Product p=new Product();
		
		Optional<Product> oP=pRepo.findById(product.getCode());
		
		if(oP.isPresent())
		{
			p=oP.get();
		}
		else
		{
			p=null;
		}
		
		return p;
		
	}
	
	@Override
	public List<Product> fetchByPriceBetween(double lPrice, double uPrice)
	{
		List<Product> pLst=pRepo.findByPriceBetween(lPrice, uPrice);
		
		if(pLst.size()>0)
		{
			return pLst;
		}
		else
		{
			return null;
		}
		
	}
	
}
