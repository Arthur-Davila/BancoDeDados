package com.grupo.SolennitaStellare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo.SolennitaStellare.entity.Func;
import com.grupo.SolennitaStellare.service.FuncService;
//"/func" é o que vai ter na url pra achar o local da controlador
// http://localhost:8080/func
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
            var func = funcService.getFuncById(funcId);
            if (func.isPresent()) {
                return ResponseEntity.ok(func.get());
            }
            else{
                return ResponseEntity.notFound().build();
            }

    }
    @GetMapping
    public ResponseEntity<List<Func>> listFunc(){
        var list = funcService.listFunc();
        return ResponseEntity.ok(list);
    }
    @PutMapping("/{funcId}")
    public ResponseEntity<Void> updateFuncById(@PathVariable("funcId") String funcId,
    @RequestBody UpdateFuncDto updateFuncDto){
        
        funcService.updateFuncById(funcId, updateFuncDto);
        return ResponseEntity.noContent().build();
   

    }


    @DeleteMapping("/{funcId}")
    public ResponseEntity<Void> deleteById(@PathVariable("funcId") String funcId){
        funcService.deleteById(funcId);
        return ResponseEntity.noContent().build();
    }
}
