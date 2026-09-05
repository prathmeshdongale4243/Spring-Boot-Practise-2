package RamBasePackage.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer Id;
	
	@NotBlank(message="Name is Required")
	String name;
	
	@NotNull(message="Price is Required")
	@DecimalMin(value="0.1",message="price not zero allowed")
	Double price;
	
	@NotNull(message="Quantity is Required")
	@Min(value=1, message="Quantity atleast 1 require")
	Integer quantity;
	
	@NotBlank(message="Category is Required")
	String category;
	
	@NotBlank(message="Description is Required")
	String description;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, @NotBlank(message = "Name is Required") String name,
			@NotNull(message = "Price is Required") @DecimalMin(value = "0.1", message = "price not zero allowed") Double price,
			@NotNull(message = "Quantity is Required") @Min(value = 1, message = "Quantity atleast 1 require") Integer quantity,
			@NotBlank(message = "Category is Required") String category,
			@NotBlank(message = "Description is Required") String description) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.description = description;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + ", description=" + description + "]";
	}

	
}
