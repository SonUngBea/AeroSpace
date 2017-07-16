package domainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Member;
import repository.MemberRepository;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Service
public class MemberJoinService {
	@Autowired
	private MemberRepository memberRepository;

	public void join(String email, String password, String name) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		memberRepository.insert(member);
	}
}
