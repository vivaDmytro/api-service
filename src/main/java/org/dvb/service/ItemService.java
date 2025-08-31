package org.dvb.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.dvb.client.StorageClient;
import org.dvb.model.Item;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final StorageClient storageClient;

    public Optional<Item> getItem(String itemId) {
        try {
            return Optional.ofNullable(storageClient.getItem(itemId));
        } catch (FeignException e) {
            return Optional.empty();
        }
    }

    public Optional<Item> createItem(Item item) {
        try {
            return Optional.ofNullable(storageClient.createItem(item));
        } catch (FeignException e) {
            return Optional.empty();
        }
    }
}
