package com.atm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    Card card;
    Account account;

    public User(Card card, Account account) {
        this.card = card;
        this.account = account;
    }
}
