package com.stock.controllers;

import com.stock.entities.StockEntity;
import com.stock.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockEntity>> getStocks(){
        return new ResponseEntity<List<StockEntity>>(stockService.getStocks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockEntity> saveStock(@RequestBody StockEntity stock){
        return new ResponseEntity<StockEntity>(stockService.saveStock(stock), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockEntity> editStock( @PathVariable Integer id, @RequestBody StockEntity stock ){
        return new ResponseEntity<StockEntity>(stockService.editStock(id, stock), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStock( @PathVariable Integer id ){
        stockService.deleteStock(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
