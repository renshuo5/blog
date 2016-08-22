package com.blog.news.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.blog.member.entity.Member;
import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=false)
public class News extends TimeEntity implements Auditable<News> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5599236497070947983L;

	@NotNull
	private String title;
	
	@Column(insertable=false,updatable=false,nullable=false ,length=6000)
	@NotNull
	private String content;
	/**
	 * 发布日期
	 * @return
	 */
	private Date pubDate;
	
	
	@Column(insertable=false,updatable=false,nullable=true)
	private Long memberId;
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name="memberId")
	@NotNull
	private Member member;
	
	@Override
	public String getEntityName() {
		return "新闻";
	}

	@Override
	public String getIdStr() {
		return id.toString();
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public News getOrig() {
		return null;
	}

	@Override
	public void setOrig(News paramT) {
		
	}

}
