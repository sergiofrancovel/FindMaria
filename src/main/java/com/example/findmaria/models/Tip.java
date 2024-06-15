package com.example.findmaria.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tip {
    private String name;
    private String email;
    private String tip;
    private boolean anonymous;

    public Tip(String name, String email, String tip, boolean anonymous) {
        this.name = name;
        this.email = email;
        this.tip = tip;
        this.anonymous = anonymous;
    }

    public Tip(String name, String email, String tip) {
        this.name = name;
        this.email = email;
        this.tip = tip;
        this.anonymous=false;
    }

    public Tip(boolean anonymous, String tip) {
        this.anonymous = anonymous;
        this.tip = tip;
    }
}