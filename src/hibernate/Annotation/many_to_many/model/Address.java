package hibernate.Annotation.many_to_many.model;

import javax.persistence.*;
import java.util.Set;

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


	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="CustAddr",
			joinColumns=@JoinColumn(name="addr_id"),
			inverseJoinColumns=@JoinColumn(name="cust_id") )
	private Set<Customer> customer;

	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Set<Customer> customer) {
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
