package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Room;
import com.solvd.booking.travelcompany.Plane;
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

public class PlaneParser extends XmlParser<Plane>{

    public PlaneParser(){}


    @Override
    public void serializeFile(List<Plane> planes) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("planes");
            doc.appendChild(eRoot);

            for (Plane plane: planes) {

                Element eHotel = doc.createElement(plane.getClass().getSimpleName());
                eRoot.appendChild(eHotel);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(plane.getId())));
                eHotel.setAttributeNode(attr);

                Element eCapacity = doc.createElement("capacity");
                eCapacity.appendChild(doc.createTextNode(Integer.toString(plane.getCapacity())));
                eHotel.appendChild(eCapacity);

                Element eTravelCompanyId = doc.createElement("travelcompanyid");
                eTravelCompanyId.appendChild(doc.createTextNode(Integer.toString(plane.getTravelCompanyId())));
                eHotel.appendChild(eTravelCompanyId);

                Element eTravelCompanyCityId = doc.createElement("travelcompanycityid");
                eTravelCompanyCityId.appendChild(doc.createTextNode(Integer.toString(plane.getTravelCompanyCityId())));
                eHotel.appendChild(eTravelCompanyCityId);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/planes.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plane> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Plane> planes = new ArrayList<>();
        Plane plane;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("planes");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                plane = new Plane();
                plane.setId(Integer.parseInt(eElement.getAttribute("id")));
                plane.setCapacity(Integer.parseInt(eElement.getElementsByTagName("capacity").item(0).getTextContent()));
                plane.setCapacity(Integer.parseInt(eElement.getElementsByTagName("travelcompanyid").item(0).getTextContent()));
                plane.setCapacity(Integer.parseInt(eElement.getElementsByTagName("travelcompanycityid").item(0).getTextContent()));

                planes.add(plane);
            }
        }
        return planes;
    }

}
