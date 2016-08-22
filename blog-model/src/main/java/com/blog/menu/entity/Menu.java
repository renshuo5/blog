package com.blog.menu.entity;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;


@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=false)
public class Menu extends TimeEntity implements Auditable<Menu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2026984039439924209L;

	
	private String name;
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private Menu parent;
	
	@Column(insertable=false,updatable=false,nullable=true)
	private Long parentId;
	
	@OneToMany(mappedBy="parentId",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@OrderBy("seqNum")
	private Set<Menu> children;
	
	private Integer seqNum;
	
	@Override
	public String getEntityName() {
		return "菜单";
	}

	@Override
	public String getIdStr() {
		return id.toString();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Menu getOrig() {
		return null;
	}

	@Override
	public void setOrig(Menu paramT) {
		
	}

}
