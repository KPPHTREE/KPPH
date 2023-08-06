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
    private String practiceTextData;
    private String practiceLongTextData;

    @Builder
    public PracticeCreate(Integer practiceIntegerData, String practiceTextData, String practiceLongTextData) {
        this.practiceIntegerData = practiceIntegerData;
        this.practiceTextData = practiceTextData;
        this.practiceLongTextData = practiceLongTextData;
    }
}
