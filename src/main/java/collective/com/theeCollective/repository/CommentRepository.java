package collective.com.theeCollective.repository;

import collective.com.theeCollective.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
