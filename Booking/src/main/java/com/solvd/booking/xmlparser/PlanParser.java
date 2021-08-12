package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Room;
import com.solvd.booking.places.City;
import com.solvd.booking.travelcompany.Plan;
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

public class PlanParser extends XmlParser<Plan>{
    
    public PlanParser(){}


    @Override
    public void serializeFile(List<Plan> plans) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("plans");
            doc.appendChild(eRoot);

            for (Plan plan: plans) {

                Element eCity = doc.createElement(plan.getClass().getSimpleName());
                eRoot.appendChild(eCity);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(plan.getId())));
                eCity.setAttributeNode(attr);

                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(plan.getName()));
                eCity.appendChild(eName);

                Element eDetails = doc.createElement("details");
                eDetails.appendChild(doc.createTextNode(plan.getDetails()));
                eCity.appendChild(eDetails);

                Element eMinRoom = doc.createElement("minroom");
                eMinRoom.appendChild(doc.createTextNode(Integer.toString(plan.getMinRoom())));
                eCity.appendChild(eMinRoom);

                Element eMaxRoom = doc.createElement("maxroom");
                eMaxRoom.appendChild(doc.createTextNode(Integer.toString(plan.getMaxRoom())));
                eCity.appendChild(eMaxRoom);

                Element eMonthlyPrice = doc.createElement("monthlyprice");
                eMonthlyPrice.appendChild(doc.createTextNode(Integer.toString(plan.getMonthlyPrice())));
                eCity.appendChild(eMonthlyPrice);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/plan.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plan> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Plan> plans = new ArrayList<>();
        Plan plan;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("plans");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                plan = new Plan();
                plan.setId(Integer.parseInt(eElement.getAttribute("id")));
                plan.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                plan.setMinRoom(Integer.parseInt(eElement.getElementsByTagName("minroom").item(0).getTextContent()));
                plan.setMinRoom(Integer.parseInt(eElement.getElementsByTagName("maxroom").item(0).getTextContent()));
                plan.setMinRoom(Integer.parseInt(eElement.getElementsByTagName("monthlyprice").item(0).getTextContent()));
                plan.setDetails(eElement.getElementsByTagName("details").item(0).getTextContent());

                plans.add(plan);
            }
        }
        return plans;
    }


}
