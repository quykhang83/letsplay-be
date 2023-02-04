docker-compose down
docker rmi -f letsplay-server
CALL ./maven_build.bat
docker-compose up