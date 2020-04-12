package jw.io.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Case {
    private String userName;
    private String userEmail;
    private int age;
    private String gender;
    private boolean isSmoker;
    private Condition condition;
    private SelfScreening selfScreening;
}
