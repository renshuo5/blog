package com.blog.menu.entity;

import java.util.HashSet;
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
import lombok.ToString;

import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;


@Entity
@Table
@Data
@ToString(exclude = { "parent", "children" })
@EqualsAndHashCode(callSuper=false,exclude = { "parent", "children" })
public class Menu extends TimeEntity implements Auditable<Menu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2026984039439924209L;
	
	@Column(length=64)
	@NotNull
	private String name;
	@Column(length=200)
	private String url;
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private Menu parent;
	
	@Column(insertable=false,updatable=false,nullable=true)
	private Long parentId;
	
	@OneToMany(mappedBy="parentId",cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@OrderBy("seqNum")
	private Set<Menu> children = new HashSet<Menu>();
	
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
