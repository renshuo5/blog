package com.blog.store.entity;

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

import com.blog.member.entity.Member;
import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;

@Entity
@Table(indexes={@Index(columnList = "memberId"),@Index(columnList = "storeTypeId")})
@Data
@EqualsAndHashCode(callSuper=false)
public class Store extends TimeEntity implements Auditable<Store> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493333841372054906L;

	
	private String name;
	
	@Column(insertable = false,updatable=false,nullable=false)
	private Long memberId;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@Column(name="storeType_id",insertable=false,updatable=false,nullable=true)
	private Long storeTypeId;
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name="storeType_id",nullable=false)
	private StoreType storeType;
	
	public String getEntityName() {
		return "店铺";
	}

	public String getIdStr() {
		return null;
	}

	public String getName() {
		return this.name;
	}

	public Store getOrig() {
		return null;
	}

	public void setOrig(Store paramT) {
		
	}

}
