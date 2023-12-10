package collective.com.theeCollective.service;

import collective.com.theeCollective.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> findAllAuthor();
}
