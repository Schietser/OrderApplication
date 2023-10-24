package be.cm.orders.entities;

import be.cm.customers.entities.Customer;

import java.util.List;
import java.util.UUID;

public class Order {

   private final String id;
   private final List<ItemGroup> itemGroup;
   private final double totalPrice;
   private final Customer customer;

   public Order(List<ItemGroup> itemGroup, Customer customer) {
      this.id = UUID.randomUUID().toString();
      this.itemGroup = itemGroup;
      this.totalPrice = itemGroup.stream().mapToDouble(ItemGroup::getTotalPrice).sum();
      this.customer = customer;
   }

   public String getId() {
      return id;
   }

   public List<ItemGroup> getItemGroup() {
      return itemGroup;
   }

   public double getTotalPrice() {
      return totalPrice;
   }

   public Customer getCustomer() {
      return customer;
   }
}
