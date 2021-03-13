package ku.ac.th.exam.newcar.services;

import ku.ac.th.exam.newcar.data.CarRepository;
import ku.ac.th.exam.newcar.model.Car;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarService {

    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }


    public void createCar(Car car) {
        String hashPin = hash(car.getPin());
        car.setPin(hashPin);
        repository.save(car);
    }

    public List<Car> getCar() {
        return repository.findAll();
    }

    public Car findCar(int id) {

        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }

    }
    public Car checkPin(Car inputCar) {
        Car storedCar = findCar(inputCar.getId());


        if (storedCar != null) {
            String hashPin = storedCar.getPin();

            if (BCrypt.checkpw(inputCar.getPin(), hashPin))
                return storedCar;
        }
        return null;
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}