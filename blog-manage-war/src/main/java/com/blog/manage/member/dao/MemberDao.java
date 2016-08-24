package com.blog.manage.member.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.blog.member.entity.Member;

public interface MemberDao extends PagingAndSortingRepository<Member, Long>,
	JpaSpecificationExecutor<Member> {

}
