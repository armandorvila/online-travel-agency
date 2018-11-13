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

	public Money calculatePrice(List<DiscountCriteria> discounts) {
		Money finalPrice = Money.of(basePrice.getNumber(), basePrice.getCurrency());
		
		for (DiscountCriteria discountCriteria : discounts) {
			log.debug("Applying discount {} to product {}", discountCriteria.name(), this.getName());
			
			Money amount = Money.of(DISCOUNT_PER_CRITERIA, basePrice.getCurrency());
			
			finalPrice  = finalPrice.subtract(amount);
		}
		
		return finalPrice;
	}
}
