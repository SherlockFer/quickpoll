start_db:
	docker-compose up --detach --force-recreate db 
	
stop_db:
	docker-compose stop db
	docker-compose rm db
	
start_redis:
	docker-compose up --detach --force-recreate redis
	docker-compose up --detach --force-recreate redis-commander