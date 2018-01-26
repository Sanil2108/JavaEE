import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.type.BasicType;
import org.hibernate.type.BasicTypeRegistry;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name="MOVIES")
@Entity
public class Movie {

    @Table(name="GENRES")
    @Entity
    public static class Genre{
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="GENRE_ID")
        private int id;
        private String name;

        public Genre(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Genre{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            try{
                Genre g=(Genre)o;
                if(this.name.equals(g.name)){
                    return true;
                }
            }catch (ClassCastException e){
                e.printStackTrace();
            }
            return false;
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="MOVIE_ID")
    int id;

    @Column
    String title;
    String director;
    String synopsis;
    @OneToMany
    @JoinColumn
    @JoinTable
    @Cascade(CascadeType.ALL)
    Set<Genre> genres;

    public Movie(){
        genres=new HashSet<Genre>();
    }

    public void addGenre(Genre genre){
        genres.add(genre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        try{
            Movie m=(Movie)o;
            if(m.title.equals(this.title) && m.director.equals(this.director)){
                return true;
            }
            return false;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return false;
    }
}