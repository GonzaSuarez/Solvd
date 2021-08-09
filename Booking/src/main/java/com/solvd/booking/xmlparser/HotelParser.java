package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Hotel;
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

    public HotelParser(File file) {
        super(file);
    }

    @Override
    public void serializeFile(Hotel hotel) {
        try{
            Element eRoot = doc.createElement("hotels");
            doc.appendChild(eRoot);
            
            Element eHotel = doc.createElement(hotel.getClass().toString());
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
    public List<Hotel> deserializeFile() throws ParserConfigurationException, IOException, SAXException {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Hotel hotel = null;

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
