package io.armandorvila.ota.product;

import java.util.List;

import org.javamoney.moneta.Money;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@AllArgsConstructor
public class Product {

	private static final int DISCOUNT_PER_CRITERIA = 2;

	@Getter
	private Long id;

	@Getter
	private String name;

	@Getter
	private Money basePrice;

	/**
	 * Based on the base price of this product, and the discount criteria applied,
	 * this methods calculate the price returning the final price.
	 * 
	 * @param discountsToApply Discount Criteria that must be considered for the
	 *                         final price.
	 * 
	 * @return a new Money instance with the final price.
	 * 
	 * <p>
	 * NOTE:This logic can be extracted to a service, if we decide to go for
	 * an anemic domain "approach":https://www.martinfowler.com/bliki/AnemicDomainModel.html
	 * </p>
	 */
	public Money calculatePrice(List<DiscountCriteria> discountsToApply) {
		Money finalPrice = Money.of(basePrice.getNumber(), basePrice.getCurrency());

		for (DiscountCriteria discountCriteria : discountsToApply) {
			log.debug("Applying discount {} to product {}", discountCriteria.name(), this.getName());

			Money amount = Money.of(DISCOUNT_PER_CRITERIA, basePrice.getCurrency());

			finalPrice = finalPrice.subtract(amount);
		}

		return finalPrice;
	}
}
