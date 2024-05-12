# echo-springboot

## Description:
This application will echo back a message that you send it. 

If its buddy application *chamber-springboot* is running, the message will be echoed back 3 times.

## Usage:
`curl <hostname>:8080 -d "hello"`

#### Notes:
To communicate with echo's buddy service: *chamber-springboot* in Kubernetes, you need to create a Service object called `chamber-springboot` for the chamber-springboot application.

You can modify the name of the service that echo-springboot is looking for by looking at `src/main/resources/application.yml` 
