package dev.url.UrlShortener.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("url-shortener")
    public ResponseEntity<LinkResponse> generateShortUrl(@RequestBody Map<String, String> request){
        String urlOriginal = request.get("urlOriginal");
        Link link = linkService.shortenerUrl(urlOriginal);

        String generateUserRedirectUrl = "http://localhost:8080/r/" + link.getUrlShortener();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getUrlLong(),
                generateUserRedirectUrl,
                link.getUrlQrCode(),
                link.getUrlCreatedIn()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/r/{shortenerUrl}")
    public void redirectLink(@PathVariable String shortenerUrl, HttpServletResponse response) throws IOException {
        Link link = linkService.getUrlOriginal(shortenerUrl);

        if (link != null){
            response.sendRedirect(link.getUrlLong());
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
