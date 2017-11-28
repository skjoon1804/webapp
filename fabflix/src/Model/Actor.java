package Model;

public class Actor {
    public int id;
    public String name;
    public String dob;
    public String photo_url;

    //    public List<Movie> movie = null;

    public Actor(int i, String fname,String lname, String d, String photo ){
        id = i;
        name = fname + " " + lname;
        dob = d;
        photo_url = photo;
    }
}
