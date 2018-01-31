package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailPK implements Serializable {

    private Long orderId;
    private Long productId;
}
