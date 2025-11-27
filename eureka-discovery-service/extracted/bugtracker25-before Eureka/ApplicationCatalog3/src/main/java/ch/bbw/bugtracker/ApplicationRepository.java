package ch.bbw.bugtracker;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@Repository
@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
