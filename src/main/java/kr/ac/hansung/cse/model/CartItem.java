package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Entity
public class CartItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7296960050350583877L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	@JsonIgnore  //Cart에서 cartItems를 통해 이리로 왔을 때 다시 Cart로 들어가면 싸이클이 형성되므로 무시하게 한다.
	private Cart cart;

	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private int quantity;
	
	private double totalPrice;
}
