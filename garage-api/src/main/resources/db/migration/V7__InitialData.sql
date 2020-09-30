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