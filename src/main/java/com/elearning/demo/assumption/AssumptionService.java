package com.elearning.demo.assumption;

import java.util.List;

public interface AssumptionService {
    List<Assumption> findAllAssumption();
    Assumption saveAssumption(Assumption assumption);
    Assumption findAssumptionById(Long id);
    void removeAssumption(Long id);
}
