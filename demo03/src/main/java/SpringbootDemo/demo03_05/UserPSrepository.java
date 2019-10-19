package SpringbootDemo.demo03_05;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPSrepository extends PagingAndSortingRepository<User,String> {

}
