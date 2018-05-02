package pl.betandlose.web.rest;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FakerCountryService {

    private ArrayList<JSONObject> countries = new ArrayList<>();


    public void regenerateCountry() throws JSONException {
        Faker faker = new Faker();
        countries.clear();
        for (int i = 0; i < 30; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("country", faker.address().country());
            countries.add(oJsonInner);
        }
    }

    FakerCountryService() throws JSONException{
        this.regenerateCountry();
    }

    public ArrayList<JSONObject> getCountries() {
        return countries;
    }
}
