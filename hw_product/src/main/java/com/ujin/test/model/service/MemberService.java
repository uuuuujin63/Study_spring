package com.ujin.test.model.service;

import java.util.Map;

import com.ujin.test.model.MemberDto;

public interface MemberService {

	void registerMember(MemberDto memberDto) throws Exception;

	MemberDto login(Map<String, String> map) throws Exception;

}
