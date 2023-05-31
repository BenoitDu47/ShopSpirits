package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.NonNull;


@Entity
@Data
@NoArgsConstructor(force = true)
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
    @Size(min=10,max=200)
	private String description;
	@NonNull
	private double price;
	@NonNull
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "Category is required")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
}
