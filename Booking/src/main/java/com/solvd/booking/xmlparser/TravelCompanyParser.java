package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Hotel;
import com.solvd.booking.hotel.Room;
import com.solvd.booking.travelcompany.Plane;
import com.solvd.booking.travelcompany.TravelCompany;
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

public class TravelCompanyParser extends XmlParser<TravelCompany>{

    public TravelCompanyParser(){}


    @Override
    public void serializeFile(List<TravelCompany> travelscompanies) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("travelcompany");
            doc.appendChild(eRoot);

            for (TravelCompany travelCompany: travelscompanies) {

                Element eTravelCompany = doc.createElement(travelCompany.getClass().getSimpleName());
                eRoot.appendChild(eTravelCompany);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(travelCompany.getId())));
                eTravelCompany.setAttributeNode(attr);

                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(travelCompany.getName()));
                eTravelCompany.appendChild(eName);

                Element eEmail = doc.createElement("email");
                eEmail.appendChild(doc.createTextNode(travelCompany.getEmail()));
                eTravelCompany.appendChild(eEmail);

                for(Plane plane: travelCompany.getPlanes()){

                    Element ePlaneId = doc.createElement("planeid");
                    ePlaneId.appendChild(doc.createTextNode(Integer.toString(plane.getId())));
                    eTravelCompany.appendChild(ePlaneId);

                    Element eCapacity = doc.createElement("capacity");
                    eCapacity.appendChild(doc.createTextNode(Integer.toString(plane.getCapacity())));
                    eTravelCompany.appendChild(eCapacity);

                    Element eTravelCompanyId = doc.createElement("travelcompanyid");
                    eTravelCompanyId.appendChild(doc.createTextNode(Integer.toString(plane.getTravelCompanyId())));
                    eTravelCompany.appendChild(eTravelCompanyId);

                    Element eTravelCompanyCityId = doc.createElement("travelcompanycityid");
                    eTravelCompanyCityId.appendChild(doc.createTextNode(Integer.toString(plane.getTravelCompanyCityId())));
                    eTravelCompany.appendChild(eTravelCompanyCityId);
                }

                for(Hotel hotel: travelCompany.getHotels()){

                    Element eHotelId = doc.createElement("hotelid");
                    eHotelId.appendChild(doc.createTextNode(Integer.toString(hotel.getId())));
                    eTravelCompany.appendChild(eHotelId);

                    Element eHotelName = doc.createElement("name");
                    eHotelName.appendChild(doc.createTextNode(hotel.getName()));
                    eTravelCompany.appendChild(eHotelName);

                    Element eDescription = doc.createElement("description");
                    eDescription.appendChild(doc.createTextNode(hotel.getDescription()));
                    eTravelCompany.appendChild(eDescription);

                    Element eCityId = doc.createElement("cityid");
                    eCityId.appendChild(doc.createTextNode(Integer.toString(hotel.getCityId())));
                    eTravelCompany.appendChild(eCityId);

                    Element eRooms = doc.createElement("rooms");
                    eRooms.appendChild(doc.createTextNode("rooms"));
                    eTravelCompany.appendChild(eRooms);
                    for (Room r : hotel.getRooms()) {
                        Element eRoomId = doc.createElement("roomid");
                        eRoomId.appendChild(doc.createTextNode(Integer.toString(r.getId())));
                        eTravelCompany.appendChild(eRoomId);

                        Element eRoomName = doc.createElement("roomname");
                        eRoomName.appendChild(doc.createTextNode(r.getRoomName()));
                        eTravelCompany.appendChild(eRoomName);

                        Element eRoomHotelId = doc.createElement("roomhotelid");
                        eRoomHotelId.appendChild(doc.createTextNode(Integer.toString(r.getIdHotel())));
                        eTravelCompany.appendChild(eRoomHotelId);

                        Element ePrice = doc.createElement("roomprice");
                        ePrice.appendChild(doc.createTextNode(Double.toString(r.getPrice())));
                        eTravelCompany.appendChild(ePrice);

                        Element eRoomDescription = doc.createElement("roomname");
                        eRoomDescription.appendChild(doc.createTextNode(r.getDescription()));
                        eTravelCompany.appendChild(eRoomDescription);
                    }
                }
                for (UserAccount userAccount : travelCompany.getUserAccounts()) {

                    Element eUserAccountId = doc.createElement("useraccountid");
                    eUserAccountId.appendChild(doc.createTextNode(Integer.toString(userAccount.getId())));
                    eTravelCompany.appendChild(eUserAccountId);

                    Element eUserAccountFirstName = doc.createElement("useraccountfirstname");
                    eUserAccountFirstName.appendChild(doc.createTextNode(userAccount.getFirstName()));
                    eTravelCompany.appendChild(eUserAccountFirstName);

                    Element eUserAccountLastName = doc.createElement("useraccountlasttname");
                    eUserAccountLastName.appendChild(doc.createTextNode(userAccount.getLastName()));
                    eTravelCompany.appendChild(eUserAccountLastName);

                    Element eUserAccountEmail = doc.createElement("useraccountemail");
                    eUserAccountEmail.appendChild(doc.createTextNode(userAccount.getEmail()));
                    eTravelCompany.appendChild(eUserAccountEmail);

                    Element eUserAccountUser = doc.createElement("useraccountuser");
                    eUserAccountUser.appendChild(doc.createTextNode(userAccount.getUser()));
                    eTravelCompany.appendChild(eUserAccountUser);

                    Element eUserAccounPassword = doc.createElement("useraccountpassword");
                    eUserAccounPassword.appendChild(doc.createTextNode(userAccount.getPassword()));
                    eTravelCompany.appendChild(eUserAccounPassword);

                    Element eUserAccountIdCompany = doc.createElement("useraccountidcompany");
                    eUserAccountIdCompany.appendChild(doc.createTextNode(Integer.toString(userAccount.getIdCompany())));
                    eTravelCompany.appendChild(eUserAccountIdCompany);

                }


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/travelcompany.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TravelCompany> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<TravelCompany> travelCompanies = new ArrayList<>();
        TravelCompany travelCompany;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("travelcompanies");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                travelCompany = new TravelCompany();
                travelCompany.setId(Integer.parseInt(eElement.getAttribute("id")));
                travelCompany.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                travelCompany.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());

                travelCompanies.add(travelCompany);
            }
        }
        return travelCompanies;
    }

}
