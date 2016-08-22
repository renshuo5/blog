package com.blog.member.entity;

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

import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;


@Entity
@Table(indexes = { @Index(columnList = "memberId")})
@Data
@EqualsAndHashCode(callSuper=false)
public class ReceiptAddr extends TimeEntity implements Auditable<ReceiptAddr> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1270126087797171533L;

	@Column(insertable=false,updatable=false,nullable=false)
	private Long memberId;
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name="memberId",nullable=false)
	private Member member;
	
	private String address;
	
	private boolean defaultAddr;
	
	@Column(nullable = false)
	private boolean active=true;
	
	@Column(nullable = false)
	private boolean removed=false;
	
	
	public String getEntityName() {
		return "收货地址";
	}

	public String getIdStr() {
		return this.id.toString();
	}

	public String getName() {
		return null;
	}

	public ReceiptAddr getOrig() {
		return null;
	}

	public void setOrig(ReceiptAddr paramT) {
		
	}

}
