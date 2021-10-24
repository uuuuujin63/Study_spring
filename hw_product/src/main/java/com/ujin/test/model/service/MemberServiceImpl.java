package com.ujin.test.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujin.test.model.MemberDto;
import com.ujin.test.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		memberDao.registerMember(memberDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return memberDao.login(map);
	}
}
