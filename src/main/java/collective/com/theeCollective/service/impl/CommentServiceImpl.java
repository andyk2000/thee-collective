package collective.com.theeCollective.service.impl;

import collective.com.theeCollective.dto.CommentDto;
import collective.com.theeCollective.model.Comment;
import collective.com.theeCollective.repository.CommentRepository;
import collective.com.theeCollective.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> findAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map((comment) -> mapToCommentDto(comment)).collect(Collectors.toList());
    }

    private CommentDto mapToCommentDto(Comment comment){
        CommentDto commentDto = CommentDto.builder()
                .commentId(comment.getCommentId())
                .senderId(comment.getSenderId())
                .articleId(comment.getArticleId())
                .comment(comment.getComment())
                .build();
        return commentDto;
    }
}
