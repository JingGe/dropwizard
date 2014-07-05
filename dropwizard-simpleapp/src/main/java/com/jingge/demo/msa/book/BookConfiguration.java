package com.jingge.demo.msa.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

/**
 * Created with IntelliJ IDEA.
 * User: jing.ge
 * Date: 01.07.14
 * Time: 09:41
 * To change this template use File | Settings | File Templates.
 */
public class BookConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String team;

    @JsonProperty
    @Max(5)
    private int teamSize;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize() {

        return teamSize;
    }
}
