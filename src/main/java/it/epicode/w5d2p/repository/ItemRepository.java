package it.epicode.w5d2p.repository;

import it.epicode.w5d2p.bean.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
