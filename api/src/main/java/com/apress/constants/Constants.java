package com.apress.constants;

public interface Constants {
	
	public enum BookingStatus{
		booked;
	}
	
	public enum UserRole{
		admin,
		customer;
	}
	
	public enum VehicleType{
		car,
		small_van,
		small_bus,
		motorbike
	}
	
	public enum ServiceCategory{
		base,
		extra;
	}
}
