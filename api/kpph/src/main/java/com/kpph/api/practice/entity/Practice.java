package com.kpph.api.practice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="practice")
@Entity
public class Practice {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("고유번호")
    private Integer practiceIdx;

    @Column
    @Comment("텍스트 숫자")
    private Integer practiceIntegerData;

    @Column(length=300)
    @Comment("텍스트 데이터")
    private String practiceTextData;

    @Lob
    @Comment("Long 텍스트 데이터")
    private String practiceLongTextData;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("인서트시 시간입력 테스트")
    private Date practiceInsertDate;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("업데이트시 시간입력 테스트")
    private Date practiceUpdateDate;

    @Builder
    public Practice(Integer practiceIdx, Integer practiceIntegerData, String practiceTextData, String practiceLongTextData, Date practiceInsertDate, Date practiceUpdateDate) {
        this.practiceIdx = practiceIdx;
        this.practiceIntegerData = practiceIntegerData;
        this.practiceTextData = practiceTextData;
        this.practiceLongTextData = practiceLongTextData;
        this.practiceInsertDate = practiceInsertDate;
        this.practiceUpdateDate = practiceUpdateDate;
    }

    public PracticeEditor.PracticeEditorBuilder toEditor() {
        return PracticeEditor.builder()
                .practiceIntegerData(practiceIntegerData)
                .practiceTextData(practiceTextData)
                .practiceLongTextData(practiceLongTextData);
    }

    public void edit(PracticeEditor practiceEditor) {
        this.practiceIntegerData = practiceEditor.getPracticeIntegerData();
        this.practiceTextData = practiceEditor.getPracticeTextData();
        this.practiceLongTextData = practiceEditor.getPracticeLongTextData();
    }
}
