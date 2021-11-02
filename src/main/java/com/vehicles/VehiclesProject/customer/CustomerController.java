package com.vehicles.VehiclesProject.customer;

import com.vehicles.VehiclesProject.customer.Customer;
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
//
//    @GetMapping
//    public List<Customer> all() {
//        return new ArrayList<>(customers.values());
//    }
//
//    @PostMapping()
//    public Customer postCustomer(@RequestBody Customer newCustomer) {
//        Long id = idCount.incrementAndGet();
//
//        newCustomer.setId(id);
//
//        customers.put(id, newCustomer);
//
//        return newCustomer;
//    }
//
//    @GetMapping("/{id}")
//    public Customer getById(@PathVariable Long id) {
//        return customers.get(id);
//    }
//
//    @PutMapping("/{id}")
//    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updateData) {
//        Customer profile = customers.get(id);
//
//        if (profile == null) {
//            return profile;
//        }
//
//        if (updateData.getName() != null) {
//            profile.setName(updateData.getName());
//        }
//
//        return profile;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Long id) {
//        customers.remove(id);
//    }

    //Rebuilt paths and methods

    @GetMapping
    public List<Customer> all() {
        return new ArrayList<Customer>(customers.values());
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customers.get(id);
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        Long id = idCount.incrementAndGet();

        newCustomer.setId(id);

        customers.put(id, newCustomer);


        return customers.get(id);
    }

    @PutMapping("/{id}")
    public Customer modifyCustomer(@PathVariable Long id, @RequestBody Customer newCustomer) {
        Customer mod = customers.get(id);

        if (mod == null) {
            return mod;
        }

        if (newCustomer.getName() != null) {
            mod.setName(newCustomer.getName());
        }

        return mod;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customers.remove(id);
    }
}
