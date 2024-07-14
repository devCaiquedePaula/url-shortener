package dev.url.UrlShortener.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {
    //generate a URL
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }
    //generate a random url
    //TODO: REFACTOR TO INCLUDE PART OF THE ORIGINAL URL IN OUR URL GENERATION ALGORITHM.
    public String generateRandomUrl(){
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Link shortenerUrl(String urlOriginal){
        Link link = new Link();
        link.setUrlLong(urlOriginal);
        link.setUrlShortener(generateRandomUrl());
        link.setUrlCreatedIn(LocalDateTime.now());
        link.setUrlQrCode("QR code currently unavailable");
        return linkRepository.save(link);
    }

    public Link getUrlOriginal(String urlShortener) {
        try {
            return linkRepository.findByUrlOriginal(urlShortener);
        }catch (Exception error){
            throw new RuntimeException("URL does not exist in our records", error);
        }
    }
}
