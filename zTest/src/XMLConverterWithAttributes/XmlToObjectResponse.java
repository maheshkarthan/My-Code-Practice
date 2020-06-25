package XMLConverterWithAttributes;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlToObjectResponse {

    public static void main(String asrgs[]) {
        try {
            // getting the xml file to read
            File file = new File("C:/Users/mkartan/Desktop/errorResponse.xml");
            // creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(WorldPayCardDepositErrorResponse.class);
            // creating the unmarshall object
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            
           /* 
            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource("C:/Users/mkartan/Desktop/errorResponse.xml"));
            */
            // calling the unmarshall method
            WorldPayCardDepositErrorResponse student = (WorldPayCardDepositErrorResponse) unmarshallerObj.unmarshal(file);
            System.out.println(student.getResponse().getError().getErrorMsg().trim() + " " + student.getResponse().getError().getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}