package com.stock.services;

import com.stock.entities.StockEntity;
import com.stock.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private IStockRepository stockRepository;

    public List<StockEntity> getStocks(){
        return  stockRepository.findAll();
    }

    public StockEntity finById( Integer id ){
        return stockRepository.findById(id).get();
    }

    public StockEntity saveStock( StockEntity stock ){
        return stockRepository.save(stock);
    }

    public StockEntity editStock( Integer id, StockEntity stock ){
        Optional<StockEntity> response = stockRepository.findById(id);
        if( response.isPresent() )
            return stockRepository.save(stock );
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The %s id doesn't exist", id));
    }

    public void deleteStock( Integer id ){
        Optional<StockEntity> response = stockRepository.findById(id);
        if( response.isPresent() )
            stockRepository.delete(response.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The %s id doesn't exist", id));
    }


}
