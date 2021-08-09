package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Hotel;
import com.solvd.booking.hotel.Reservation;
import com.solvd.booking.hotel.User;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationParser extends XmlParser<Reservation>{

    public ReservationParser(File file) {
        super(file);
    }

    public void serializeFile(Reservation hotel) {
        try{
            Element eRoot = doc.createElement("hotels");
            doc.appendChild(eRoot);

            Element eReservation = doc.createElement(hotel.getClass().toString());
            eRoot.appendChild(eReservation);

            Attr attr = doc.createAttribute("id");
            attr.setValue((Integer.toString(hotel.getId())));
            eReservation.setAttributeNode(attr);

            Element ePrice = doc.createElement("price");
            ePrice.appendChild(doc.createTextNode((Double.toString(hotel.getPrice()))));
            eReservation.appendChild(ePrice);

            Element eDescription = doc.createElement("discount");
            eDescription.appendChild(doc.createTextNode((Float.toString(hotel.getDiscount()))));
            eReservation.appendChild(eDescription);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("hotel.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> deserializeFile() throws ParserConfigurationException, IOException, SAXException {
        List<Reservation> hotels = new ArrayList<Reservation>();
        Reservation hotel = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("hotel.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("hotel");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                hotel = new Reservation();
                hotel.setId(Integer.parseInt(eElement.getAttribute("id")));
                hotel.setDiscount(Float.parseFloat(eElement.getAttribute("discount")));
                hotel.setPrice(Double.parseDouble(eElement.getAttribute("description")));
                hotels.add(hotel);
            }
        }
        return hotels;
    }

}
