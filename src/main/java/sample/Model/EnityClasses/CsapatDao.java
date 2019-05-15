package sample.Model.EnityClasses;

import jpa.GenericJpaDao;

public class CsapatDao extends GenericJpaDao<Csapat> {
    public  CsapatDao(){
        super(Csapat.class);
    }

}
