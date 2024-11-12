package com.langgomsport.langgomsport.models;

import lombok.*;

@Data
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    //properties
    private int page;
    private int perPage;
    private int totalPages;
    private int totalItems;

}
