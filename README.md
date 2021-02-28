#SQL
docker network create cabbage-mysql
docker container run --name cabbage --network cabbage-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -d mysql:8

#App docker image
docker build --build-arg JAR_FILE=build/libs/cabbage-0.0.1-SNAPSHOT.jar -t cabbagedock .
docker container run --network cabbage-mysql --name cabbage-jdbc-container -p 8080:8080 -d cabbagedock

docker container logs -f cabbage-jdbc-container



