package com.blog.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.blog.store.entity.Store;
import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;

@Entity
@Table(indexes = { @Index(columnList = "name"),
		@Index(columnList = "storeId"),
		@Index(columnList = "productTypeId") })
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends TimeEntity implements Auditable<Product> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3637263601821467773L;
	
	
	private String name;
	
	/**
	 * 描述		
	 */
	private String proDesc;
	
	/**
	 * 商店
	 */
	@Column(insertable=false,updatable=false,nullable=false)
	private Long storeId;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="storeId")
	@NotNull
	private Store store;

	/**
	 * 商品类型
	 */
	@Column(insertable=false,updatable=false,nullable=true)
	private Long productTypeId;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="productTypeId")
	@NotNull
	private ProductType productType;
	
	@Column(nullable = false)
	private boolean active=true;
	
	@Column(nullable = false)
	private boolean removed=false;
	
	public String getEntityName() {
		return null;
	}

	public String getIdStr() {
		return null;
	}

	public String getName() {
		return this.name;
	}

	public Product getOrig() {
		return null;
	}

	public void setOrig(Product paramT) {
		
	}

}
