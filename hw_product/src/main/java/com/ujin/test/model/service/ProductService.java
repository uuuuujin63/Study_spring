package com.ujin.test.model.service;

import java.util.List;
import java.util.Map;

import com.ujin.test.model.ProductDto;

public interface ProductService {

	void registerProduct(ProductDto productDto) throws Exception;

	List<ProductDto> listProduct(Map<String, String> map) throws Exception;

	void deleteProduct(String pcode) throws Exception;

	ProductDto getProduct(String pcode) throws Exception;

	void updateProduct(String pcode, ProductDto productDto) throws Exception;

}
