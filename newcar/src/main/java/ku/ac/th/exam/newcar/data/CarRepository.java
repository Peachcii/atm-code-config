/*
Note : ข้อมูลรถที่มีให้ซื้อ

เพิ่ม interface CarRepository ใน package ที่เพิ่งสร้าง โดยเพิ่ม @Repository ด้วย
คลาสนี้จะเชื่อมกับ Spring JPA เพื่อใช้ในการ select / insert / update / delete สำหรับ car objects

*/

package ku.ac.th.exam.newcar.data;

import ku.ac.th.exam.newcar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findByCarId(int carId);

}

