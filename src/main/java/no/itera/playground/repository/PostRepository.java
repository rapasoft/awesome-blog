package no.itera.playground.repository;

import no.itera.playground.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Pavol Rajzak, Itera
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
