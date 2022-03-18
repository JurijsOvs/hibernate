package relations;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = " yearOfBirth")
    private int yearOfBirts;

    @ManyToMany
    @JoinTable(name = "authors_to_books",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "books_id", referencedColumnName = "id"))
   private List<Book> books;

    public Author() {
    }

    public Author(String name, String lastName, int yearOfBirts, List<Book> books) {
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirts = yearOfBirts;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getYearOfBirts() {
        return yearOfBirts;
    }

    public Author setYearOfBirts(int yearOfBirts) {
        this.yearOfBirts = yearOfBirts;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Author setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
