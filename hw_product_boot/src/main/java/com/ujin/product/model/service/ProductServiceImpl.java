package com.ujin.product.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujin.product.model.FileInfoDto;
import com.ujin.product.model.ProductDto;
import com.ujin.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	@Transactional
	// 알아서 스프링이 트랜잭션해줌
	public void registerProduct(ProductDto productDto) throws Exception {
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		if(productDto.getStatus().equals("canbuy")) {
			productDto.setStatus("Y");
		} else {
			productDto.setStatus("N");
		}
		productMapper.registerProduct(productDto);
		List<FileInfoDto> fileInfos = productDto.getFileInfos();
		if(fileInfos!=null&&!fileInfos.isEmpty()) {
			productMapper.registerFile(productDto);
		}
	}

	@Override
	public List<ProductDto> listProduct(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		List<ProductDto> list =  sqlSession.getMapper(ProductMapper.class).listProduct(map);
		System.out.println(list.size());
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).getFileInfos().toString());
//		}
		return list;
	}

	@Override
	@Transactional
	public void deleteProduct(String pcode) throws Exception {
		sqlSession.getMapper(ProductMapper.class).deleteProduct(pcode);
		
	}

	@Override
	public ProductDto getProduct(String pcode) throws Exception {
		return sqlSession.getMapper(ProductMapper.class).getProduct(pcode);
	}

	@Override
	public void updateProduct(String pcode, ProductDto productDto) throws Exception {
		productDto.setPcode(pcode);
		if(productDto.getStatus().equals("canbuy")) {
			productDto.setStatus("Y");
		} else {
			productDto.setStatus("N");
		}
		sqlSession.getMapper(ProductMapper.class).updateProduct(productDto);
		
	}
	
}
