package ku.ac.th.exam.newcar.controller;

import ku.ac.th.exam.newcar.data.CarRepository;
import ku.ac.th.exam.newcar.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Car> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Car getOne(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @GetMapping("/car/{carId}")
    public List<Car> getAllCarId(@PathVariable int carId) {
        return repository.findByCarId(carId);
    }


    @PostMapping
    public Car create(@RequestBody Car newcar) {
        Car record = repository.save(newcar);
        return record;
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable int id,
                      @RequestBody Car newcar) {
        Car record = repository.findById(id).get();
        record.setPrice(newcar.getPrice());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Car delete(@PathVariable int id) {
        Car record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
