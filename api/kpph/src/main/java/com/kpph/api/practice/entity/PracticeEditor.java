package com.kpph.api.practice.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PracticeEditor {

    private final Integer practiceIntegerData;
    private final String practiceTextData;
    private final String practiceLongTextData;

    @Builder
    public PracticeEditor(Integer practiceIntegerData, String practiceTextData, String practiceLongTextData) {
        this.practiceIntegerData = practiceIntegerData;
        this.practiceTextData = practiceTextData;
        this.practiceLongTextData = practiceLongTextData;
    }
}
