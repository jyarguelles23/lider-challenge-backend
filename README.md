Lider Challenge BackEnd is a springboot project.
 
This project need this repository https://github.com/walmartdigital/products-db  as the database container. <br />

## Build the container
First you must run the the database container referenced here https://github.com/walmartdigital/products-db <br />

## In the project directory, you can run:
The command   <strong> mvn clean install </strong> <br />
Then for build the docker image run the command  <strong> docker build -t lider-challenge-springboot .</strong> <br />
Running the docker image with the data base <strong> run -it -p 8080:8080 --network=host lider-challenge-springboot </strong> <br />
Test url <strong> localhost:8080/product/api </strong> <br />

 
 