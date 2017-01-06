package hibernate.criteria.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@Column
	@GeneratedValue
	private long id;

	@Column(name = "chvHomNumber")
	private String homeno;

	@Column(name = "chvRoad")
	private String road;

	@Column(name = "chvProvince")
	private String province;

	@Column(name = "chvZipCode")
	private String zipcode;

	@ManyToOne
	@JoinColumn(name = "adcustid")
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address(){
		
	}
	
	public Address(String homeno, String road, String province, String zipcode){
		this.homeno = homeno;
		this.road = road;
		this.province = province;
		this.zipcode = zipcode;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getHomeno() {
		return homeno;
	}

	public void setHomeno(String homeno) {
		this.homeno = homeno;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	
	
}
