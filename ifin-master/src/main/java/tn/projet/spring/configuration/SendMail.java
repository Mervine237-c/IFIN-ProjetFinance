package tn.projet.spring.configuration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.sun.istack.ByteArrayDataSource;


import tn.projet.spring.entities.Contract;

public class SendMail {
	
static String mailtext="Our Agency serves nearly 1000 patients annually by providing a wide range of quality reproductive health care services at our  health centers. We have served women and men of all ages , and our services are provided by licensed health care professionals, including licensed medical doctors, nurse practitioners, and pharmacists.";
	
	public static void email(Contract contract, String typecontract ) {
	   
	    String sender = "dmnstrtncntrct@gmail.com"; //replace this with a valid sender email address
	    String recipient = "firas.jmil@esprit.tn"; //replace this with a valid recipient email address
	    
	    String subject = "Agreement Contract"; //this will be the subject of the email

	    Properties properties = new Properties();
	    //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587"); 
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dmnstrtncntrct@gmail.com", "pispring123");
            }
        });

	    ByteArrayOutputStream outputStream = null;

	    try {           
	        //construct the text body part
	        MimeBodyPart textBodyPart = new MimeBodyPart();
	        textBodyPart.setText(mailtext);

	        
	      //construct the mime multi part
	        MimeMultipart mimeMultipart = new MimeMultipart();
	        
	        
	        //now write the PDF content to the output stream
	        outputStream = new ByteArrayOutputStream();
	        writePdf(outputStream, contract, typecontract);
	        byte[] bytes = outputStream.toByteArray();

	        //construct the pdf body part
	        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
	        MimeBodyPart pdfBodyPart = new MimeBodyPart();
	        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
	        pdfBodyPart.setFileName("Details.pdf");

	        
	        mimeMultipart.addBodyPart(textBodyPart);
	        mimeMultipart.addBodyPart(pdfBodyPart);
	        
	        //create the sender/recipient addresses
	        InternetAddress iaSender = new InternetAddress(sender);
	        InternetAddress iaRecipient = new InternetAddress(recipient);

	        //construct the mime message
	        MimeMessage mimeMessage = new MimeMessage(session);
	        mimeMessage.setSender(iaSender);
	        mimeMessage.setSubject(subject);
	        mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
	      
	        mimeMessage.setContent(mimeMultipart);

	        //send off the email
	        Transport.send(mimeMessage);

	        System.out.println("sent from " + sender + 
	                ", to " + recipient + 
	                "; server = " + "smtp.gmail.com" + ", port = " + "587");         
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        //clean off
	        if(null != outputStream) {
	            try { outputStream.close(); outputStream = null; }
	            catch(Exception ex) { }
	        }
	    }
	}
	
	public static  void writePdf(OutputStream outputStream, Contract contract,String typecontract) throws Exception {
	   java.util.Date dtUtil=new java.util.Date();
	   Date dateToday=new Date(dtUtil.getTime());
		Document document = new Document();
		 PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	    document.open();
	    StringBuilder htmlString = new StringBuilder();
	    htmlString.append(new String("<h1> Agreement Contract </h1> "));
	    htmlString.append(new String("<p> "+mailtext+" </p> "));
	    htmlString.append(new String("<br/> <p> <b> Type : </b>  "+typecontract+" </p> "));
	    htmlString.append(new String("<p> <b> Start Date : </b>  "+contract.getStartDate().toLocaleString()+" </p> "));
	    htmlString.append(new String("<p> <b> End Date : </b>  "+contract.getEndDate().toLocaleString()+" </p> "));
	    htmlString.append(new String("<p> <b> Price : </b>  "+contract.getPrice()+"Dt </p> "));
	    

	    htmlString.append(new String("<br/> <p> <b> Element #1: </b> Offer and Acceptance: The offer in an insurance agreement is provided by the party wanting insurance by submitting a proposal form. If the insurance company agrees to provide insurance, that is acceptance. </p> "));
	    htmlString.append(new String("<p> <b> Element #2: </b> Consideration: Consideration is the exchange of items of value, whether money, services, or goods. In an insurance agreement, the insured pays a premium while the insurer promises a payout in the event of an insurance claim. </p> "));
	    htmlString.append(new String("<p> <b> Element #3: </b> Legal Capacity: Both parties must have the legal capacity to enter a legally enforceable contract. Neither party can be under the influence of alcohol or drugs, mentally impaired, or a minor under eighteen. </p> "));
	    htmlString.append(new String("<p> <b> Element #4: </b> Legal Purpose: If the agreement entails any illegal activities, it is not valid and will not be legally enforceable. </p> "));
	    
	    
	    InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
        document.close();
	    
	    
	   
	}
}
