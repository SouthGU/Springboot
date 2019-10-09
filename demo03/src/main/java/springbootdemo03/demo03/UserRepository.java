package springbootdemo03.demo03;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String>{

}
