package com.vehicles.VehiclesProject;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public Customer postCustomer(@RequestBody Customer newCustomer) {
        Long id = idCount.incrementAndGet();

        newCustomer.setId(id);

        customers.put(id, newCustomer);

        return newCustomer;
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customers.get(id);
    }
}
