package Q2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_info_tbl")
public class BookEntity {
	@Id
	private int id;
	@Column 
	private int cost;
	
	@Column(name = "book_name")
	private String bookName;

	public BookEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public BookEntity(int id, int cost, String bookName) {
		super();
		this.id = id;
		this.cost = cost;
		this.bookName = bookName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
