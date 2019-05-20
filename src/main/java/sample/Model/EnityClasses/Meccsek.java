package sample.Model.EnityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Meccsek")
public class Meccsek {
    Meccsek(){};
    @Id
    @Column(name = "match_id")
    private int match_id;
    @Column(name = "match_hometeam_name")
    private String match_hometeam_name;
    @Column(name = "match_awayteam_name")
    private String match_awayteam_name;
    @Column(name = "match_hometeam_score")
    private int match_hometeam_score;
    @Column(name = "match_awayteam_score")
    private int match_awayteam_score;


    public Meccsek(int match_id, String match_hometeam_name, String match_awayteam_name, int match_hometeam_score, int match_awayteam_score) {
        this.match_id = match_id;
        this.match_hometeam_name = match_hometeam_name;
        this.match_awayteam_name = match_awayteam_name;
         this.match_hometeam_score = match_hometeam_score;
       this.match_awayteam_score = match_awayteam_score;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_hometeam_name() {
        return match_hometeam_name;
    }

    public void setMatch_hometeam_name(String match_hometeam_name) {
        this.match_hometeam_name = match_hometeam_name;
    }

    public String getMatch_awayteam_name() {
        return match_awayteam_name;
    }

    public void setMatch_awayteam_name(String match_awayteam_name) {
        this.match_awayteam_name = match_awayteam_name;
    }

    public int getMatch_hometeam_score() {
        return match_hometeam_score;
    }

    public void setMatch_hometeam_score(int match_hometeam_score) {
        this.match_hometeam_score = match_hometeam_score;
    }

    public int getMatch_awayteam_score() {
        return match_awayteam_score;
    }

    public void setMatch_awayteam_score(int match_awayteam_score) {
        this.match_awayteam_score = match_awayteam_score;
    }
}
