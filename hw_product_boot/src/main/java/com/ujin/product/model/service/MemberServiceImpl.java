package com.ujin.product.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujin.product.model.MemberDto;
import com.ujin.product.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).registerMember(memberDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).login(map);
	}
}
