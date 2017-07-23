package com.aerospace.domain.application;

import com.aerospace.domain.repository.Member;
import com.aerospace.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by coupang on 2017. 7. 22..
 */
@Service
public class DBConnectTestService {

	@Autowired
	MemberRepository memberRepository;

	public String getId(Integer memberSeq) throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://13.124.150.31/ojtproject", "ojt_venice", "venice");
//
//		PreparedStatement st = c.prepareStatement("select * from member where memberSeq = '2'");
////		st.setString(1, memberSeq);
//
//
//		ResultSet rs = st.executeQuery();
//		Member member = new Member();
//		if(rs.next()) {
//			member.setEmail(rs.getString("email"));
//			member.setName(rs.getString("name"));
//			member.setPassword(rs.getString("password"));
//		}
//		rs.close();
//		st.close();
//		c.close();
//		return member.getName();
		Member member =  memberRepository.findByMemberSeq(memberSeq);
		return member.getName();
	}

}
