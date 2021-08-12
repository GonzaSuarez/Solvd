package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Room;
import com.solvd.booking.hotel.RoomReserved;
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

public class RoomReservedParser extends XmlParser<RoomReserved>{

    public RoomReservedParser(){}

    @Override
    public void serializeFile(List<RoomReserved> rooms) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("roomreserveds");
            doc.appendChild(eRoot);

            for (RoomReserved room: rooms) {

                Element eRoomReserved = doc.createElement(room.getClass().getSimpleName());
                eRoot.appendChild(eRoomReserved);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(room.getId())));
                eRoomReserved.setAttributeNode(attr);

                Element ePrice = doc.createElement("price");
                ePrice.appendChild(doc.createTextNode(Float.toString(room.getPrice())));
                eRoomReserved.appendChild(ePrice);

                Element eDescription = doc.createElement("idroom");
                eDescription.appendChild(doc.createTextNode(Integer.toString(room.getIdRoom())));
                eRoomReserved.appendChild(eDescription);

                Element eReservationId = doc.createElement("idreservation");
                eReservationId.appendChild(doc.createTextNode(Integer.toString(room.getIdReservation())));
                eRoomReserved.appendChild(eReservationId);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/roomreserved.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RoomReserved> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<RoomReserved> roomReserveds = new ArrayList<>();
        RoomReserved roomReserved;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("roomreserveds");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                roomReserved = new RoomReserved();
                roomReserved.setId(Integer.parseInt(eElement.getAttribute("id")));
                roomReserved.setPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()));
                roomReserved.setIdRoom(Integer.parseInt(eElement.getElementsByTagName("idroom").item(0).getTextContent()));
                roomReserved.setIdReservation(Integer.parseInt(eElement.getElementsByTagName("idreservation").item(0).getTextContent()));

                roomReserveds.add(roomReserved);
            }
        }
        return roomReserveds;
    }

}
