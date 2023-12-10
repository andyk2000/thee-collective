package collective.com.theeCollective.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;
    private String title;
    @Lob
    private String summary;
    @Lob
    @Column(length = 8000)
    private String content;
    private String authorName;
    private String category;
    @CreationTimestamp
    private LocalDate uploadedon;
    private String coverUrl;
    private int views;
}
