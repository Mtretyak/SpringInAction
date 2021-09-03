package com.example.tacocloud.repositories;

import com.example.tacocloud.data.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
