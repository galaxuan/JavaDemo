package com.example.entity;

import java.util.List;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-11-15 17:29
 */
public class Team {

    private Integer id;

    private String teamName;

    private List<String> honors;

    private List<User> teamMembers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getHonors() {
        return honors;
    }

    public void setHonors(List<String> honors) {
        this.honors = honors;
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", honors=" + honors +
                ", teamMembers=" + teamMembers +
                '}';
    }
}