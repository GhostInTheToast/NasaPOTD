package Api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NasaPOTD {

    private static HttpURLConnection connection;
    public static String jsonString = "";
    static String json = "";

    public static String getPOTD(String apiKey) {
        try {
            URL url = new URL("https://api.nasa.gov/planetary/apod" + "?api_key=" + apiKey);
            connection = (HttpURLConnection) url.openConnection();

            // Requesting setup here
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            if (status != 200) {
                System.out.println("Error code: " + status);
            }

            BufferedReader reader;
            StringBuffer content = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            jsonString = content.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String json = jsonString;
        JSONObject obj = new JSONObject(json);
        String explanation = obj.get("explanation").toString();
        String title = obj.get("title").toString();
        String potdContentUrl = obj.get("url").toString();
        return explanation + "\n" + title + "\n" + potdContentUrl;

    }
}
