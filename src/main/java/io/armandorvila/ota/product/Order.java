package io.armandorvila.ota.product;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.money.CurrencyUnit;

import org.javamoney.moneta.Money;

import lombok.Getter;

public class Order {

	@Getter
	private Long id;

	@Getter
	private LocalDate date;

	@Getter
	private User user;

	@Getter
	private Set<Product> products;

	@Getter
	private Money finalPrice;

	public Order(LocalDate date, User user, CurrencyUnit currency, Set<Product> products) {
		this.date = date;
		this.user = user;
		this.products = products;

		this.finalPrice = Money.of(0, currency);
	}

	/**
	 * Taking as argument an instance of the DiscountService interface, this method:
	 * <ul>
	 * <li>Gets the discounts to apply for every product of the order</li>
	 * <li>Filters the discounts criteria list leaving only the ones that apply to
	 * this order</li>
	 * <li>Calculate the final price of each product based on those discounts</li>
	 * <li>Aggregate all the final prices to obtain the final order price</li>
	 * </ul>
	 * 
	 * <p>NOTE: This logic can be extracted to a service, if we decide to go for an
	 * anemic domain "approach":
	 * https://www.martinfowler.com/bliki/AnemicDomainModel.html </p>
	 */
	public void calculatePrice(DiscountService discountService) {

		products.forEach(product -> {
			List<DiscountCriteria> criterias = discountService.getDiscountCriterias(product).stream()
					.filter(criteria -> criteria.apply(this)).collect(Collectors.toList());

			this.finalPrice.add(product.calculatePrice(criterias));
		});
	}

}
