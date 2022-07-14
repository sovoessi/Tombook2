package com.dahomeykid.byblos.gbooks.items;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/library")
@AllArgsConstructor
public class ItemsController {

    private final ItemsService itemsService;

    @GetMapping
    public List<Items> fetchAllItems(){
        return itemsService.getAllItems();
    }

    @GetMapping("/{itemsId}")
    public ResponseEntity<Items> fetchItemsById(@PathVariable("itemsId") String itemsId){
        Optional<Items> found = itemsService.getItemsById(itemsId);
        return ResponseEntity.of(found);
    }

    @PutMapping("/{itemsId}")
    public ResponseEntity<Items> updateBook(
            @PathVariable("itemsId") String itemsId,
            @RequestBody Items updatedItems){
        Optional<Items> updated = itemsService.updateItems(itemsId, updatedItems);
        return updated
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> {
                    Items created = itemsService.saveItems(updatedItems);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{itemsId}")
                            .buildAndExpand(created.getItemsId())
                            .toUri();

                    return ResponseEntity.created(location).body(created);
                });
    }

    @DeleteMapping("/{itemsId}")
    public ResponseEntity<Items> delete(@PathVariable("itemstId") String itemsId) {
        itemsService.delete(itemsId);
        return ResponseEntity.noContent().build();
    }
}
