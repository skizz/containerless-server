package com.tw.service_demo;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.example.http.snoop.*;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import com.yammer.metrics.reporting.*;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class DemoService {

	static Logger logger = Logger.getLogger(DemoService.class);

    public static void main(String[] args) throws Exception {

		//Log4J
		
		BasicConfigurator.configure();

		//JETTY with Metrics

		logger.info("Metrics starting on socket " + 8082);
		Server server = new Server(8082);
		Context root = new Context(server,"/",Context.SESSIONS);
		root.addServlet(new ServletHolder(new MetricsServlet()), "/*");
		server.start();

		//NETTY
		
		// Configure the server.
		logger.info("Netty starting ...");
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        // Set up the event pipeline factory.
        bootstrap.setPipelineFactory(new HttpServerPipelineFactory());

        // Bind and start to accept incoming connections.
		logger.info("Netty listening on socket " + 8080);
        bootstrap.bind(new InetSocketAddress(8080));


    }
}
