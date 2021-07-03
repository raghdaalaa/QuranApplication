package com.example.quranapplication.VersesModel;


import com.google.gson.annotations.SerializedName;


public class Meta {

    @SerializedName("current_page")

    private Integer currentPage;
    @SerializedName("next_page")

    private Integer nextPage;
    @SerializedName("prev_page")

    private Integer prevPage;
    @SerializedName("total_pages")

    private Integer totalPages;
    @SerializedName("total_count")

    private Integer totalCount;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}