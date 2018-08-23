package com.sid.web;
//
//import org.glassfish.jersey.server.ResourceConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

////remarque : cette class config nous permet de deployer jersey

//@Configuration
//public class MyConfig {
//	
//	
//	
//	@Bean
//	public ResourceConfig getJersey() {
//		ResourceConfig config = new ResourceConfig();
//		config.register(EtudiantRestService.class);
//		return config;
//	}
//
//}




/*
 *decommenter plus haut pour utiliser spring mvc avec les web service controller  
 */

//******************************************************fin pour rest**************************************************************************************************


//******************************************************debut pour rest + soap************************************************************************************************

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.sid.rmi.ScolariteRemote;

@Configuration
public class MyConfig {



	@Bean
	public ResourceConfig getJersey() {
		ResourceConfig config = new ResourceConfig();
		config.register(EtudiantRestService.class);
		return config;
	}

	//class permettant de retourner un web service basée sur soap
	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		//c est ladresse du webservice et 0.0.0.0 permet d'y acceder a partir de nimporte quelle machine
		exporter.setBaseAddress("http://0.0.0.0:8585/service");
		return exporter;
	}
	
	//pour l exportation ou l exposition du service RMI 
	
	@Bean
	@Autowired//pour lui dire trouve moi les paramatre de cette methode et injecte les
	public RmiServiceExporter getRmiExporter(ScolariteRemote rmiService) {//on peut faire aussi avec appplication context de spring (ApplicationContext ctx) mais la sans autowired
		
		RmiServiceExporter exporter = new RmiServiceExporter();//crerr rmiserviceexporter
		exporter.setRegistryPort(1099);//on lui dit qd tu demmarre l annuaie utilise le numero de port1099
		exporter.setServiceName("SCOLARITE");//nom du service dans l annuaire
		//ScolariteRemote rmiService = ctx.getBean(ScolariteRemote.class);pspspspspsp marche avec applicationcontext de spring
		exporter.setService(rmiService);//le service lui meme on devrai si on ete pas ds spring utiliser new rmiservice exporter..
		return exporter;//on retourne le service
	}

}