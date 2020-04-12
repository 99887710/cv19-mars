package jw.io.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelfScreening {
    private boolean testedPositive;
    private Severity dryCough;
    private Severity fever;
    private Severity soreThroat;
    private Severity fatigue;
    private Severity shortnessOfBreadth;
    private Severity lossOfSmell;
    private Severity lossOfTaste;
    private Severity muscleSoreness;
    private String other;
    private Severity otherLevel;

}
