package com.kpph.api.practice.service;

import com.kpph.api.practice.entity.Practice;
import com.kpph.api.practice.repository.PracticeRepository;
import com.kpph.api.practice.request.PracticeCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PracticeServiceTest {

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private PracticeRepository practiceRepository;

    @BeforeEach
    void clean() {
        practiceRepository.deleteAll();
    }

    @Test
    @DisplayName("인서트 테스트")
    void insert() {
        PracticeCreate practiceCreate = PracticeCreate.builder()
                .practiceIntegerData(123)
                .practiceTextData("string")
                .practiceLongTextData("longString")
                .build();

        practiceService.insert(practiceCreate);

        assertEquals(1, practiceRepository.count());

        Practice practice = practiceRepository.findAll().get(0);

        assertEquals(123, practice.getPracticeIntegerData());
        assertEquals("string", practice.getPracticeTextData());
        assertEquals("longString", practice.getPracticeLongTextData());
    }

    @Test
    void selectOne() {
    }

    @Test
    void selectList() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}