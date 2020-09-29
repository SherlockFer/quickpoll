INSERT INTO users (id,created_at,email,full_name,mobile,modified_at,"password","role") VALUES 
(1,'2020-09-28 21:18:34.531','admin@garage.com','Administrator','123456789','2020-09-28 21:18:34.531','123456','admin')
,(2,'2020-09-28 21:18:34.589','mechanic-1@garage.com','Mechanic-1','123456789','2020-09-28 21:18:34.589','123456','mechanic')
,(3,'2020-09-28 21:18:34.598','mechanic-2@garage.com','Mechanic-2','123456789','2020-09-28 21:18:34.598','123456','mechanic')
,(4,'2020-09-28 21:18:34.608','mechanic-3@garage.com','Mechanic-3','123456789','2020-09-28 21:18:34.608','123456','mechanic')
,(5,'2020-09-28 21:18:34.618','customer-1@garage.com','Customer-1','123456789','2020-09-28 21:18:34.618','123456','customer')
,(6,'2020-09-28 21:18:34.629','customer-2@garage.com','Customer-2','123456789','2020-09-28 21:18:34.629','123456','customer')
,(7,'2020-09-28 21:18:34.638','customer-3@garage.com','Customer-3','123456789','2020-09-28 21:18:34.638','123456','customer')
;

INSERT INTO products (id,category,created_at,modified_at,name,price,reference) VALUES 
(1,'base','2020-09-28 21:18:34.649','2020-09-28 21:18:34.649','Annual Service',50,'00f74ee0-2b40-46b1-b2e9-41d41a96da56')
,(2,'base','2020-09-28 21:18:34.664','2020-09-28 21:18:34.664','Major Service',60,'769317b0-1f11-4e7a-b3cf-9474e257a115')
,(3,'base','2020-09-28 21:18:34.671','2020-09-28 21:18:34.671','Repair or Fault',70,'4bbbadba-3044-422a-a71e-dc415cc19b46')
,(4,'base','2020-09-28 21:18:34.677','2020-09-28 21:18:34.677','Major Repair',80,'c964bdec-b5e9-4055-9eaf-14059e8e581f')
,(5,'extra','2020-09-28 21:18:34.684','2020-09-28 21:18:34.684','Wheel alignment',90,'c86b7723-4f32-43ac-a408-d5a22f37a88e')
,(6,'extra','2020-09-28 21:18:34.691','2020-09-28 21:18:34.691','Grease and lubricat',70,'4587d5c8-b0a0-4005-9f1a-616365342eb9')
,(7,'extra','2020-09-28 21:18:34.700','2020-09-28 21:18:34.700','Suspension',70,'f0f5ab78-f193-4c28-aafe-1567565098a3')
;

INSERT INTO parts (id,created_at,modified_at,name,price,sku) VALUES 
(1,'2020-09-28 21:18:34.709','2020-09-28 21:18:34.709','Engine motor oil',50,'a408617e-fdd6-4342-b064-41f83710e575')
,(2,'2020-09-28 21:18:34.728','2020-09-28 21:18:34.728','Filter oil',60,'b870f861-c768-4b5b-a4dd-f317d8940bad')
,(3,'2020-09-28 21:18:34.738','2020-09-28 21:18:34.738','Filer ai',70,'835906b3-e201-4672-b1e4-2364d98dc588')
;

INSERT INTO bookings (id,"comments",country_code,created_at,"date",ip_city,ip_country,modified_at,reference,status,total,vat_number,vehicle_brand,vehicle_engine,vehicle_model,vehicle_number_plate,vehicle_type,product_id,customer_id,mechanic_id) VALUES 
(1,'comentario 1',NULL,'2020-09-28 21:18:34.752','2020-10-01',NULL,NULL,'2020-09-28 21:18:34.752','0e06f571-bc39-44a9-8e42-2b0a579d2958','booked',290,NULL,'Ford','diesel','M5','AAA-111','car',1,1,2)
,(2,'comentario 2',NULL,'2020-09-28 21:18:34.805','2020-10-02',NULL,NULL,'2020-09-28 21:18:34.805','5af2fd64-1524-4f8b-8c5f-841f78ef3010','booked',230,NULL,'Ford','diesel','M5','BBB-222','car',1,1,2)
,(3,'comentario 3',NULL,'2020-09-28 21:18:34.825','2020-10-03',NULL,NULL,'2020-09-28 21:18:34.825','23bca290-a40c-4078-a291-7f4350e7840a','in_service',230,NULL,'Ford','petrol','M5','CCC-333','small_van',1,1,2)
,(4,'comentario 4',NULL,'2020-09-28 21:18:34.847','2020-10-04',NULL,NULL,'2020-09-28 21:18:34.847','aeb9d5a7-a2b7-49c2-8714-8d7ad42eb818','fixed',230,NULL,'Ford','hybrid','M5','DDD-444','small_bus',1,1,2)
,(5,'comentario 5',NULL,'2020-09-28 21:18:34.867','2020-10-05',NULL,NULL,'2020-09-28 21:18:34.867','41179a21-1156-48e4-bcda-63276d98ac34','collected',230,NULL,'Ford','electric','M5','EEE-666','small_bus',1,1,2)
,(6,'comentario 6',NULL,'2020-09-28 21:18:34.887','2020-10-06',NULL,NULL,'2020-09-28 21:18:34.887','3376e3b3-af20-4871-a769-88157837dc58','unrepairable',230,NULL,'Ford','electric','M5','FFF-777','car',1,1,2)
;

INSERT INTO booking_products (booking_id,product_id) VALUES 
(1,2)
,(1,3)
,(2,2)
,(2,3)
,(3,2)
,(3,3)
,(4,2)
,(4,3)
,(5,2)
,(5,3)
;
INSERT INTO booking_products (booking_id,product_id) VALUES 
(6,2)
,(6,3)
;

INSERT INTO bookings_parts (booking_id,parts_id) VALUES 
(1,1)
,(1,2)
,(2,1)
,(3,1)
,(4,1)
,(5,1)
,(6,1)
;


