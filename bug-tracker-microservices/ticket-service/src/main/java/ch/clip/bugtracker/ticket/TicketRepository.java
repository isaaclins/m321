package ch.clip.bugtracker.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByApplicationId(Integer applicationId);

    List<Ticket> findByPersonId(Integer personId);
}
