import Api.Helper;
import Api.NasaPOTD;

public class NasaMain {

    public static void main(String[] args) {
        // When you call the method, in the parameter you must pass your NASA api access key, replace Helper.apiKey with it.
        System.out.println(NasaPOTD.getPOTD(Helper.apiKey));
    }

}
