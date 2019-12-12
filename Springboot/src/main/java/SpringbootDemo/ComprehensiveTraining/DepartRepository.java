package SpringbootDemo.ComprehensiveTraining;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DepartRepository extends JpaRepository<Depart,Integer> {

}
