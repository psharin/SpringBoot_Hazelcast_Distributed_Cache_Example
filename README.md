# Hazelcast and Spring Cache
Sample code on Hazelcast and Spring Cache

# Build and run steps

1. compile project
	mvn clean install
2. start the application. This starts on port 8080.
	java -jar target\SpringBoot_Hazelcast_Cache_Example-0.0.1-SNAPSHOT.jar
3. start the application on one more port 9090 in different terminal
	java -jar -Dserver.port=9090 target\SpringBoot_Hazelcast_Cache_Example-0.0.1-SNAPSHOT.jar

After starting the applications, you can find  the hazelcast cluster info in the console messages

# Test case 1
4. http://localhost:9090/addItem 
5. http://localhost:9090/item/{itemId}
6. http://localhost:8080/item/{itemId}

# Test case 2
7. http://localhost:8080/addItem
8. http://localhost:8080/item/{itemId}
9. http://localhost:9090/item/{itemId}

# Test case 3
10. http://localhost:8080/item/{itemId} 
11. http://localhost:8080//delete/{itemId}
12. http://localhost:9090/item/{itemId}
