find . -maxdepth 2 -name "pom.xml"  -exec mvn clean package -f '{}' \;