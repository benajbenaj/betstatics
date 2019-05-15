package sample.Model.EnityClasses;

import jpa.GenericJpaDao;

public class LigaDao extends GenericJpaDao<Liga>
{
    public  LigaDao(){
        super(Liga.class);
    }
}
