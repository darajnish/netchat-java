# NetChat

This is a fun project I did while I was a kid to get a taste of developing a GUI application in Java. This project has no relevance as a consumable application as it lacks the capabilities of a good network chat application and security one would expect, but it may help as a explorable example for the new learners who wish to have a glance at examples. I'm not modifying the code and I've kept it as it was back when I created it.

This application is a simple text based chat application over TCP sockets in Java, with a support for just two people, and with a poorly designed User Interface and a lot of bugs and security issues. The project is divided into two sub-projects, **ChatServer** and **ChatClient**, the **ChatServer** part is the code for running the server and **ChatClient** part is the code for running the client which would communicate with the server.



##  Building

####  Requirements

- JDK 1.7 or above
- Apache Ant 1.9.16 or above


This project was made using [Netbeans IDE](https://netbeans.apache.org/) and both the sub-projects can be easily opened, build and explored using Netbeans. But, they can even be built using **ant** by first changing directory into the respective sub-projects and then running,

```bash
ant jar
```

After the build is complete, the executable jar file would get created into `dist` directory.



##  Running

Once the jar files are created for each of the sub-projects, we can continue by first running the **ChatServer** which would host our chat over the network.

```bash
java -jar ChatServer/dist/ChatServer.jar
```

Then, setup the server by providing it with a name and a port number.

Once the server is running, it's time to run the **ChatClient** which would connect to the server over the network on the provided port number and the hostname / ip address of the **ChatServer** instance.

```bash
java -jar ChatClient/dist/ChatClient.jar
```

When both are setup, we can use the crappy GUI to chat using the server and client.



##  License

This project is under [WTFPL License](LICENSE)
