/*package kr.ac.hansung.cse.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int id;	
	
	@NotEmpty(message="The category name must not be null")
	private String name;
	
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>();
}*/