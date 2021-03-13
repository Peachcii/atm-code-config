package ku.ac.th.exam.newcar.services;

import ku.ac.th.exam.newcar.model.NewCar;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class NewCarService {

    private ArrayList<NewCar> newCarList = new ArrayList<>();

    public void openAccount(NewCar newCar) {
    String url = "http://localhost:8080/api/newcar";

    restTemplate.postForObject(url, newCar, NewCar.class);
}
    public List<NewCar> getNewCar() {
        String url = "http://localhost:8080/api/newcar";

        ResponseEntity<NewCar[]> response =
                restTemplate.getForEntity(url, NewCar[].class);

        NewCar[] newCars = response.getBody();
        return Arrays.asList(newCars);
    }

    public NewCar getNewCar(int id) {
        String url = "http://localhost:8080/api/newcar/" + id;

        ResponseEntity<NewCar> response =
                restTemplate.getForEntity(url, NewCar.class);

        return response.getBody();
    }

    public void editNewCar(NewCar newCar) {
        String url = "http://localhost:8080/api/newcar/" +
                newCar.getId();
        restTemplate.put(url, newCar);
    }


    public NewCar findNewCar(int id) {
        for (NewCar newcar : newCarList) {
            if (newcar.getId() == id)
                return newcar;
        }
        return null;
    }
    
}
