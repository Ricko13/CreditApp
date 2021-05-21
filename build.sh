#!/bin/bash
declare -a -r build_projects=("product" "customer" "credit")
for build_project in "${build_projects[@]}"
do
    cd $build_project
    echo building $build_project image
    ./mvnw spring-boot:build-image -DskipTests
    cd ..
done

echo "Creating containers"
docker-compose up -d