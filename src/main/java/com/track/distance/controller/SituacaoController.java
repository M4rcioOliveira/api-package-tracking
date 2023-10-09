package com.track.distance.controller;

import com.track.distance.model.Situacao;
import com.track.distance.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/track")
public class SituacaoController {

    @Autowired
    private SituacaoService situacaoService;


}
