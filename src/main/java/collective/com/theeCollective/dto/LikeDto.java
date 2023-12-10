package collective.com.theeCollective.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LikeDto {
    private int likeId;
    private int articleId;
    private int customerId;
}
