package com.solvd.booking.parsers.xml;

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

public class RoomParser extends XmlParser<Room>{

    public RoomParser() {}

    @Override
    public void serializeFile(List<Room> rooms) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("rooms");
            doc.appendChild(eRoot);

            for (Room room: rooms) {

                Element eHotel = doc.createElement(room.getClass().getSimpleName());
                eRoot.appendChild(eHotel);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(room.getId())));
                eHotel.setAttributeNode(attr);

                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(room.getRoomName()));
                eHotel.appendChild(eName);

                Element eDescription = doc.createElement("description");
                eDescription.appendChild(doc.createTextNode(room.getDescription()));
                eHotel.appendChild(eDescription);

                Element eCityId = doc.createElement("hotelid");
                eCityId.appendChild(doc.createTextNode(Integer.toString(room.getIdHotel())));
                eHotel.appendChild(eCityId);

                Element ePrice = doc.createElement("price");
                ePrice.appendChild(doc.createTextNode(Double.toString(room.getPrice())));
                eHotel.appendChild(ePrice);


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/room.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Room> rooms = new ArrayList<>();
        Room room;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("rooms");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                room = new Room();
                room.setId(Integer.parseInt(eElement.getAttribute("id")));
                room.setRoomName(eElement.getElementsByTagName("name").item(0).getTextContent());
                room.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
                room.setIdHotel(Integer.parseInt(eElement.getElementsByTagName("idhotel").item(0).getTextContent()));
                room.setPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()));

                rooms.add(room);
            }
        }
        return rooms;
    }

}
