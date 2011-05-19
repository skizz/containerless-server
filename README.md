This is a simple demo containerless server. It shows how to run a server that embeds Jetty and Netty.

Building
--------

I have provided a simple maven pom that enables building and running the app from the command line. I've also provided a local settings file that specifies the appropriate remote repositories. 

    ./mvn -s local_settings.xml package

Running
-------

Once you have built run the app as:

    java -jar target/server-1.0.0-jar-with-dependencies.jar 

and you should see:

    $ java -jar target/server-1.0.0-jar-with-dependencies.jar 
	0 [main] INFO com.tw.service_demo.DemoService  - Metrics starting on socket 8082
	2011-05-19 12:01:10.058:INFO::Logging to STDERR via org.mortbay.log.StdErrLog
	2011-05-19 12:01:10.302:INFO::jetty-6.1.x
	2011-05-19 12:01:10.415:INFO::Started SocketConnector@0.0.0.0:8082
	411 [main] INFO com.tw.service_demo.DemoService  - Netty starting ...
	454 [main] INFO com.tw.service_demo.DemoService  - Netty listening on socket 8080
	
Netty is running on port 8080 and runs Netty's example snoop servlet on http://localhost:8080

	WELCOME TO THE WILD WILD WEB SERVER
	===================================
	VERSION: HTTP/1.1
	HOSTNAME: localhost:8080
	REQUEST_URI: /

	HEADER: Host = localhost:8080
	HEADER: Connection = keep-alive
	HEADER: User-Agent = Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.53 Safari/534.30
	HEADER: Accept = text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
	HEADER: Accept-Encoding = gzip,deflate,sdch
	HEADER: Accept-Language = en-US,en;q=0.8
	HEADER: Accept-Charset = ISO-8859-1,utf-8;q=0.7,*;q=0.3

Jetty is running on port 8082 and is running a metrics API from https://github.com/codahale/metrics. 
Connect to http://localhost:8082 you should see a page with:

	Operational Menu

	Metrics
	Ping
	Threads
	Healthcheck

Reading
-------

"ContainerLess"
http://patforna.blogspot.com/2011/04/containerless.html