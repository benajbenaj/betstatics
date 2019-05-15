package sample.Model.EnityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Csapatok")
public class Csapat {


    @Id
    @Column(name="team_name")
    private String team_name;
    public Csapat(String team_name) {
        this.team_name = team_name;
    }


    @Override
    public String toString() {
        return "Csapat{" +
                "team_name='" + team_name + '\'' +
                '}';
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
