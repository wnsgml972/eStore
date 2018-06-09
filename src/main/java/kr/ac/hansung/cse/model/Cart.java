package kr.ac.hansung.cse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Cart implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7383420736137539222L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	private double grandTotal;
}


//Cart Serialization  : Object -> JSON
//원래는 byte로 변환하는데 interface로 받은 부분을 직접 구현하여 json format으로 바꿈
