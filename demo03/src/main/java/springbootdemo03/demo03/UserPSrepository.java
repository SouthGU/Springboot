package springbootdemo03.demo03;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPSrepository extends PagingAndSortingRepository<User,String> {

}
