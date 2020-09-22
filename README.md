Lider Challenge BackEnd is a springboot project.
 
This project need this repository https://github.com/walmartdigital/products-db  as the database container. <br />

## Build the container
First you must run the the database container referenced here https://github.com/walmartdigital/products-db <br />

## In the project directory, you can run:
The command   mvn clean install <br />
Then for build the docker image run the command ## docker build -t lider-challenge-springboot . <br />
Last for running the docker image with the data base run the command ## docker run -it 8080:8080 --network=host lider-challenge-springboot <br />
Test url localhost:8080/product/api <br />

 
 