package com.solvd.booking.parsers.xml;

import com.solvd.booking.hotel.User;
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

public class UserParser extends XmlParser<User>{

    public UserParser(){}

    @Override
    public void serializeFile(List<User> users) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("users");
            doc.appendChild(eRoot);

            for (User user: users) {

                Element eUser = doc.createElement(user.getClass().getSimpleName());
                eRoot.appendChild(eUser);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(user.getId())));
                eUser.setAttributeNode(attr);

                Element eUserFirstName = doc.createElement("firstname");
                eUserFirstName.appendChild(doc.createTextNode(user.getFirstName()));
                eUser.appendChild(eUserFirstName);

                Element eUserLastName = doc.createElement("lasttname");
                eUserLastName.appendChild(doc.createTextNode(user.getLastName()));
                eUser.appendChild(eUserLastName);

                Element eUserEmail = doc.createElement("email");
                eUserEmail.appendChild(doc.createTextNode(user.getEmail()));
                eUser.appendChild(eUserEmail);

                Element eUserAddres = doc.createElement("address");
                eUserAddres.appendChild(doc.createTextNode(user.getAddress()));
                eUser.appendChild(eUserAddres);

                Element eUserDetails = doc.createElement("details");
                eUserDetails.appendChild(doc.createTextNode(user.getDetails()));
                eUser.appendChild(eUserDetails);

                Element eUserPhone = doc.createElement("useremail");
                eUserPhone.appendChild(doc.createTextNode(Integer.toString(user.getPhone())));
                eUser.appendChild(eUserPhone);

                for (UserAccount userAccount : user.getAccounts()) {

                    Element eUserAccountId = doc.createElement("useraccountid");
                    eUserAccountId.appendChild(doc.createTextNode(Integer.toString(userAccount.getId())));
                    eUser.appendChild(eUserAccountId);

                    Element eUserAccountFirstName = doc.createElement("useraccountfirstname");
                    eUserAccountFirstName.appendChild(doc.createTextNode(userAccount.getFirstName()));
                    eUser.appendChild(eUserAccountFirstName);

                    Element eUserAccountLastName = doc.createElement("useraccountlasttname");
                    eUserAccountLastName.appendChild(doc.createTextNode(userAccount.getLastName()));
                    eUser.appendChild(eUserAccountLastName);

                    Element eUserAccountEmail = doc.createElement("useraccountemail");
                    eUserAccountEmail.appendChild(doc.createTextNode(userAccount.getEmail()));
                    eUser.appendChild(eUserAccountEmail);

                    Element eUserAccountUser = doc.createElement("useraccountuser");
                    eUserAccountUser.appendChild(doc.createTextNode(userAccount.getUser()));
                    eUser.appendChild(eUserAccountUser);

                    Element eUserAccounPassword = doc.createElement("useraccountpassword");
                    eUserAccounPassword.appendChild(doc.createTextNode(userAccount.getPassword()));
                    eUser.appendChild(eUserAccounPassword);

                    Element eUserAccountIdCompany = doc.createElement("useraccountidcompany");
                    eUserAccountIdCompany.appendChild(doc.createTextNode(Integer.toString(userAccount.getIdCompany())));
                    eUser.appendChild(eUserAccountIdCompany);

                }


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/user.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<User> users = new ArrayList<>();
        User user;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("users");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                user = new User();
                user.setId(Integer.parseInt(eElement.getAttribute("id")));
                user.setId(Integer.parseInt(eElement.getAttribute("id")));
                user.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                user.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                user.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                user.setDetails(eElement.getElementsByTagName("details").item(0).getTextContent());
                user.setPhone(Integer.parseInt(eElement.getElementsByTagName("phone").item(0).getTextContent()));

                users.add(user);
            }
        }
        return users;
    }

}
