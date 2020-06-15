package com.apress.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.apress.domain.Booking;
import com.apress.domain.Part;
import com.apress.domain.Product;
import com.apress.domain.User;
import com.apress.repository.BookingRepository;
import com.apress.repository.PartRepository;
import com.apress.repository.ProductRepository;
import com.apress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Component
public class LoadDemoData implements ApplicationRunner {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PartRepository partRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Loading database");

		bookingRepository.save(Booking.builder().products(Product.builder().name("probando")).id(1L).comments("comentario 1").status("booked").vehiculeBrand("Nisan").vehiculeEngine("1500").vehiculeModel("Sunny").vehiculeNumberPlate("AAA-111").build());
		bookingRepository.save(Booking.builder().id(2L).comments("comentario 2").status("fixed").vehiculeBrand("Toyota").vehiculeEngine("1600").vehiculeModel("hilux").vehiculeNumberPlate("BBB-222").build());
		
		userRepository.save(User.builder().fullName("Administrator").mobile("123456789").email("admin@garage.com").build());
		userRepository.save(User.builder().fullName("Mechanic-1").mobile("123456789").email("mechanic-1@garage.com").role("mechanic").build());
		userRepository.save(User.builder().fullName("Mechanic-2").mobile("123456789").email("mechanic-2@garage.com").role("mechanic").build());
		userRepository.save(User.builder().fullName("Mechanic-3").mobile("123456789").email("mechanic-3@garage.com").role("mechanic").build());
		userRepository.save(User.builder().fullName("Customer-1").mobile("123456789").email("mechanic-1@garage.com").role("customer").build());
		userRepository.save(User.builder().fullName("Customer-2").mobile("123456789").email("mechanic-2@garage.com").role("customer").build());
		userRepository.save(User.builder().fullName("Customer-3").mobile("123456789").email("mechanic-3@garage.com").role("customer").build());
		
		productRepository.save(Product.builder().name("Annual Service").category("base").price(50).build());
		productRepository.save(Product.builder().name("Major Service").category("base").price(60).build());
		productRepository.save(Product.builder().name("Repair or Fault").category("base").price(70).build());
		productRepository.save(Product.builder().name("Major Repair").category("base").price(80).build());
		productRepository.save(Product.builder().name("Wheel alignment").category("extra").price(90).build());
		productRepository.save(Product.builder().name("Grease and lubricat").category("extra").price(70).build());
		productRepository.save(Product.builder().name("Suspension").category("extra").price(70).build());
		

		partRepository.save(Part.builder().name("Engine motor oil").price(50).build());
		partRepository.save(Part.builder().name("Filter oil").price(60).build());
		partRepository.save(Part.builder().name("Filer ai").price(70).build());

	}

}

//insert into users (id, full_name, mobile, email, role, password) values (1, "Mechanic-1" , "123456789" , "mechanic-1@garage.com" , "mechanic1" , "123456");
//insert into users (id, full_name, mobile, email, role, password) values (2, "Mechanic-2" , "123456789" , "mechanic-2@garage.com" , "mechanic2" , "123456");
//insert into users (id, full_name, mobile, email, role, password) values (3, "Mechanic-3" , "123456789" , "mechanic-3@garage.com" , "mechanic3" , "123456");
//
//insert into products(id, name, category, price) values(1, "Annual Service", "base", 50);
//insert into products(id, name, category, price) values(2, "Major Service", "base", 60);
//insert into products(id, name, category, price) values(3, "Repair or Fault", "base", 70);
//
//insert into parts(id, name, price) values(1, "Engine motor oil", 50);
//insert into parts(id, name, price) values(2, "Filter oil", 60);
//insert into parts(id, name, price) values(3, "Filer air", 70);