## Quick resume
A dockerized 3-services project, each one with your own database, running in beside an API Gateway and Service Discovery using Spring Cloud tools.

## Usage
Run `docker-compose pull && docker-compose up` in the main folder. Make sure that the ports 5432, 8761, 8080, 8081, 8082, 8090, 27017 and 27018 are free.
You have to configure your own docker credentials and repository to use Jib integration.
