package collective.com.theeCollective.controller;

import collective.com.theeCollective.dto.ArticleDto;
import collective.com.theeCollective.dto.AuthorDto;
import collective.com.theeCollective.model.Article;
import collective.com.theeCollective.model.Author;
import collective.com.theeCollective.service.ArticleService;
import collective.com.theeCollective.service.AuthorService;
import collective.com.theeCollective.service.DatabasePDFService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    private ArticleService articleService;
    private AuthorService authorService;

    @Autowired
    public AdminController(ArticleService articleService, AuthorService authorService) {
        this.articleService = articleService;
        this.authorService = authorService;
    }


    @GetMapping("/Admin")
    public String adminPage(Model model){
        List<ArticleDto> articles = articleService.findAllArticles();
        model.addAttribute("articles", articles);
        return "Article";
    }

    @GetMapping("/articles/search")
    public String searchArticle(@RequestParam(value = "query") String query, Model model){
        List<ArticleDto> articles = articleService.searchArticles(query);
        model.addAttribute("articles", articles);
        return "Article";
    }

    @GetMapping("/articles/{articleId}/edit")
    public String editArticle(@PathVariable("articleId") long articleId, Model model){
        ArticleDto article = articleService.findById(articleId);
        List<AuthorDto> authors = authorService.findAllAuthor();
        model.addAttribute("authors", authors);
        model.addAttribute("article", article);
        return "edit-article";
    }

    @PostMapping("/articles/{articleId}/edit")
    public String updateArticle(@PathVariable("articleId") long articleId, Model model,
                                @Valid @ModelAttribute("article") ArticleDto article,
                                BindingResult result
                                ){
        if(result.hasErrors()){
            List<AuthorDto> authors = authorService.findAllAuthor();
            model.addAttribute("authors", authors);
            return "edit-article";
        }
        article.setArticleId((int) articleId);
        articleService.updateArticle(article);
        return "redirect:/Admin";
    }

    @GetMapping ("/newArticle")
    public String createArticle(Model model){
        Article article = new Article();
        List<AuthorDto> authors = authorService.findAllAuthor();
        model.addAttribute("article", article);
        model.addAttribute("authors", authors);
        return "new-article";
    }

    @PostMapping ("/newArticle")
    public String submitNewArticle(@ModelAttribute("article") Article article){
        articleService.saveArticle(article);
        return "redirect:/Admin";
    }

    @GetMapping("article/{articleId}")
    public String articleDetail(@PathVariable("articleId") long articleId, Model model){
        ArticleDto articleDto = articleService.findById(articleId);
        model.addAttribute("article", articleDto);
        return "article-detail";
    }

    @GetMapping("/articles/{articleId}/delete")
    public String deleteArticle(@PathVariable("articleId") Long articleId){
        articleService.delete(articleId);
        return "redirect:/Admin";
    }

    @GetMapping(value = "/openPdf/articleReport", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> articleReport() throws IOException{
        List<ArticleDto> articles = articleService.findAllArticles();
        ByteArrayInputStream bis = DatabasePDFService.articlePDFReport(articles);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=article.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
