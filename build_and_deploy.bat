docker-compose down
docker rmi -f letsplay-be-server
CALL ./maven_build.bat
docker-compose up