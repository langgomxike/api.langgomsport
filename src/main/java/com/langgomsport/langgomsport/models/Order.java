package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "orders")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(length = 12)
    private String id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "status")
//    private Status status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderVariant> orderVariants;

    @PrePersist
    public void generateID(){
        this.id = UUID.randomUUID().toString().replaceAll("-", "").substring(0,12);
    }

}
