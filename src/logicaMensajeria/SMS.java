package logicaMensajeria;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal;

import java.net.URI;

public class SMS {
	
	public static final String ACCOUNT_SID = "AC63b4fbfea877727b0f51fc156a2d6744";
	public static final String AUTH_TOKEN = "bb6c41be7bd2d2d7e325303a1d869326";
	
	public SMS () {}
	
	public void enviarSMS(String ptexto, String pnumero) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
	    Message message = Message.creator( 
	            new com.twilio.type.PhoneNumber("+50687350858"),  
	            "MGa28d0034fbf88137d581ecf05feccb68", 
	            ptexto)      
	        .create(); 
	
	    System.out.println(message.getSid());
        System.out.println("Mensaje enviado");

	}
}
