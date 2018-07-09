package com.example.hellosap;

import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

class MyDestinationProvider implements DestinationDataProvider{

    private Properties ABAP_AS_properties;

    public MyDestinationProvider(String ashost, String sysnr, String client, String user, String passwd)
	{
    Properties connectProperties = new Properties();
    connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, ashost);
    connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, sysnr);
    connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, client);
    connectProperties.setProperty(DestinationDataProvider.JCO_USER, user);
    connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, passwd);
    this.ABAP_AS_properties = connectProperties;
    Environment.registerDestinationDataProvider(this);
	}

	public void unregister() {
		Environment.unregisterDestinationDataProvider(this);
	}

    public JCoDestination getDestination() throws JCoException{
        return JCoDestinationManager.getDestination("");
    }

	@Override
	public Properties getDestinationProperties(String arg0) throws DataProviderException {
		return ABAP_AS_properties;
	}
	@Override
	public void setDestinationDataEventListener(DestinationDataEventListener arg0) {
		
	}
	@Override
	public boolean supportsEvents() {
		return false;
	}

}
