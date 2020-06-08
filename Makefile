build:
	mvn package
	docker-compose build
	#docker stack remove garage
	docker stack deploy garage -c docker-compose.yml # Deploy Stack + Service + Containers