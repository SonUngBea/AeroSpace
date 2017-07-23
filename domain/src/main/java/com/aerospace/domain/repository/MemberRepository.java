package com.aerospace.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
	Member findByMemberSeq(Integer memberSeq);
}
