package com.solvd.booking.xmlparser;

import com.solvd.booking.travelcompany.UserAccount;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountParser extends XmlParser<UserAccount>{

    public UserAccountParser(){}


    @Override
    public void serializeFile(List<UserAccount> userAccounts) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("rooms");
            doc.appendChild(eRoot);

            for (UserAccount userAccount: userAccounts) {

                Element eUserAccount = doc.createElement(userAccount.getClass().getSimpleName());
                eRoot.appendChild(eUserAccount);

                Element eUserAccountId = doc.createElement("useraccountid");
                eUserAccountId.appendChild(doc.createTextNode(Integer.toString(userAccount.getId())));
                eUserAccount.appendChild(eUserAccountId);

                Element eUserAccountFirstName = doc.createElement("useraccountfirstname");
                eUserAccountFirstName.appendChild(doc.createTextNode(userAccount.getFirstName()));
                eUserAccount.appendChild(eUserAccountFirstName);

                Element eUserAccountLastName = doc.createElement("useraccountlasttname");
                eUserAccountLastName.appendChild(doc.createTextNode(userAccount.getLastName()));
                eUserAccount.appendChild(eUserAccountLastName);

                Element eUserAccountEmail = doc.createElement("useraccountemail");
                eUserAccountEmail.appendChild(doc.createTextNode(userAccount.getEmail()));
                eUserAccount.appendChild(eUserAccountEmail);

                Element eUserAccountUser = doc.createElement("useraccountuser");
                eUserAccountUser.appendChild(doc.createTextNode(userAccount.getUser()));
                eUserAccount.appendChild(eUserAccountUser);

                Element eUserAccounPassword = doc.createElement("useraccountpassword");
                eUserAccounPassword.appendChild(doc.createTextNode(userAccount.getPassword()));
                eUserAccount.appendChild(eUserAccounPassword);

                Element eUserAccountIdCompany = doc.createElement("useraccountidcompany");
                eUserAccountIdCompany.appendChild(doc.createTextNode(Integer.toString(userAccount.getIdCompany())));
                eUserAccount.appendChild(eUserAccountIdCompany);


            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/useraccount.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserAccount> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<UserAccount> hotels = new ArrayList<>();
        UserAccount userAccount;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("useraccounts");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                userAccount = new UserAccount();
                userAccount.setId(Integer.parseInt(eElement.getAttribute("id")));
                userAccount.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                userAccount.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                userAccount.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                userAccount.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
                userAccount.setUser(eElement.getElementsByTagName("user").item(0).getTextContent());
                userAccount.setIdCompany(Integer.parseInt(eElement.getElementsByTagName("idcompany").item(0).getTextContent()));

                hotels.add(userAccount);
            }
        }
        return hotels;
    }

}
