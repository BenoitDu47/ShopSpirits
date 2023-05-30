package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.NonNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String name;
	@NonNull
	private String brand;
	@NonNull
	private String description;
	@NonNull
	private double price;
	@NonNull
	private int quantity;

	@ManyToOne
	private Category category;

}
