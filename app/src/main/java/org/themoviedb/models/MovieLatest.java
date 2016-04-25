
package org.themoviedb.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class MovieLatest {

    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private Object backdropPath;
    @SerializedName("belongs_to_collection")
    @Expose
    private Object belongsToCollection;
    @SerializedName("budget")
    @Expose
    private Integer budget;
    @SerializedName("genres")
    @Expose
    private List<Object> genres = new ArrayList<Object>();
    @SerializedName("homepage")
    @Expose
    private Object homepage;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    private Object overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private Object posterPath;
    @SerializedName("production_companies")
    @Expose
    private List<Object> productionCompanies = new ArrayList<Object>();
    @SerializedName("production_countries")
    @Expose
    private List<Object> productionCountries = new ArrayList<Object>();
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("revenue")
    @Expose
    private Integer revenue;
    @SerializedName("runtime")
    @Expose
    private Object runtime;
    @SerializedName("spoken_languages")
    @Expose
    private List<Object> spokenLanguages = new ArrayList<Object>();
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tagline")
    @Expose
    private Object tagline;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    /**
     * 
     * @return
     *     The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     * 
     * @param adult
     *     The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     * 
     * @return
     *     The backdropPath
     */
    public Object getBackdropPath() {
        return backdropPath;
    }

    /**
     * 
     * @param backdropPath
     *     The backdrop_path
     */
    public void setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
    }

    /**
     * 
     * @return
     *     The belongsToCollection
     */
    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    /**
     * 
     * @param belongsToCollection
     *     The belongs_to_collection
     */
    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    /**
     * 
     * @return
     *     The budget
     */
    public Integer getBudget() {
        return budget;
    }

    /**
     * 
     * @param budget
     *     The budget
     */
    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    /**
     * 
     * @return
     *     The genres
     */
    public List<Object> getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     *     The genres
     */
    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

    /**
     * 
     * @return
     *     The homepage
     */
    public Object getHomepage() {
        return homepage;
    }

    /**
     * 
     * @param homepage
     *     The homepage
     */
    public void setHomepage(Object homepage) {
        this.homepage = homepage;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The imdbId
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * 
     * @param imdbId
     *     The imdb_id
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * 
     * @return
     *     The originalLanguage
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     * 
     * @param originalLanguage
     *     The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * 
     * @return
     *     The originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * 
     * @param originalTitle
     *     The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * 
     * @return
     *     The overview
     */
    public Object getOverview() {
        return overview;
    }

    /**
     * 
     * @param overview
     *     The overview
     */
    public void setOverview(Object overview) {
        this.overview = overview;
    }

    /**
     * 
     * @return
     *     The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     * 
     * @param popularity
     *     The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     * 
     * @return
     *     The posterPath
     */
    public Object getPosterPath() {
        return posterPath;
    }

    /**
     * 
     * @param posterPath
     *     The poster_path
     */
    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * 
     * @return
     *     The productionCompanies
     */
    public List<Object> getProductionCompanies() {
        return productionCompanies;
    }

    /**
     * 
     * @param productionCompanies
     *     The production_companies
     */
    public void setProductionCompanies(List<Object> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    /**
     * 
     * @return
     *     The productionCountries
     */
    public List<Object> getProductionCountries() {
        return productionCountries;
    }

    /**
     * 
     * @param productionCountries
     *     The production_countries
     */
    public void setProductionCountries(List<Object> productionCountries) {
        this.productionCountries = productionCountries;
    }

    /**
     * 
     * @return
     *     The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate
     *     The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return
     *     The revenue
     */
    public Integer getRevenue() {
        return revenue;
    }

    /**
     * 
     * @param revenue
     *     The revenue
     */
    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    /**
     * 
     * @return
     *     The runtime
     */
    public Object getRuntime() {
        return runtime;
    }

    /**
     * 
     * @param runtime
     *     The runtime
     */
    public void setRuntime(Object runtime) {
        this.runtime = runtime;
    }

    /**
     * 
     * @return
     *     The spokenLanguages
     */
    public List<Object> getSpokenLanguages() {
        return spokenLanguages;
    }

    /**
     * 
     * @param spokenLanguages
     *     The spoken_languages
     */
    public void setSpokenLanguages(List<Object> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The tagline
     */
    public Object getTagline() {
        return tagline;
    }

    /**
     * 
     * @param tagline
     *     The tagline
     */
    public void setTagline(Object tagline) {
        this.tagline = tagline;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The video
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     * 
     * @param video
     *     The video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     * 
     * @return
     *     The voteAverage
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     * 
     * @param voteAverage
     *     The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     * 
     * @return
     *     The voteCount
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * 
     * @param voteCount
     *     The vote_count
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

}
