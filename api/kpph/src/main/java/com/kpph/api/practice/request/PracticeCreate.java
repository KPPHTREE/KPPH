package com.kpph.api.practice.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PracticeCreate {

    private Integer practiceIntegerData;
    private String practiceLongTextData;
    private String practiceTextData;


    @Builder
    public PracticeCreate(Integer practiceIntegerData, String practiceLongTextData, String practiceTextData) {
        this.practiceIntegerData = practiceIntegerData;
        this.practiceLongTextData = practiceLongTextData;
        this.practiceTextData = practiceTextData;

    }
}
