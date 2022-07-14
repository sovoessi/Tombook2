package com.dahomeykid.byblos.gbooks.items;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    public List<Items> getAllItems(){return  itemsRepository.findAll();}

    public Optional<Items> getItemsById(String itemsId){return itemsRepository.findById(itemsId);}

    public Items saveItems(Items items){ return itemsRepository.save(items);}

    public List<Items> saveAll(List<Items> items){ return itemsRepository.saveAll(items);}

    public Optional<Items> updateItems(String itemsId, Items newItems){
        return itemsRepository.findById(itemsId)
                .map(oldItems -> {
                    Items updated = oldItems.updateWith(newItems);
                    return itemsRepository.save(updated);
                });
    }

    public void delete(String itemsId) {itemsRepository.deleteById(itemsId);}
}
