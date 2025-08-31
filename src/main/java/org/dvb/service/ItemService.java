package org.dvb.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dvb.client.WorkerClient;
import org.dvb.model.Item;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final WorkerClient workerClient;

    public Optional<Item> getItem(String itemId) {
        try {
            log.info("Getting item: {}", itemId);
            return Optional.ofNullable(workerClient.getItem(itemId));
        } catch (FeignException e) {
            log.error("Error getting item {}", itemId, e);
            return Optional.empty();
        }
    }

    public Optional<Item> createItem(Item item) {
        try {
            log.info("Creating new item: {}", item);
            return Optional.ofNullable(workerClient.createItem(item));
        } catch (FeignException e) {
            log.error("Error creating new item: {}", item, e);
            return Optional.empty();
        }
    }
}
