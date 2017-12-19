package com.frieddust.ramailodemo.entity.action;

import com.frieddust.ramailodemo.entity.Customer;
import com.ramailo.annotation.RamailoAction;
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

	@RamailoAction()
	public static Object list() {
		return "List of customers";
	}
}
