package com.blog.product.entity;

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
public class ProductType extends TimeEntity implements Auditable<ProductType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416174783573722497L;

	@Column(nullable = false, length = 64)
	private String name;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private ProductType parent;
	
	@Column(insertable=false,updatable=false,nullable=true)
	private Long parentId;
	
	@OneToMany(mappedBy="parent",fetch=FetchType.LAZY)
	@OrderBy("seqNum")
	private Set<ProductType> children;
	
	/**
	 * 序号，同一父节点下，各子节点按照seqNum从小到大顺序排列
	 */
	private int seqNum;
	
	@NotNull
	@Column(nullable = false)
	private boolean removed = false;
	
	public String getEntityName() {
		return "商品类别";
	}

	public String getIdStr() {
		return id.toString();
	}

	public String getName() {
		return null;
	}

	public ProductType getOrig() {
		return null;
	}

	public void setOrig(ProductType paramT) {
		
	}

}
