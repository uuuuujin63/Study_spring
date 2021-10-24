package com.ujin.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ujin.test.model.MemberDto;
import com.ujin.util.DBUtil;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private DBUtil dbUtil;

	@Autowired
	private DataSource dataSource;

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
		StringBuilder registerMember = new StringBuilder();
		registerMember.append("insert into user (userid, password) \n");
		registerMember.append("values (?, ?)");
		pstmt = conn.prepareStatement(registerMember.toString());
		pstmt.setString(1, memberDto.getUserid());
		pstmt.setString(2, memberDto.getPwd());
		pstmt.executeUpdate();

		dbUtil.close(pstmt, conn);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = dataSource.getConnection();
		StringBuilder loginMember = new StringBuilder();
		loginMember.append("select userid \n");
		loginMember.append("from user \n");
		loginMember.append("where userid = ? and password = ?");
		pstmt = conn.prepareStatement(loginMember.toString());
		pstmt.setString(1, map.get("userId"));
		pstmt.setString(2, map.get("userPwd"));
		rs = pstmt.executeQuery();
		if (rs.next()) {
			memberDto = new MemberDto();
			memberDto.setUserid(rs.getString("userid"));
		}
		System.out.println(memberDto.toString());
		dbUtil.close(rs, pstmt, conn);

		return memberDto;
	}
}
