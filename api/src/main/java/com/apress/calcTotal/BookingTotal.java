package com.apress.calcTotal;

import org.springframework.stereotype.Component;

import com.apress.dto.BookingDTO;
import com.apress.dto.PartDTO;
import com.apress.dto.ProductDTO;

@Component
public class BookingTotal {

	public void calcTotal(BookingDTO bookingDTO) {
		double sum = 0;
		if (bookingDTO.getBaseProduct() != null) {
			if (bookingDTO.getBaseProduct().getPrice() != null) {
				sum = sum + bookingDTO.getBaseProduct().getPrice();
			}
		}

		if (bookingDTO.getExtraProducts() != null) {
			for (ProductDTO product : bookingDTO.getExtraProducts()) {
				sum = sum + product.getPrice();
			}
		}
		if (bookingDTO.getParts() != null) {
			for (PartDTO part : bookingDTO.getParts()) {
				sum = sum + part.getPrice();
			}

		}

		bookingDTO.setTotal(sum);
		double a = 1;

	}

}
