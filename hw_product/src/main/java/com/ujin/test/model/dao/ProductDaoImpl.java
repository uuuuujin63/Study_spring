package com.ujin.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ujin.test.model.ProductDto;
import com.ujin.util.DBUtil;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private DBUtil dbUtil;
	@Autowired
	private DataSource dataSource;

	@Override
	public void registerProduct(ProductDto productDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		StringBuilder registerArticle = new StringBuilder();
		registerArticle.append("insert into product (userid, pcode, pname, price, sup, status) \n");
		registerArticle.append("values (?, ?, ?, ?, ?, ?)");
		pstmt = conn.prepareStatement(registerArticle.toString());
		pstmt.setString(1, productDto.getUserid());
		pstmt.setString(2, productDto.getPcode());
		pstmt.setString(3, productDto.getPname());
		pstmt.setInt(4, productDto.getPrice());
		pstmt.setString(5, productDto.getSup());
		if(productDto.getStatus().equals("canbuy")) {
			pstmt.setString(6, "Y");
		} else {
			pstmt.setString(6, "N");
		}
		int cnt = pstmt.executeUpdate();
		if(cnt!=1) {
			System.out.println("상품 등록 실패..");
		}else {
			System.out.println("상품 "+cnt+"개 등록 성공..");
		}
		dbUtil.close(pstmt, conn);
	}

	@Override
	public List<ProductDto> listProduct(Map<String, String> map) throws Exception {
		List<ProductDto> list = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = dataSource.getConnection();
		StringBuilder listArticle = new StringBuilder();
		listArticle.append("select userid, pcode, pname, price, sup, status, regtime \n");
		listArticle.append("from product \n");
		listArticle.append("order by regtime desc");
		pstmt = conn.prepareStatement(listArticle.toString());
		rs = pstmt.executeQuery();
		while(rs.next()) {
			ProductDto productDto = new ProductDto();
			productDto.setUserid(rs.getString("userid"));
			productDto.setPcode(rs.getString("pcode"));
			productDto.setPname(rs.getString("pname"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setSup(rs.getString("sup"));
			productDto.setStatus(rs.getString("status"));
			productDto.setRegtime(rs.getString("regtime"));
			System.out.println(productDto.toString());
			list.add(productDto);
		}
		dbUtil.close(rs, pstmt, conn);
		return list;
	}

	@Override
	public void deleteProduct(String pcode) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		StringBuilder listArticle = new StringBuilder();
		listArticle.append("delete from product \n");
		listArticle.append("where pcode=?");
		pstmt = conn.prepareStatement(listArticle.toString());
		pstmt.setString(1, pcode);
		pstmt.executeUpdate();
		dbUtil.close(pstmt, conn);
	}

	@Override
	public ProductDto getProduct(String pcode) throws Exception {
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = dataSource.getConnection();
		StringBuilder listArticle = new StringBuilder();
		listArticle.append("select userid, pcode, pname, price, sup, status, regtime \n");
		listArticle.append("from product \n");
		listArticle.append("where pcode = ?");
		pstmt = conn.prepareStatement(listArticle.toString());
		pstmt.setString(1, pcode);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			productDto = new ProductDto();
			productDto.setUserid(rs.getString("userid"));
			productDto.setPcode(rs.getString("pcode"));
			productDto.setPname(rs.getString("pname"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setSup(rs.getString("sup"));
			productDto.setStatus(rs.getString("status"));
			productDto.setRegtime(rs.getString("regtime"));
		}
		dbUtil.close(rs, pstmt, conn);
		return productDto;
	}

	@Override
	public void updateProduct(String pcode, ProductDto productDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		StringBuilder registerArticle = new StringBuilder();
		registerArticle.append("update product set pcode = ?, pname = ?, price = ?, sup = ?, status = ? \n");
		registerArticle.append("where pcode = ? ");
		pstmt = conn.prepareStatement(registerArticle.toString());
		pstmt.setString(1, productDto.getPcode());
		pstmt.setString(2, productDto.getPname());
		pstmt.setInt(3, productDto.getPrice());
		pstmt.setString(4, productDto.getSup());
		if(productDto.getStatus().equals("canbuy")) {
			pstmt.setString(5, "Y");
		} else {
			pstmt.setString(5, "N");
		}
		pstmt.setString(6, pcode);
		System.out.println(productDto.toString());
		System.out.println(pcode);
		int cnt = pstmt.executeUpdate();
		if(cnt!=1) {
			System.out.println("상품 등록 실패..");
		}else {
			System.out.println("상품 "+cnt+"개 등록 성공..");
		}
		dbUtil.close(pstmt, conn);
	}
	
}
