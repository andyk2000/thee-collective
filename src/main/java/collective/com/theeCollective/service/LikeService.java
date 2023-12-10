package collective.com.theeCollective.service;

import collective.com.theeCollective.dto.LikeDto;

import java.util.List;

public interface LikeService {
    List<LikeDto> findAllLike();
}
