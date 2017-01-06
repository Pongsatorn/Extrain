package hibernate.Annotation.one_to_many.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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



    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER )
    @JoinColumn(name = "adcustid")
    private Set<Address> addresses;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Customer() {

    }
    public Customer(String firstname, String lastname, int age){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.addresses = new HashSet<Address>(0);
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
