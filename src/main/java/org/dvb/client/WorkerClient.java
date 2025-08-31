package org.dvb.client;

import org.dvb.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "worker-service",
        url = "${worker-service.url:http://localhost:8081}"
)
public interface WorkerClient {

    @GetMapping("v1/items/{id}")
    Item getItem(@PathVariable("id") String id);

    @PostMapping("v1/items")
    Item createItem(@RequestBody Item item);
}
