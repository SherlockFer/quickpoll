export interface Booking{ 
    id: number;
    vehicle_number_plate: string;
    vehicle_model: string;
    vehicle_brand: string;
    vehicle_engine: string;
    date: Date;
    status: string;
    comments: string;
    base_service: string;
    vehicle_type: string;
    customer: number;
    mechanic:number;
    base_service: number[];
    total:string;
    parts:number[];
}
