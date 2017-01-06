package hibernate.Annotation.one_to_one.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "chvFirNam" ,length = 50, nullable = false)
    private String firstname;

    @Column(name = "chvLasNam")
    private String lastname;

    @Column(name = "intAge")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id") //if use bidirection
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer() {

    }

    public Customer(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
