# Online Chat Application
---
## Overview
This is a simple online chat application developed in Java. The application allows multiple users to connect to a central server, send messages, and receive messages from other users.

## Components
- ChatServer: Manages connections from multiple clients and broadcasts messages to all connected clients.
- ChatClient: Connects to the server, sends messages to the server, and receives messages from the server.

## How to Run
---
### Server
1. Compile the server code:
   ```sh
   javac ChatServer.java
   ```
2. Run the server:
   ```sh
   java ChatServer
   ```

### Client
1. Compile the client code:
   ```sh
   javac ChatClient.java
   ```
2. Run the client:
   ```sh
   java ChatClient
   ```

### Usage
- Once the server is running, multiple clients can connect to it.
- Clients can send messages, which will be broadcasted to all connected clients.
- Messages from other users will be displayed in the client's console.

## Notes
- Ensure the server is running before starting any clients.
- The server and clients must run on the same network or adjust the `SERVER_ADDRESS` in `ChatClient.java` accordingly.

## Implementation Details
- The server assigns a unique user ID to each connected client.
- The server maintains a list of connected users using a `HashSet`.
- Clients and servers communicate using sockets.
- A simple text-based user interface is provided for clients.

## Contributors

- [Peter Kwesi Obrempong Stephenson](https://github.com/Obrempong12)
