package com.atipera.repolister.data;

import lombok.Data;

@Data
public class Repo {
    private String name;
    private Owner owner;
    private boolean fork;
}
