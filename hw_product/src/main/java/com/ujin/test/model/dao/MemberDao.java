package com.ujin.test.model.dao;

import java.util.Map;

import com.ujin.test.model.MemberDto;

public interface MemberDao {

	void registerMember(MemberDto memberDto) throws Exception;

	MemberDto login(Map<String, String> map) throws Exception;

}
