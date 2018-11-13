package io.armandorvila.ota.product.criteria;

import java.time.DayOfWeek;

import io.armandorvila.ota.product.DiscountCriteria;
import io.armandorvila.ota.product.Order;

public class WeekDayDiscountCriteria implements DiscountCriteria {

	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public String description() {
		return "Disccount apply to any order placed on a WEDNESDAY";
	}
	
	@Override
	public boolean apply(Order order) {
		DayOfWeek orderDay = order.getDate().getDayOfWeek();
		return orderDay.equals(DayOfWeek.WEDNESDAY);
	}



}
