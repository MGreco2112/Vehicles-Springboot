package com.vehicles.VehiclesProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final AtomicLong idCount = new AtomicLong();
    private final Map<Long, Customer> customers = new HashMap<>();

    public CustomerController() {
        Customer dummyCustomer = new Customer("Matt");
        dummyCustomer.setId(idCount.incrementAndGet());

        customers.put(idCount.get(), dummyCustomer);

    }

    @GetMapping
    public List<Customer> all() {
        return new ArrayList<>(customers.values());
    }


}
