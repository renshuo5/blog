package com.blog.member.entity;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.model.entity.User;
import com.rensframework.core.entity.Auditable;
import com.rensframework.core.entity.TimeEntity;


@Entity
@Table
@Data
@Cacheable
@EqualsAndHashCode(callSuper = false)
public class Member extends TimeEntity implements Auditable<Member> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3788522595671240904L;

	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	/**
	 *昵称
	 */
	private String nickName;
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 性别 true:1:男 false:0:女
	 */
	private boolean sex;
	
	private Date birthDay;
	
	/**
	 *  星座
	 */
	@Column(nullable=true,length=64)
	@Enumerated(EnumType.STRING)
	private StarSign starSign=StarSign.Aries;
	
	public static enum StarSign{
		Aries("白羊座"),Taurus("金牛座"),Gemini("双子座"),Cancer("巨蟹座"),Leo("狮子座"),Virgo("处女座"),
		Libra("天秤座"),Scorpio("天蝎座"),Sagittarius("射手座"),Capricorn("摩羯座"),Aquarius("水瓶座"),Pisces("双鱼座");
		private String text;
		
		private StarSign(String text){
			this.text = text;
		}
		
		public String getText() {
			return text;
		}
		
		public static Map<String,String> getStarSignMap(){
			Map<String, String> map = new HashMap<String, String>();
			for(StarSign status : StarSign.values()){
				map.put(status.name(), status.getText());
			}
			return map;
		}
	}
	
	private String address;
	
	private Long receiptAddrId;
	private ReceiptAddr receiptAddr;
	
	public String getEntityName() {
		return "会员";
	}

	public String getIdStr() {
		return null;
	}

	public String getName() {
		return null;
	}

	public Member getOrig() {
		return null;
	}

	public void setOrig(Member paramT) {
		// TODO Auto-generated method stub
		
	}

}
