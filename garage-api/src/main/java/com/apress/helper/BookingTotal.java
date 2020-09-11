package com.apress.helper;

import org.springframework.stereotype.Component;

import com.apress.dto.BookingDTO;
import com.apress.dto.PartDTO;
import com.apress.dto.ProductDTO;

@Component
public class BookingTotal {

	public double calcTotal(BookingDTO bookingDTO) {
		double total = 0;
		if (bookingDTO.getBaseProduct() != null) {
			if (bookingDTO.getBaseProduct().getPrice() != null) {
				total += bookingDTO.getBaseProduct().getPrice();
			}
		}
		if (bookingDTO.getExtraProducts() != null) {
			for (ProductDTO product : bookingDTO.getExtraProducts()) {
				total += product.getPrice();
			}
		}
		if (bookingDTO.getParts() != null) {
			for (PartDTO part : bookingDTO.getParts()) {
				total += part.getPrice();
			}
		}
		return total;
	}

}
