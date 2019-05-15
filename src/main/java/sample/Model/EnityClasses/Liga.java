package sample.Model.EnityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bajnoksag")
public class Liga{

    @Id
    @Column(name = "leage_id")
    private int league_id;
    @Column(name = "league_name")
    private String league_name;

   /* @Column(name = "country_id")
    private int country_id;
    @Column(name = "country_name")
    private String country_name;*/


    public  Liga(int l_id, String l_name, int c_id,String c_name){
        this.league_id=l_id;
        this.league_name=l_name;
       /* this.country_name=c_name;
        this.country_id=c_id;*/

    }


}
