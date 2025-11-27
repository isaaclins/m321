package ch.clip.usermanagement;


import jakarta.persistence.*;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")
    private Integer id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false)
    private String role;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.role = role;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
