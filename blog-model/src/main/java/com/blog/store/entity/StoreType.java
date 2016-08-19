package com.blog.store.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;


@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=false)
public class StoreType extends TimeEntity implements Auditable<StoreType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3567114775274948367L;
	
	@Column(nullable = false, length = 64)
	private String name;
	
	@Column(insertable=false,updatable=false,nullable=true)
	private Long parentId;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private StoreType parent;
	
	@OneToMany(mappedBy="parent",fetch=FetchType.LAZY)
	@OrderBy("seqNum")
	private Set<StoreType> children;
	
	/**
	 * 序号，同一父节点下，各子节点按照seqNum从小到大顺序排列
	 */
	private int seqNum;
	
	@NotNull
	@Column(nullable = false)
	private boolean removed = false;
	
	public String getEntityName() {
		return "店铺类型";
	}

	public String getIdStr() {
		return id.toString();
	}

	public String getName() {
		return this.name;
	}

	public StoreType getOrig() {
		return null;
	}

	public void setOrig(StoreType paramT) {
		
	}

}
