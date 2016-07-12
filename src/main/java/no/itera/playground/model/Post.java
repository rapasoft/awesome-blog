package no.itera.playground.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Pavol Rajzak, Itera
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;
    private String content;

}
