#build:
#	mvn package
#	docker-compose build
#	#docker stack remove garage
#	docker stack deploy garage -c docker-compose.yml # Deploy Stack + Service + Containers

start_db:
	docker-compose up --detach --force-recreate db 
	
stop_db:
	docker-compose stop db
	docker-compose rm db