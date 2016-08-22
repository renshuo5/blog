package com.blog.news.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

	private String title;
	
	private String content;
	/**
	 * 发布日期
	 * @return
	 */
	private Date pubDate;
	
	
	
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
