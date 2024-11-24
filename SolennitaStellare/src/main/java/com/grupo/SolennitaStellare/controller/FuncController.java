package com.grupo.SolennitaStellare.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo.SolennitaStellare.entity.Func;
import com.grupo.SolennitaStellare.service.FuncService;

@RestController
@RequestMapping("/func")
public class FuncController {
    private FuncService funcService;
    
    public FuncController(FuncService funcService) {
        this.funcService = funcService;
    }
    @PostMapping
    public ResponseEntity<Func> createdFunc(@RequestBody CreateFuncDto CreateFuncDto){
       var funcId =  funcService.createFunc(CreateFuncDto);
        return ResponseEntity.created(URI.create("/func/"+funcId.toString() )).build();
    }
    @GetMapping("/{funcId}")
    public ResponseEntity<Func> getFuncById (@PathVariable("funcId") String funcId){
            
        return null;

    }
}
