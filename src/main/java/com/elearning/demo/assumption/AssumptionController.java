package com.elearning.demo.assumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/assumptions")
public class AssumptionController {
    @Autowired
    AssumptionService assumptionService;

    @GetMapping
    public List<Assumption> assumptionList() {
        return assumptionService.findAllAssumption();
    }

    @GetMapping("/{id}")
    public Assumption findAssumptionById(@PathVariable(value = "id") Long id) {
        return assumptionService.findAssumptionById(id);
    }

    @PostMapping
    public Assumption saveAssumption(@RequestBody Assumption assumption) {
        return assumptionService.saveAssumption(assumption);
    }

    @PutMapping
    public Assumption updateAssumption(@RequestBody Assumption assumption) {
        return assumptionService.saveAssumption(assumption);
    }

    @DeleteMapping("/{id}")
    public void deleteAssumption(@PathVariable(value = "id") Long id) {
        assumptionService.removeAssumption(id);
    }
}
