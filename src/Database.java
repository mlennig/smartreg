package teamawesome.smartreg;
import java.net.*;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.util.Log;


public class Database {
    int id_user; //id_user returned by the database.
    String page_content;

    Database()
    {
        id_user=0;
        page_content=null;
    }

    void push_user_info(String username, String password, String first_name, String last_name, String email, String country, String state_province, String city, String postal_code, String number_of_floors) {
        String requestedURL = "http://192.222.131.10:80/add_user.php?";
        //parameters have to be encoded, because spaces will crash the request
        //end parameters encoding
        String requestedURLParams=null;
        try {
             requestedURLParams = "username=" + URLEncoder.encode(username,"UTF-8") + "&password=" + URLEncoder.encode(password,"UTF-8") + "&first_name=" + URLEncoder.encode(first_name,"UTF-8") + "&last_name=" + URLEncoder.encode(last_name,"UTF-8") + "&email=" + URLEncoder.encode(email,"UTF-8") + "&country=" + URLEncoder.encode(country,"UTF-8") + "&state=" + URLEncoder.encode(state_province,"UTF-8") + "&city=" + URLEncoder.encode(city,"UTF-8") + "&postal_code=" + URLEncoder.encode(postal_code,"UTF-8") + "&number_of_floors=" + URLEncoder.encode(number_of_floors,"UTF-8");
        }
        catch (IOException e){

        }
       db_connect(requestedURL,requestedURLParams);
        get_last_id_user();
        id_user=Integer.parseInt(page_content);
        Log.i("output",page_content);
    }

    boolean user_login(String username,String password)
    {
        String requestedURL = "http://192.222.131.10:80/login.php?";
        String requestedURLParams=null;
        try
        {
            requestedURLParams = "username=" + URLEncoder.encode(username,"UTF-8") + "&password=" + URLEncoder.encode(password,"UTF-8");
        }
        catch (IOException e)
        {
        }
        db_connect(requestedURL,requestedURLParams);
        if(page_content=="Login successful")
        {
            return true;
        }
        return false;
    }

    void get_id_user(String username)
    {
        String requestedURL = "http://192.222.131.10/get_id_user_from_username.php?";
        //parameters have to be encoded, because spaces will crash the request
        //end parameters encoding
        String requestedURLParams=null;
        try
        {
            requestedURLParams = "username=" + URLEncoder.encode(username,"UTF-8");
        }
        catch (IOException e)
        {

        }
        db_connect(requestedURL,requestedURLParams);
        id_user=Integer.parseInt(page_content);
    }

    private void get_last_id_user()
    {
        String requestedURL = "http://192.222.131.10/get_max_id_user.php?";
        //parameters have to be encoded, because spaces will crash the request
        //end parameters encoding
        String requestedURLParams = null;
        db_connect(requestedURL,requestedURLParams);
        id_user=Integer.parseInt(page_content);
    }

    void db_connect(String requestedURL,String requestedURLParams)

    {
        enableStrictMode();
        String out=null;
        try {

            String aURL = requestedURL+requestedURLParams;
            java.net.URL myURL = new URL(aURL);
            out = new Scanner(new URL(aURL).openStream(), "UTF-8").useDelimiter("\\A").next();
        }
        catch (MalformedURLException e)
        {
            Log.i("catch","test3");
            e.printStackTrace();

        }
        catch (IOException e)
        {
            Log.i("catch","test4");
        }
        page_content=out;

    }




    public void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }




}
