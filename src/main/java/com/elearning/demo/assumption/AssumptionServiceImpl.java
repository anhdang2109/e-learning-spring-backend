package com.elearning.demo.assumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssumptionServiceImpl implements AssumptionService{
    @Autowired
    AssumptionRepository assumptionRepository;

    @Override
    public List<Assumption> findAllAssumption() {
        return assumptionRepository.findAll();
    }

    @Override
    public Assumption saveAssumption(Assumption assumption) {
        return assumptionRepository.save(assumption);
    }

    @Override
    public Assumption findAssumptionById(Long id) {
        return assumptionRepository.findById(id).orElse(null);
    }

    @Override
    public void removeAssumption(Long id) {
        assumptionRepository.deleteById(id);
    }

}
