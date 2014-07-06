package com.jingge.demo.msa.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

public class BookConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String team;

    @JsonProperty
    @Max(5)
    private int teamSize;

    public int getMinMemory() {
        return minMemory;
    }

    @JsonProperty
    private int minMemory;

    public String getTeam() {
        return team;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
