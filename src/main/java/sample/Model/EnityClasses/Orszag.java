package sample.Model.EnityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Orszag")
public class Orszag {

    @Id
    @Column(name = "country_id")
    public int country_id;
    @Column(name = "country_name")
    public String country_name;
    public  Orszag( String name, int id){
    this.country_id=id;
    this.country_name=name;
}
    public Orszag(){}
    @Override
    public String toString() {
        return "Orszag{" +
                "country_id='" + country_id + '\'' +
                ", country_name=" + country_name +
                '}';
    }
}

