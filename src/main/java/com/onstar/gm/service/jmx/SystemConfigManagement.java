package com.onstar.gm.service.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class SystemConfigManagement {
	
	 private static final int DEFAULT_NO_THREADS=10;
	 private static final String DEFAULT_SCHEMA="default";

	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
		
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		
		SystemConfig mBean = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
		ObjectName name = new ObjectName("com.onstar.gm.service.jmx:type=SystemConfig");
		mBeanServer.registerMBean(mBean, name);
		
		 do {
			 Thread.sleep(3000);
			 System.out.println("Thread Count="+mBean.getThreadCount()+":::Schema Name="+mBean.getSchemaName());
		 }while(mBean.getThreadCount() !=0);
	}

}
