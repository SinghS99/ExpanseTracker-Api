package in.sandeep.expanseApi.Entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tbl_expanses")
public class Expanse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Column(name="expanse_name")
	@NotBlank(message="expanse name must not be null")
	@Size(min=3, message="Expanse name must be atleast 3 charcter")
	 private String name;
	
	
	 private String description;
	 
	 @Column(name="expanse_amount")
	 @NotNull(message="expanse amount must not be null")
	 private BigDecimal amount;
	 
	 @NotBlank(message="expanse category must not be null")
	 @Column(name="category")
	 private String category;
	 @NotNull(message="expanse date must not be null")
	 private Date date;
	 
	 @Column(name="created_at",nullable=false,updatable=false)
	 @CreationTimestamp
	 private Timestamp createdAt;
	 
	 @Column(name="updated_at")
	 @UpdateTimestamp
	 private Timestamp updatedAt;
	 
	 
	 
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public Expanse() {
		super();
	}
	
	
	public Expanse(Long id, String name, String description, BigDecimal amount, String category, Date date,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Expanse [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
				+ ", category=" + category + ", date=" + date + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	 
	 

}
