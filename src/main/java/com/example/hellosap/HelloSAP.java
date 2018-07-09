package com.example.hellosap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;

public class HelloSAP implements RequestHandler<SAPConn, SAPResponse> {
  public SAPResponse handleRequest(SAPConn conn, Context context) {
    LambdaLogger logger = context.getLogger();
    logger.log("Start");

    MyDestinationProvider destinationProvider = new MyDestinationProvider(conn.host, conn.sysnum, conn.client,
        conn.user, conn.password);

    SAPResponse resp = new SAPResponse();

    try {
      JCoDestination destination = destinationProvider.getDestination();
      JCoFunction function = destination.getRepository().getFunction("STFC_CONNECTION");

      if (function == null)
        throw new RuntimeException("STFC_CONNECTION not found in SAP.");

      function.getImportParameterList().setValue("REQUTEXT", "Hello SAP");
      function.execute(destination);
      logger.log("STFC_CONNECTION finished:");

      resp.echoText = function.getExportParameterList().getString("ECHOTEXT");
      resp.respText = function.getExportParameterList().getString("RESPTEXT");
      logger.log("End");

    } catch (AbapException ae) {
      logger.log(ae.toString());
    } catch (JCoException je) {
      logger.log(je.toString());
    } catch (Exception e) {
      logger.log(e.toString());
    }finally{
      destinationProvider.unregister();
    }
    return resp;
  }
}
