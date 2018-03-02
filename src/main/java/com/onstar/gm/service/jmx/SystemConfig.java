package com.onstar.gm.service.jmx;

public class SystemConfig implements SystemConfigMBean {
	
	private int threadCount;
	private String schemaName;
	
	public SystemConfig(int threadCount, String schemaName) {
		this.threadCount = threadCount;
		this.schemaName = schemaName;
	}

	@Override
	public int getThreadCount() {
		return this.threadCount;
	}

	@Override
	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;		
	}

	@Override
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	@Override
	public String getSchemaName() {
		return this.schemaName;
	}

	@Override
	public String doConfig() {
	      return "No of Threads="+this.threadCount+" and DB Schema Name="+this.schemaName;
	}	

}
