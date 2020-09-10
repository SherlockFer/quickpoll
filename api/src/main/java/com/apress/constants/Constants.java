package com.apress.constants;

public interface Constants {
	
	public enum BookingStatus{
		booked,
		in_service,
		fixed,
		collected,
		unrepairable;
		
	}
	
	public enum UserRole{
		admin,
		customer,
		mechanic;
	}
	
	public enum VehicleType{
		car,
		small_van,
		small_bus,
		motorbike;
	}
	
	public enum VehicleEngine{
		diesel,
		petrol,
		hybrid,
		electric;
	}
	
	public enum ServiceCategory{
		base,
		extra;
	}
	
	public enum ServiceName{
		annual_service,
		major_service,
		repair_or_fault,
		major_repair,
		wheel_alignment,
		grease_and_lubricant,
		suspension,
		change_the_engine_oil,
		replace_the_oil_filter,
		replace_the_air_filet;
		
	}
	
}
