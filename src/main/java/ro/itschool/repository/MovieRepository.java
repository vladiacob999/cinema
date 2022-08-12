package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.entity.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
