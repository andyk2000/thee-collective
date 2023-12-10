package collective.com.theeCollective.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LikeS")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    private int articleId;
    private int customerId;
}
