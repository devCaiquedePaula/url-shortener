package dev.url.UrlShortener.Links;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlLong;
    private String urlShortener;
    private String urlQrCode;
    private LocalDateTime urlCreatedIn;

    public Link(Long id, String urlLong, String urlShortener, String urlQrCode, LocalDateTime urlCreatedIn) {
        this.id = id;
        this.urlLong = urlLong;
        this.urlShortener = urlShortener;
        this.urlQrCode = urlQrCode;
        this.urlCreatedIn = urlCreatedIn;
    }

    public Link(Long id) {
        this.id = id;
    }

    public Link() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlShortener() {
        return urlShortener;
    }

    public void setUrlShortener(String urlShortener) {
        this.urlShortener = urlShortener;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getUrlCreatedIn() {
        return urlCreatedIn;
    }

    public void setUrlCreatedIn(LocalDateTime urlCreatedIn) {
        this.urlCreatedIn = urlCreatedIn;
    }
}
