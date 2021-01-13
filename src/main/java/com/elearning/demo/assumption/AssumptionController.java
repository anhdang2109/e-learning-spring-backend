package com.elearning.demo.assumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssumptionController {
    @Autowired
    AssumptionService assumptionService;

    @GetMapping("/admin/assumptions")
    public List<Assumption> assumptionList() {
        return assumptionService.findAllAssumption();
    }

    @GetMapping("/admin/assumptions/{id}")
    public Assumption findAssumptionById(@PathVariable(value = "id") Long id) {
        return assumptionService.findAssumptionById(id);
    }

    @PostMapping("/admin/assumptions")
    public Assumption saveAssumption(@RequestBody Assumption assumption) {
        return assumptionService.saveAssumption(assumption);
    }

    @PutMapping("/admin/assumptions")
    public Assumption updateAssumption(@RequestBody Assumption assumption) {
        return assumptionService.saveAssumption(assumption);
    }

    @DeleteMapping("/admin/assumptions/{id}")
    public void deleteAssumption(@PathVariable(value = "id") Long id) {
        assumptionService.removeAssumption(id);
    }
}
