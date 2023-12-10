package collective.com.theeCollective.service.impl;

import collective.com.theeCollective.dto.AuthorDto;
import collective.com.theeCollective.model.Author;
import collective.com.theeCollective.repository.AuthorRepository;
import collective.com.theeCollective.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> findAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map((author) -> mapToAuthorDto(author)).collect(Collectors.toList());
    }

    private AuthorDto mapToAuthorDto(Author author){
        AuthorDto authorDto = AuthorDto.builder()
                .authorId(author.getAuthorId())
                .Names(author.getNames())
                .email(author.getEmail())
                .password(author.getPassword())
                .build();
        return authorDto;
    }

}
