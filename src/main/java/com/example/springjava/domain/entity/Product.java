package com.example.springjava.domain.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.math.BigInteger;

@Data
@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "productos", schema = "public")
public class Product {

    @Id
    @Column(name = "identificador")
    private String id;

    @Column(name = "nombre_producto")
    private String name;

    @Column(name = "valor")
    private BigInteger value;

}
