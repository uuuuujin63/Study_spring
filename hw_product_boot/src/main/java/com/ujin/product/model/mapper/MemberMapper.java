package com.ujin.product.model.mapper;

import java.util.Map;

import com.ujin.product.model.MemberDto;

public interface MemberMapper {

	void registerMember(MemberDto memberDto) throws Exception;

	MemberDto login(Map<String, String> map) throws Exception;

}
