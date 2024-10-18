package com.langgomsport.langgomsport.models;

public enum Sort {
    PRICEASC("ASC", "price"),
    PRICEDESC("DESC", "price"),
    DISCOUNTASC("ASC", "discount"),
    DISCOUNTDESC("DESC", "discount"),
    DISCOUNT("ASC", "discount");

    private String sortType;
    private String sortBy;

    private Sort(String sortType, String sortBy) {
        this.sortType = sortType;
        this.sortBy = sortBy;
    }

    public String getSortType() {
        return sortType;
    }

    public String getSortBy() {
        return sortBy;
    }

    // Thêm phương thức để tìm Sort từ chuỗi
    public static Sort fromString(String value) {
        for (Sort sort : Sort.values()) {
            if (sort.name().equalsIgnoreCase(value)) {
                return sort;
            }
        }
        throw new IllegalArgumentException("Invalid sort value: " + value);
    }
}
