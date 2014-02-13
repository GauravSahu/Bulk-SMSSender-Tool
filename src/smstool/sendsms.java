/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smstool;

import java.util.List;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
/**
 *
 * @author QWERTY
 */
public class sendsms {

    public void doIt(String portID) throws Exception
	{
		OutboundNotification outboundNotification = new OutboundNotification();
		System.out.println("Example: Send message from a serial gsm modem.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", portID, 115200, "SONY", "");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin("0000");
		// Explicit SMSC address set is required for some modems.
		// Below is for VODAFONE GREECE - be sure to set your own!

		gateway.setSmscNumber("+919807099060");
		Service.getInstance().setOutboundMessageNotification(outboundNotification);
		Service.getInstance().addGateway(gateway);

		Service.getInstance().startService();
		System.out.println();
		System.out.println("Modem Information:");
		System.out.println("  Manufacturer: " + gateway.getManufacturer());
		System.out.println("  Model: " + gateway.getModel());
		System.out.println("  Serial No: " + gateway.getSerialNo());
		System.out.println("  SIM IMSI: " + gateway.getImsi());
		System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
		System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
		System.out.println();
		
                String data11[] = SMSApplication.data11;
                String data12[] = SMSApplication.data12;
                String data13[] = SMSApplication.data13;
                String data14[] = SMSApplication.data14;
                /* List<String> data1 = ReadCVS1.Name;
                    String [] data11 = data1.toArray(new String[0]);
                List<String> data2 = ReadCVS1.PhoneNo;
                    String [] data12 = data2.toArray(new String[0]);
                List<String> data3 = ReadCVS1.Email;
                    String [] data13 = data3.toArray(new String[0]);
                List<String> data4 = ReadCVS1.Address;
                    String [] data14 = data4.toArray(new String[0]);*/
               
                for(int i=0;i<data12.length;i++){
                    String Smstext = SMSApplication.SMSText;
                    String replace1 = Smstext.replace("{NAME}", data11[i] );
                    String replace2 = replace1.replace("{PHONE}", data12[i] );
                    String replace3 = replace2.replace("{EMAIL}", data13[i] );
                    String replace4 = replace3.replace("{ADDRESS}", data14[i] );
                    OutboundMessage msg = new OutboundMessage(data12[i], replace4);
                    Service.getInstance().sendMessage(msg);
                    System.out.println(msg);
                }
		System.out.println("Now Sleeping - Hit <enter> to terminate.");
		System.in.read();
		Service.getInstance().stopService();
	}

	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(AGateway gateway, OutboundMessage msg)
		{
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}

        public void process(String string, OutboundMessage om) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
	}

}
