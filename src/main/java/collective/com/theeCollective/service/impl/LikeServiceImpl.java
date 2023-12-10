package collective.com.theeCollective.service.impl;

import collective.com.theeCollective.dto.LikeDto;
import collective.com.theeCollective.model.Like;
import collective.com.theeCollective.repository.LikeRepository;
import collective.com.theeCollective.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public List<LikeDto> findAllLike() {
        List<Like> likes = likeRepository.findAll();
        return likes.stream().map((like) -> mapToLikeDto(like)).collect(Collectors.toList());
    }

    private LikeDto mapToLikeDto(Like like){
        LikeDto likeDto = LikeDto.builder()
                .likeId(like.getLikeId())
                .articleId(like.getArticleId())
                .customerId(like.getCustomerId())
                .build();
        return likeDto;
    }
}
