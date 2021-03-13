package ku.ac.th.exam.newcar.controller;

import ku.ac.th.exam.newcar.model.NewCar;
import ku.ac.th.exam.newcar.services.NewCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/newcar")
public class NewCarController {

    private NewCarService newCarService;

    public NewCarController(NewCarService newCarService) {
        this.newCarService = newCarService;
    }

    @GetMapping
    public String getNewCarPage(Model model) {
        model.addAttribute("newcar", newCarService.getNewCar());
        return "newcar";
    }

    @PostMapping
    public String openAccount(@ModelAttribute NewCar newCar, Model model) {
        newCarService.openAccount(newCar);
        model.addAttribute("newcar",newCarService.getNewCar());
        return "redirect:newcar";
    }

    @GetMapping("/edit/{id}")
    public String getEditNewCarPage(@PathVariable int id, Model model) {
        NewCar newCar = newCarService.getNewCar(id);
        model.addAttribute("newcar", newCar);
        return "newcar-edit";
    }

    @PostMapping("/edit/{id}")
    public String editAccount(@PathVariable int id,
                              @ModelAttribute NewCar newCar,
                              Model model) {

        newCarService.editNewCar(newCar);
        model.addAttribute("newcar",newCarService.getNewCar());
        return "redirect:/newcar";
    }

}
