package com.ujin.product.model.service;

import java.util.Map;

import com.ujin.product.model.MemberDto;

public interface MemberService {

	void registerMember(MemberDto memberDto) throws Exception;

	MemberDto login(Map<String, String> map) throws Exception;

}
