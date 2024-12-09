package com.songdan.basicmall.item;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemName(String itemName);
    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);
    List<Item> findByPriceLessThan(Integer price);
    List<Item> findByPriceGreaterThanEqualOrderByPriceDesc(int price);
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
