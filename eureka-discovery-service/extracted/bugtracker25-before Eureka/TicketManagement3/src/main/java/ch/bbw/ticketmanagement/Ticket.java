package ch.bbw.ticketmanagement;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_id")
    private Integer id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String description;

    @Column(nullable = false)
    private Integer applicationId;

    @Column(nullable = false)
    private Integer personId;



    public Ticket(String title, String description, Integer application_id, Integer person_id) {
        this.title = title;
        this.description = description;
        this.applicationId = application_id;
        this.personId = person_id;
    }

}
