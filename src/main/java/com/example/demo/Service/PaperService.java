package com.example.demo.Service;

import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;

public interface PaperService {

    PageResponseDto<PaperResponseDto> getPaperList(PaperRequestDto paperRequestDto);
}
