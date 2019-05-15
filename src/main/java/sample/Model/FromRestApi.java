package sample.Model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
/**
 Az Absztract tartalmazza a restapi és a json allomany olvasasahoz szukseges deklaráciokat és metodusokat
 **/
public abstract class FromRestApi{
    /**
     Az adatbázis inicializálásához szükséges deklarációk
     **/
    private final static String key = "66fc619035ebc9c1342b883c44cdbef6a153e54267719d244e138df56601c53f";
    private final static String url="https://apifootball.com/api/?action=get_standings&league_id=62&APIkey=";
    private final static String localurl="ez.json";

    private static String inputLine;
    private static StringBuffer response = new StringBuffer();

    private static JSONParser x =new JSONParser();

    public static org.json.simple.JSONArray jsonArray = null;
    public static JSONArray arrs;

    /**
     Az adatbázis inicializálásához szükséges metódusok
     **/
    /**
     A Restapihoz
     **/
    public  static void  readApi() throws IOException {
        URL obj = new URL(url.concat(key));//exception ha nem jó az ur
         HttpURLConnection con=(HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        while ((inputLine = in .readLine()) != null) {
            System.out.println(inputLine);
            response.append(inputLine);
        } in .close();

    }
    public static void makeJsonArray(){
        arrs = new JSONArray(response.toString());
        /*for (int i=0; i<arrs.length();++i){
            System.out.println(arrs.get(i));
        }*/

    }
    public static List<JSONObject> makeJsonObjects(JSONArray x){
        System.out.println("-----------------------------------------------------------------------------------------------");
        List<JSONObject> orszagok=new ArrayList<>();
        for (int i=0; i<x.length(); ++i){
            orszagok.add((JSONObject) x.get(i));
        }
      /* for (int i=0; i<orszagok.size();++i){
            System.out.println(orszagok.get(i)+"\n");
        }*/
        return orszagok;
    }

    /**
     A Lokális Json fájlhoz
     **/
    public static void readJson(){
        try{
            Object obj =x.parse(new FileReader(localurl));
            jsonArray=(org.json.simple.JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<org.json.simple.JSONObject> makeJsonObjectFromFile(org.json.simple.JSONArray x){
        System.out.println(".. .. .. .. .. .. ..\n.. .. .. .. .. .. ..\n.. .. .. .. .. ..");
        ArrayList<org.json.simple.JSONObject> c=new ArrayList<>();
        for (int i=0; i<x.size(); i++){
            System.out.println("\n\n"+x.get(i));
            c.add((org.json.simple.JSONObject) x.get(i));
        }
        return c;
    }

}
