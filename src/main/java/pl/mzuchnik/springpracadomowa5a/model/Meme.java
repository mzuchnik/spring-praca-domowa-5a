package pl.mzuchnik.springpracadomowa5a.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "postLink",
        "subreddit",
        "title",
        "url"
})
public class Meme {

    @JsonProperty("postLink")
    private String postLink;
    @JsonProperty("subreddit")
    private String subreddit;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("postLink")
    public String getPostLink() {
        return postLink;
    }

    @JsonProperty("postLink")
    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    @JsonProperty("subreddit")
    public String getSubreddit() {
        return subreddit;
    }

    @JsonProperty("subreddit")
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Meme{" +
                "postLink='" + postLink + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}