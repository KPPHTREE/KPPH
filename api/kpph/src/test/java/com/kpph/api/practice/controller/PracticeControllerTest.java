package com.kpph.api.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpph.api.practice.repository.PracticeRepository;
import com.kpph.api.practice.request.PracticeCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PracticeControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PracticeRepository practiceRepository;

    @BeforeEach
    void clean() {
        practiceRepository.deleteAll();
    }

    @Test
    void insert() throws Exception {
        PracticeCreate practiceCreate = PracticeCreate.builder()
                .practiceIntegerData(123)
                .practiceTextData("string")
                .practiceLongTextData("longString")
                .build();

        String json = objectMapper.writeValueAsString(practiceCreate);

        mockMvc.perform(post("/practice")
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());
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