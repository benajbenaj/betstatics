package sample.Model.EnityClasses;

import jpa.GenericJpaDao;

public class OrszagDao extends GenericJpaDao<Orszag>
{
    public  OrszagDao(){
        super(Orszag.class);
    }
}
