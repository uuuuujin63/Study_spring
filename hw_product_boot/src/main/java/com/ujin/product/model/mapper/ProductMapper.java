package com.ujin.product.model.mapper;

import java.util.List;
import java.util.Map;

import com.ujin.product.model.FileInfoDto;
import com.ujin.product.model.ProductDto;

public interface ProductMapper {

	void registerProduct(ProductDto productDto) throws Exception;
	void registerFile(ProductDto productDto) throws Exception;

	List<ProductDto> listProduct(Map<String, String> map) throws Exception;

	void deleteProduct(String pcode) throws Exception;

	ProductDto getProduct(String pcode) throws Exception;

	void updateProduct(ProductDto productDto) throws Exception;

	List<FileInfoDto> fileInfoList(String pcode) throws Exception;

}
