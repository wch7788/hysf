package com.example.demo.Service;

import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.paper.NewPaperRequest;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;

import java.util.Map;

public interface PaperService {

    PageResponseDto<PaperResponseDto> getPaperList(PaperRequestDto paperRequestDto);

    Map<String, Object> getPaperInfo(int id);

    boolean addPaper(NewPaperRequest newPaperRequest);

}
