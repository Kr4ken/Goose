package com.kr4ken.goose.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AddRequest {

    public static enum ResourceType {
       IMAGE,
       VIDEO,
       NOTE;
    }

    public static enum Action {
        ADD,
        DELETE,
        SAVE
    }

    @JsonProperty
    private String url;

    @JsonProperty
    private ResourceType type;

    @JsonProperty
    private Action action ;


}

