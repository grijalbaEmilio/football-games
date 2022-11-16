package model;


import java.time.LocalDateTime;

public class Game {

    private Alignment alignment;
    private LocalDateTime time;
    private String city;

    private String rivalTeam;


    public Game(Alignment alignment, LocalDateTime time, String city, String rivalTeam) {
        this.alignment = alignment;
        this.time = time;
        this.city = city;
        this.rivalTeam = rivalTeam;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public LocalDateTime getLocalDateTime() {
        return time;
    }


    public String getCity() {
        return city;
    }

    public String getRivalTeam() {
        return rivalTeam;
    }

    @Override
    public String toString() {
        return "Game{" +
                "alignment=" + alignment +
                ", LocalDateTime=" + time +
                ", city='" + city + '\'' +
                ", rivalTeam='" + rivalTeam + '\'' +
                '}';
    }
}
