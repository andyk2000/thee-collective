package collective.com.theeCollective.service;

import collective.com.theeCollective.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAllComment();
}
