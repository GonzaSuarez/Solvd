package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Hotel;
import com.solvd.booking.hotel.Room;
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

public class HotelParser extends XmlParser<Hotel>{

    public HotelParser() {}

    @Override
    public void serializeFile(List<Hotel> hotels) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("hotels");
            doc.appendChild(eRoot);

            for (Hotel hotel: hotels) {

                Element eHotel = doc.createElement(hotel.getClass().getSimpleName());
                eRoot.appendChild(eHotel);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(hotel.getId())));
                eHotel.setAttributeNode(attr);

                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(hotel.getName()));
                eHotel.appendChild(eName);

                Element eDescription = doc.createElement("description");
                eDescription.appendChild(doc.createTextNode(hotel.getDescription()));
                eHotel.appendChild(eDescription);

                Element eCityId = doc.createElement("cityid");
                eCityId.appendChild(doc.createTextNode(Integer.toString(hotel.getCityId())));
                eHotel.appendChild(eCityId);

                Element eRooms = doc.createElement("rooms");
                eRooms.appendChild(doc.createTextNode("rooms"));
                eHotel.appendChild(eRooms);
                for (Room r : hotel.getRooms()) {
                    Element eRoomId = doc.createElement("roomid");
                    eRoomId.appendChild(doc.createTextNode(Integer.toString(r.getId())));
                    eHotel.appendChild(eRoomId);

                    Element eRoomName = doc.createElement("roomname");
                    eRoomName.appendChild(doc.createTextNode(r.getRoomName()));
                    eHotel.appendChild(eRoomName);

                    Element eRoomHotelId = doc.createElement("roomhotelid");
                    eRoomHotelId.appendChild(doc.createTextNode(Integer.toString(r.getIdHotel())));
                    eHotel.appendChild(eRoomHotelId);

                    Element ePrice = doc.createElement("roomprice");
                    ePrice.appendChild(doc.createTextNode(Double.toString(r.getPrice())));
                    eHotel.appendChild(ePrice);

                    Element eRoomDescription = doc.createElement("roomname");
                    eRoomDescription.appendChild(doc.createTextNode(r.getDescription()));
                    eHotel.appendChild(eRoomDescription);
                }

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/hotel.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("hotels");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                hotel = new Hotel();
                hotel.setId(Integer.parseInt(eElement.getAttribute("id")));
                hotel.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                hotel.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());

                hotels.add(hotel);
            }
        }
        return hotels;
    }
}
