package org.model;

import javax.persistence.*;

/**
 * User: asus
 * Date: 11/20/12
 * Time: 2:34 AM
 */
@Entity
@Table(name = "tweets")
public class Tweets {
    @Column(name = "text", nullable = false)
    private String text;

    @Id
	@Column(name = "id")
    private Long id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "Posted " + text + " at " + id;
    }
}
