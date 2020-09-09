export interface Booking{ 
    id: number;
    vehicle_number_plate: string;
    vehicle_model: string;
    vehicle_brand: string;
    vehicle_engine: string;
    date: Date;
    status: string;
    comments: string;
    service_id: string;
    vehicle_type: string;
    customer_id: number;
    mechanic_id:number;
    service_ids: number[];
    total:string;
    part_ids:number[];
}
