package repository;

import org.springframework.stereotype.Repository;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Repository
public interface MemberDao {

	void insert(Member member);

	Member select(String memberSeq);

	int update(Member member);

	int delete(Member member);
}
