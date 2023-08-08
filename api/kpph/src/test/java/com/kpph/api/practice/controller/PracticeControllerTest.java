package com.kpph.api.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpph.api.practice.entity.Practice;
import com.kpph.api.practice.repository.PracticeRepository;
import com.kpph.api.practice.request.PracticeCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "treeLetter.com", uriPort = 443)
class PracticeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PracticeRepository practiceRepository;

    //    @BeforeEach
//    void clean() {
//        practiceRepository.deleteAll();
//    }
    @Test
    void insert() throws Exception {
        PracticeCreate practiceCreate = PracticeCreate.builder()
                .practiceIntegerData(123)
                .practiceTextData("string")
                .practiceLongTextData("longString")
                .build();

        String json = objectMapper.writeValueAsString(practiceCreate);

        mockMvc.perform(post("/api/practice")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(document("practice-create",
                                    requestFields(
                                            fieldWithPath("practiceIntegerData").description("인트형 데이터"),
                                            fieldWithPath("practiceLongTextData").description("롱텍스트 데이터"),
                                            fieldWithPath("practiceTextData").description("텍스트 데이터")
                                    )));
    }


}