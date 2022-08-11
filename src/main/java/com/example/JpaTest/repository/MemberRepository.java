package com.example.JpaTest.repository;

import com.example.JpaTest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findFirst2ByUsernameLikeOrderByIDDesc(String name);
}
