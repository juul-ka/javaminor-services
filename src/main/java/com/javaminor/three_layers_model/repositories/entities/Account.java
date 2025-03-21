package com.javaminor.three_layers_model.repositories.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "account")
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "accountNumber", nullable = false)
    private String accountNumber;

    @Column(name = "iban", nullable = false)
    @Setter(AccessLevel.NONE)
    private String iban;

    @Version
    @Column(name = "version")
    private Date version;

    public void setIban(String accountNumber) {
        this.iban = "NL00TEST" + this.accountNumber;
    }
}

