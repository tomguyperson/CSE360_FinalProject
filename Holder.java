/*
Class that contains each parameter for a row of data.
*/

public class Holder
{
    private int id;
    private String lName;
    private String fName;
    private String vaccine;
    private String date;
    private String location;

    public Holder(int id, String lName, String fName, String vaccine, String date, String location)
    {
        this.id = id;
        this.lName = lName;
        this.fName = fName;
        this.vaccine = vaccine;
        this.date = date;
        this.location = location;
    }

    // converts the parameters into a comma seperated row for the writer
    public String stringConvert()
    {
        String ret = "";

        ret += id;
        ret += ",";
        ret += lName;
        ret += ",";
        ret += fName;
        ret += ",";
        ret += vaccine;
        ret += ",";
        ret += date;
        ret += ",";
        ret += location;

        return ret;
    }

    public int getID()
    {
        return id;
    }

    public String getLastName()
    {
        return lName;
    }

    public String getFirstName()
    {
        return fName;
    }

    public String getVaccine()
    {
        return vaccine;
    }

    public String getDate()
    {
        return date;
    }

    public String getLocation()
    {
        return location;
    }
}