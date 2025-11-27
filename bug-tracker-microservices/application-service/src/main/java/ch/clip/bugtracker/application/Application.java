package ch.clip.bugtracker.application;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "app")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "app_id")
    private Integer id;

    @Column(name = "app_name", nullable = false)
    private String name;

    @Column(length = 2000, nullable = false)
    private String description;

    @Column(name = "owner_id")
    private Integer ownerId;

    public Application(String name, Integer ownerId, String description) {
        this.name = name;
        this.ownerId = ownerId;
        this.description = description;
    }
}
