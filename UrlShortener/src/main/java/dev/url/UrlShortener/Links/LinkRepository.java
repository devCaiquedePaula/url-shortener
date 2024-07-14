package dev.url.UrlShortener.Links;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findByUrlOriginal(String urlShortener);
}
