package org.sample.controller.pojos;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateTeam {


    private Long id;
    private String teamName;
    private Date date;

    @NotNull

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public void setDate()
    {
    	this.date = new Date();
    }
    
    public Date getDate() {
    	return this.date;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
