package com.langgomsport.langgomsport.models;

public class Pagination {
    //properties
    private int page;
    private int perPage;
    private int totalPages;
    private int totalItems;

    //getter & setter

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    //constructor

    public Pagination(int page, int perPage, int totalPages, int totalItems) {
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }

    public Pagination() {
    }
}
