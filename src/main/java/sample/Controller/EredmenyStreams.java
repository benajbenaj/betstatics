package sample.Controller;


import sample.Model.EnityClasses.Meccsek;

import java.util.List;

public interface EredmenyStreams {
    public String nevAmireKattintott(String radio);
    public Double tavaszimeccseinekatlaga(String s);
    public long hanyMeccsetJatszottTavasszal(String s);

}
