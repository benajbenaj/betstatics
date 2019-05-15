package sample.Model.EnityClasses;

import jpa.GenericJpaDao;

public class MeccsekDao extends GenericJpaDao<Meccsek> {
    public  MeccsekDao(){
        super(Meccsek.class);
    }

}
