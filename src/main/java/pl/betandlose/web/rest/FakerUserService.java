package pl.betandlose.web.rest;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FakerUserService {
    private ArrayList<JSONObject> fakeUsers = new ArrayList<>();


    public void regenerate() throws JSONException {
        Faker faker = new Faker();
        fakeUsers.clear();
        for (int i = 0; i < 20; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("id", faker.number().numberBetween(1,10000) );
            oJsonInner.put("firstName", faker.name().firstName() );
            oJsonInner.put("lastName", faker.name().lastName() );
            oJsonInner.put("streetAddress", faker.address().streetAddress() );
            oJsonInner.put("cityAddress", faker.address().city() );
            oJsonInner.put("email", faker.internet().emailAddress() );
            oJsonInner.put("phone", faker.phoneNumber().cellPhone() );

            fakeUsers.add(oJsonInner);
        }
    }

    FakerUserService() throws JSONException{
        this.regenerate();
    }
    public ArrayList<JSONObject> getFakeUsers() {
        return fakeUsers;
    }


}