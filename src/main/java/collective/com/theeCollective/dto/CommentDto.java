package collective.com.theeCollective.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentDto {
    private int commentId;
    private int articleId;
    private int senderId;
    private String comment;
}
