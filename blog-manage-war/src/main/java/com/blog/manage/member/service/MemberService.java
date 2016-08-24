package com.blog.manage.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.manage.member.dao.MemberDao;
import com.blog.member.entity.Member;
import com.rensframework.core.service.BaseService;

@Service
@Transactional(readOnly=true)
public class MemberService extends BaseService<Member> {

	@Autowired
	private MemberDao memberDao;
	@Override
	protected PagingAndSortingRepository<Member, Long> getDao() {
		return memberDao;
	}

}
