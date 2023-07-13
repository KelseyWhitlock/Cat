package Cat.Blog.model;

import jakarta.persistence.*;

@Entity
@Table(name="cat" , schema="cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcat")
    @Basic
    private int catId;

    @Column(name="color")
    @Basic
    private String color;

    @Column(name="name")
    @Basic
    private String name;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
