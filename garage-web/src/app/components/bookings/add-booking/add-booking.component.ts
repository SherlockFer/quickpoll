import { Booking } from './../../../models/booking.model';
import { Service } from './../../../models/service.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Response } from '../../../models/response.model';
import { VEHICLE_ENGINES } from 'src/app/models/constants.model';
import { VEHICLE_TYPES } from 'src/app/models/constants.model';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html'
})
export class AddBookingComponent implements OnInit {

  BOOKING_API     = `${environment.apiUrl}`;
  datetoday       = new Date();
  base_services   : Service[];
  vehicle_engines = VEHICLE_ENGINES;
  vehicle_types   = VEHICLE_TYPES;

  constructor(private router: Router,
    private toastr: ToastrService,
    private http: HttpClient) { }

  form = new FormGroup({
    date: new FormControl('', [Validators.required]),
    service_id: new FormControl('', [Validators.required]),
    vehicle_type: new FormControl('', [Validators.required]),
    vehicle_brand: new FormControl(''),
    vehicle_number_plate: new FormControl('', [Validators.required]),
    vehicle_model: new FormControl(''),
    vehicle_engine: new FormControl(''),
    comments: new FormControl(''),
  })

  ngOnInit() {
    this.http.get<Response<Service[]>>(`${this.BOOKING_API}/services/?filter[category]=base`).subscribe(
      res => {
        this.base_services = res.data;
      }
    );

    this.http.get<Response<Booking>>(`${this.BOOKING_API}/bookings?limit=1`).subscribe(
      res => {
        if (Object.keys(res.data).length) {//check if json data is empty
          let last_booking = res.data[0];
          this.form.get('vehicle_type').setValue(last_booking.vehicle_type);
          this.form.get('vehicle_brand').setValue(last_booking.vehicle_brand);
          this.form.get('vehicle_number_plate').setValue(last_booking.vehicle_number_plate);
          this.form.get('vehicle_model').setValue(last_booking.vehicle_model);
          this.form.get('vehicle_engine').setValue(last_booking.vehicle_engine);
        }
      }
    );
  }

  public onSubmit() {
    let booking = this.form.value;
    this.http.post<Response<Booking>>(`${this.BOOKING_API}/bookings`, booking).subscribe(
      res => {
        let booking: Booking = res.data;
        this.toastr.success('Your booking has been registered correctly', 'Congratulations');;
        this.router.navigate([`/my-bookings`]);
      }
    );
  }

  public fillForm() {
    this.form.get("date").setValue("2019-08-20");
    this.form.get("service_id").setValue("1");
    this.form.get("vehicle_type").setValue("car");
    this.form.get("vehicle_number_plate").setValue("ABC-123");
    this.form.get("vehicle_brand").setValue("Ford");
    this.form.get("vehicle_model").setValue("Fiesta");
    this.form.get("vehicle_engine").setValue("petrol");
    this.form.get("comments").setValue("My car is pulling to one side");
  }

}