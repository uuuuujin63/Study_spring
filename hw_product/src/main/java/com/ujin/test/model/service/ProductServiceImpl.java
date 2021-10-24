package com.ujin.test.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujin.test.model.ProductDto;
import com.ujin.test.model.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public void registerProduct(ProductDto productDto) throws Exception {
		productDao.registerProduct(productDto);
		
	}

	@Override
	public List<ProductDto> listProduct(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return productDao.listProduct(map);
	}

	@Override
	public void deleteProduct(String pcode) throws Exception {
		productDao.deleteProduct(pcode);
		
	}

	@Override
	public ProductDto getProduct(String pcode) throws Exception {
		return productDao.getProduct(pcode);
	}

	@Override
	public void updateProduct(String pcode, ProductDto productDto) throws Exception {
		productDao.updateProduct(pcode, productDto);
		
	}
	
}
