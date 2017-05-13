package com.cinema.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents usual movie.
 */
@XmlRootElement
public class Film {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
