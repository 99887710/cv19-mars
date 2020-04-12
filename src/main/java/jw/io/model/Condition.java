package jw.io.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Condition {
    private boolean type2Diabetes;
    private boolean type1Diabetes;
    private boolean hypertension;
    private boolean coronaryHeartDiseases;
    private boolean copd;
    private boolean cancer;
    private boolean chronicKidneyDisease;
    private String other;


}
