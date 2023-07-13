package Cat.Blog.model;

import jakarta.persistence.*;

@Entity
@Table(name="cat" , schema="cat")
public class Cat {
    //This will be id for the cat that will come from the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcat")
    @Basic
    private int catId;

    //The color string
    @Column(name="color")
    @Basic
    private String color;

    //The name of the cat
    @Column(name="name")
    @Basic
    private String name;

    //This getting the color of the cat
    public String getColor() {
        return color;
    }

    //This will be setting the color of the cat
    public void setColor(String color) {
        this.color = color;
    }

    //This will be getting the name of the cat
    public String getName() {
        return name;
    }

    //This will be setting the name of the cat
    public void setName(String name) {
        this.name = name;
    }
}
