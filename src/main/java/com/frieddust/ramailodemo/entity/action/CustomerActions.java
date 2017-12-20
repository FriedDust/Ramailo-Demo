package com.frieddust.ramailodemo.entity.action;

import com.frieddust.ramailodemo.entity.Customer;
import com.frieddust.ramailodemo.entity.Item;
import com.ramailo.annotation.RamailoAction;
import com.ramailo.annotation.RamailoArg;
import com.ramailo.service.BaseActions;

public class CustomerActions extends BaseActions<Customer> {

	public CustomerActions(Customer customer) {
		super(customer);
	}

	@Override
	public void onBeforeSave() {
		super.onBeforeSave();

		System.out.println("Before saving.");
	}

	@Override
	public void onSave() {
		super.onSave();
		System.out.println("After save.");
	}

	@Override
	public void onBeforeDelete() {
		super.onBeforeDelete();

		System.out.println("Before delete.");
	}

	@Override
	public void onDelete() {
		super.onDelete();

		System.out.println("After delete.");
	}

	@RamailoAction(label = "Greet")
	public Object greet() {
		Customer customer = this.getEntity();
		return "Hi, " + customer.getName();
	}

	@RamailoAction
	public Object sing(@RamailoArg(name = "song") String song) {
		Customer customer = this.getEntity();
		return "Hi, I'm " + customer.getName() + " and I want to sing " + song;
	}

	@RamailoAction
	public Object buy(@RamailoArg(name = "item") Item item, @RamailoArg(name = "qty", label = "Quantity") Integer qty) {
		Customer customer = this.getEntity();
		Item i = getEm().find(Item.class, item.getId());

		return customer.getName() + " wants to buy " + qty + " " + i.getName();
	}

	@RamailoAction(methodType = "POST")
	public Object sell(@RamailoArg(name = "item") Item item,
			@RamailoArg(name = "qty", label = "Quantity") Integer qty) {
		Customer customer = this.getEntity();
		Item i = getEm().find(Item.class, item.getId());

		return customer.getName() + " wants to sell " + qty + " " + i.getName();
	}

	@RamailoAction()
	public static Object list() {
		return "List of customers";
	}
}
