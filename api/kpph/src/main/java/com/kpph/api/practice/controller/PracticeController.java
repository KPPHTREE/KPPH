package com.kpph.api.practice.controller;

import com.kpph.api.practice.entity.Practice;
import com.kpph.api.practice.request.PracticeCreate;
import com.kpph.api.practice.request.PracticeRequest;
import com.kpph.api.practice.response.PracticeResponse;
import com.kpph.api.practice.service.PracticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PracticeController {

    private final PracticeService practiceService;

    @PostMapping("/practice")
    public void insert(@RequestBody PracticeCreate practiceCreate) {
        practiceService.insert(practiceCreate);
    }

    @GetMapping("/selectOne")
    public PracticeResponse selectOne() {
      
        return practiceService.selectOne(1);
    }

    @GetMapping("/selectList")
    public List<PracticeResponse> selectList() {
        return practiceService.selectList();
    }

    @GetMapping("/update")
    public void update() {
        PracticeRequest practiceRequest = PracticeRequest.builder()
                .practiceIntegerData(111)
                .practiceTextData("텍스트업데이트데이터")
                .practiceLongTextData("롱텍스트업데이트데이터").build();

        practiceService.update(1, practiceRequest);
    }


    //230806 pjh 삭제 기능 추가
    @GetMapping("/delete/{practiceIdx}")
    public void delete(@PathVariable("practiceIdx") Integer practiceIdx) {
        practiceService.delete(practiceIdx);
    }

    @GetMapping("/delete")
    public void deleteAll() {
        practiceService.deleteAll();
    }

} // end of PracticeController
