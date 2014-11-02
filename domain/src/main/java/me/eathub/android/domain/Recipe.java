package me.eathub.android.domain;

public class Recipe {

    private int recipeId;
    private String title;
    private String authorName;
    private String coverUrl;


    public Recipe(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override public String toString() {
        return "RecipeModel{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                '}';
    }
}
