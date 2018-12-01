package org.m2i;

import org.hibernate.tool.schema.spi.Exporter;
import org.m2i.rmi.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiBasedExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfigSoap {
	
	@Bean
	public SimpleJaxWsServiceExporter getJWX() {
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/maBanque");
		return exporter;
	}
	@Bean
	public RmiServiceExporter getRmi(ApplicationContext context)  {
		RmiServiceExporter exporter=new RmiServiceExporter();
	    exporter.setService(context.getBean("myrmiservice"));
	    exporter.setRegistryPort(1099);
	    exporter.setServiceName("BK");
        exporter.setServiceInterface(BanqueRmiRemote.class);
        return exporter;
	    
	}

}
