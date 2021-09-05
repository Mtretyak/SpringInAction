package com.example.tacocloud.repositories;

import com.example.tacocloud.data.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
