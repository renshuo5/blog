package com.blog.favorites.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.blog.member.entity.Member;
import com.blog.product.entity.Product;
import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;


@Entity
@Table(indexes = { @Index(columnList = "memberId"),
		@Index(columnList = "productId") })
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductFavorites extends TimeEntity implements Auditable<ProductFavorites>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008543726603080854L;
	
	
	@Column(insertable=false,updatable=false,nullable=false)
	private Long memberId;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="member_id",nullable=false)
	private Member member;
	
	@Column(insertable=false,updatable=false,nullable=false)
	private Long productId;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="product_id",nullable=false)
	private Product product;
	
	private boolean active;
	
	private boolean removed;
	
	
	

	public String getEntityName() {
		return null;
	}

	public String getIdStr() {
		return null;
	}

	public String getName() {
		return null;
	}

	public ProductFavorites getOrig() {
		return null;
	}

	public void setOrig(ProductFavorites paramT) {
		
	}

}
