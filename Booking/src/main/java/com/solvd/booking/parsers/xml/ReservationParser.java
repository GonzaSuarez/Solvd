package com.solvd.booking.parsers.xml;

import com.solvd.booking.hotel.Reservation;
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

public class ReservationParser extends XmlParser<Reservation>{

    public ReservationParser() {

    }

    public void serializeFile(List<Reservation> reservations) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element eRoot = doc.createElement("reservations");
            doc.appendChild(eRoot);

            for (Reservation reservation: reservations) {

                Element eReservation = doc.createElement(reservation.getClass().getSimpleName());
                eRoot.appendChild(eReservation);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(reservation.getId())));
                eReservation.setAttributeNode(attr);

                Element eStartingDate = doc.createElement("startingdate");
                eStartingDate.appendChild(doc.createTextNode(reservation.getStartingDate().toString()));
                eReservation.appendChild(eStartingDate);

                Element eEndingDate = doc.createElement("endingdate");
                eEndingDate.appendChild(doc.createTextNode(reservation.getEndingDate().toString()));
                eReservation.appendChild(eEndingDate);

                Element ePrice = doc.createElement("price");
                ePrice.appendChild(doc.createTextNode(Double.toString(reservation.getPrice())));
                eReservation.appendChild(ePrice);

                Element eDiscount = doc.createElement("discount");
                eDiscount.appendChild(doc.createTextNode(Float.toString(reservation.getDiscount())));
                eReservation.appendChild(eDiscount);

                Element eClient = doc.createElement("client");
                    Element eClientId = doc.createElement("clientid");
                    eClientId.appendChild(doc.createTextNode(Integer.toString(reservation.getClient().getId())));
                    eReservation.appendChild(eClientId);

                    Element eClientFirstName = doc.createElement("clientfirstname");
                    eClientFirstName.appendChild(doc.createTextNode(reservation.getClient().getFirstName()));
                    eReservation.appendChild(eClientFirstName);

                    Element eClientLastName = doc.createElement("clientlastname");
                    eClientFirstName.appendChild(doc.createTextNode(reservation.getClient().getLastName()));
                    eReservation.appendChild(eClientLastName);

                    Element eClientEmail = doc.createElement("clientemail");
                    eClientEmail.appendChild(doc.createTextNode(reservation.getClient().getEmail()));
                    eReservation.appendChild(eClientEmail);

                    Element eClientAddress = doc.createElement("clientaddress");
                    eClientAddress.appendChild(doc.createTextNode(reservation.getClient().getAddress()));
                    eReservation.appendChild(eClientAddress);

                    Element eClientPhone = doc.createElement("clientphone");
                    eClientPhone.appendChild(doc.createTextNode(Long.toString(reservation.getClient().getPhone())));
                    eReservation.appendChild(eClientPhone);

                    Element eClientDetails = doc.createElement("clientdetails");
                    eClientDetails.appendChild(doc.createTextNode(reservation.getClient().getDetails()));
                    eReservation.appendChild(eClientDetails);
                eClient.appendChild(doc.createTextNode("client"));
                eReservation.appendChild(eClient);

                for (UserAccount userAccount : reservation.getClient().getAccounts()) {

                    Element eUserAccountId = doc.createElement("useraccountid");
                    eUserAccountId.appendChild(doc.createTextNode(Integer.toString(userAccount.getId())));
                    eReservation.appendChild(eUserAccountId);

                    Element eUserAccountFirstName = doc.createElement("useraccountfirstname");
                    eUserAccountFirstName.appendChild(doc.createTextNode(userAccount.getFirstName()));
                    eReservation.appendChild(eUserAccountFirstName);

                    Element eUserAccountLastName = doc.createElement("useraccountlasttname");
                    eUserAccountLastName.appendChild(doc.createTextNode(userAccount.getLastName()));
                    eReservation.appendChild(eUserAccountLastName);

                    Element eUserAccountEmail = doc.createElement("useraccountemail");
                    eUserAccountEmail.appendChild(doc.createTextNode(userAccount.getEmail()));
                    eReservation.appendChild(eUserAccountEmail);

                    Element eUserAccountUser = doc.createElement("useraccountuser");
                    eUserAccountUser.appendChild(doc.createTextNode(userAccount.getUser()));
                    eReservation.appendChild(eUserAccountUser);

                    Element eUserAccounPassword = doc.createElement("useraccountpassword");
                    eUserAccounPassword.appendChild(doc.createTextNode(userAccount.getPassword()));
                    eReservation.appendChild(eUserAccounPassword);

                    Element eUserAccountIdCompany = doc.createElement("useraccountidcompany");
                    eUserAccountIdCompany.appendChild(doc.createTextNode(Integer.toString(userAccount.getIdCompany())));
                    eReservation.appendChild(eUserAccountIdCompany);

                }


                eDiscount.appendChild(doc.createTextNode(Float.toString(reservation.getDiscount())));
                eReservation.appendChild(eDiscount);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/reservation.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("reservations");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                reservation = new Reservation();
                reservation.setId(Integer.parseInt(eElement.getAttribute("id")));
                reservation.setDiscount(Float.parseFloat(eElement.getAttribute("discount")));
                reservation.setPrice(Double.parseDouble(eElement.getAttribute("description")));
                reservations.add(reservation);
            }
        }
        return reservations;
    }

}
