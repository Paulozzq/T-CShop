package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.servicios.HorarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/horarios")
public class HorarioController {

    private final HorarioServiceImpl horarioServiceImpl;

    @Autowired
    public HorarioController(HorarioServiceImpl horarioServiceImpl) {
        this.horarioServiceImpl = horarioServiceImpl;
    }


}
