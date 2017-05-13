package com.cinema.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents comment for film.
 */
@XmlRootElement
public class Comment {

    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
