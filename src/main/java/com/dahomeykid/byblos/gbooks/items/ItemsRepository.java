package com.dahomeykid.byblos.gbooks.items;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<Items, String > {
}
