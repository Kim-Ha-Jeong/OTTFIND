package ToyProject.OttFind.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmShort {
    @JsonProperty
    String title;
    @JsonProperty
    String poster_url;

    public FilmShort(String title, String poster_url){
        this.title = title;
        this.poster_url = poster_url;
    }
}
