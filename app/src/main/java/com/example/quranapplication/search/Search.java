package com.example.quranapplication.search;
import java.util.List;
import com.google.gson.annotations.SerializedName;

    public class Search {

        @SerializedName("query")
        private String query;
        @SerializedName("total_results")
        private Integer totalResults;
        @SerializedName("total_pages")
        private Integer totalPages;

        @SerializedName("results")
        private List<Result> results = null;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

}
