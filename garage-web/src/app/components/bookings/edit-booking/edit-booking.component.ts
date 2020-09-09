import { Service } from './../../../models/service.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Booking } from './../../../models/booking.model';
import { ToastrService } from 'ngx-toastr';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Response } from '../../../models/response.model';
import { User } from 'src/app/models/user.model';
import { Part } from 'src/app/models/part.model';
import { VEHICLE_ENGINES } from 'src/app/models/constants.model';
import { VEHICLE_TYPES } from 'src/app/models/constants.model';
import { BOOKING_STATUS } from 'src/app/models/constants.model';

@Component({
  selector: 'app-edit-booking',
  templateUrl: './edit-booking.component.html',
})
export class EditBookingComponent implements OnInit {

  API_URL         = `${environment.apiUrl}`;

  form            : FormGroup;
  extra_services  : Service[];
  base_services   : Service[];
  parts           : Part[];
  customer        : User;
  mechanics       : User[];  
  vehicle_engines = VEHICLE_ENGINES;
  vehicle_types   = VEHICLE_TYPES;
  booking_status  = BOOKING_STATUS;
  today           = new Date();
  isLoading: boolean = true;

  constructor(private route: ActivatedRoute,
    private toastr: ToastrService,
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router) {}

  ngOnInit() {
    let booking_id = Number((this.route.snapshot.params.id))
    
    this.form = this.formBuilder.group({
      id: [, Validators.required],
      status: [],
      mechanic_id: [],
      customer_id: [],
      date: [, Validators.required],
      service_id: [, Validators.required],
      vehicle_type: [],
      vehicle_brand: [],
      vehicle_number_plate:[, Validators.required],
      vehicle_model: [],
      vehicle_engine: [],
      comments: [],
      service_ids: [[]],
      part_ids: [[]],
    });


    // Base services
    this.http.get<Response<Service[]>>(`${this.API_URL}/services/?filter[category]=base`).subscribe(
      res => {
        this.base_services = res.data
      }
    );

    // Extra services
    this.http.get<Response<Service[]>>(`${this.API_URL}/services/?filter[category]=extra`).subscribe(
      res => {
        this.extra_services = res.data
      }
    );

    // Autoparts
    this.http.get<Response<Part[]>>(`${this.API_URL}/vehicles/parts`).subscribe(
      res => {
        this.parts = res.data;        
      }
    );

    // Mechanics
    this.http.get<Response<User[]>>(`${this.API_URL}/users/?filter[role]=mechanic`).subscribe(
      res => {
        this.mechanics = res.data
      }
    );
    
    //Booking 
    this.http.get<Response<Booking>>(`${this.API_URL}/bookings/${booking_id}`).subscribe(
      res => {
        let booking = res.data;
        delete booking.total; // Removing read-only field
        this.form.setValue(booking);
        //Start customer
        this.http.get<Response<User>>(`${this.API_URL}/users/${booking.customer_id}`).subscribe(
          res => {
            this.customer = res.data;
            this.isLoading = false;
          }
        );
        //Finish customer
      }
    );
  }  

  public onSubmit() {
    let booking = this.form.value;
    this.http.put<Response<Booking>>(`${this.API_URL}/bookings/${booking.id}`, booking).subscribe(
      res => {
        this.toastr.success('Booking has been modify correctly');;
        this.router.navigate(["/my-bookings"]);
      }
    );
  }

}
