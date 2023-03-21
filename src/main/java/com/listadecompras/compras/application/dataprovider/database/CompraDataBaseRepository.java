package com.listadecompras.compras.application.dataprovider.database;

import com.listadecompras.compras.application.entity.CompraEntity;
import com.listadecompras.compras.core.dataprovider.CompraDataProvider;
import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.market.Purchase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class CompraDataBaseRepository implements CompraDataProvider {

    private final JpaRepository<CompraEntity, Long> repository;

    @Override
    public Purchase registerCompra(Compra compra) {
        Purchase purchase = (Purchase) compra;
        repository.save(new CompraEntity(null, purchase.dateReference(), purchase.items().toString(), purchase.comments(), purchase.isDone()));
        log.info("Save compra {} in the database.", purchase.dateReference());
        return purchase;
    }

    @Override
    public Compra updateCompra(Compra compra) {
        Purchase purchase = (Purchase) compra;
        Optional<CompraEntity> byId = repository.findById(1L);
        if(byId.isPresent()) {
            CompraEntity compraEntity = byId.get();
            compraEntity.setDateReference(purchase.dateReference());
            compraEntity.setItems(purchase.items().toString());
            compraEntity.setComments(purchase.comments());
            compraEntity.setIsDone(purchase.isDone());
            repository.save(compraEntity);
            log.info("Update compra {} in the database.", purchase.dateReference());
            return purchase;
        }
        return null;
    }

    @Override
    public Compra searchCompra(LocalDate dateReference) {
        Optional<CompraEntity> byId = repository.findById(1L);
        if(byId.isPresent()) {
            Purchase purchase = new Purchase(byId.get().getDateReference(), List.of(), byId.get().getComments(), byId.get().getIsDone());
            log.info("Found compra {} in the database.", purchase.dateReference());
            return purchase;
        }
        return null;
    }

    @Override
    public List<Compra> searchCompras() {
        List<CompraEntity> all = repository.findAll();
        List<Purchase> purchases = all.stream()
                .map(compraEntity -> new Purchase(compraEntity.getDateReference(), List.of(), compraEntity.getComments(), compraEntity.getIsDone()))
                .toList();
        return null;
    }

}
