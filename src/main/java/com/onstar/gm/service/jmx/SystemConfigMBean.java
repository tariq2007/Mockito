package com.onstar.gm.service.jmx;

public interface SystemConfigMBean {
	
	public int getThreadCount();
	
	public void setThreadCount(int threadCounts);
	
	 public void setSchemaName(String schemaName);
	 
	 public String getSchemaName();
	 
	 
	 public String doConfig();

}
