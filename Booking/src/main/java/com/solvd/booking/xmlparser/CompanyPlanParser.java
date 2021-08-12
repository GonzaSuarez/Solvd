package com.solvd.booking.xmlparser;

import com.solvd.booking.hotel.Room;
import com.solvd.booking.places.City;
import com.solvd.booking.travelcompany.CompanyPlan;
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

public class CompanyPlanParser extends XmlParser<CompanyPlan>{

    public CompanyPlanParser(){}


    @Override
    public void serializeFile(List<CompanyPlan> companyPlans) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("companyplan");
            doc.appendChild(eRoot);

            for (CompanyPlan companyPlan: companyPlans) {

                Element eCity = doc.createElement(companyPlan.getClass().getSimpleName());
                eRoot.appendChild(eCity);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(companyPlan.getId())));
                eCity.setAttributeNode(attr);

                Element eIdPlan = doc.createElement("idplan");
                eIdPlan.appendChild(doc.createTextNode(Integer.toString(companyPlan.getIdPlan())));
                eCity.appendChild(eIdPlan);

                Element eIdTravelCompany = doc.createElement("idtravelcompany");
                eIdTravelCompany.appendChild(doc.createTextNode(Integer.toString(companyPlan.getIdPlan())));
                eCity.appendChild(eIdTravelCompany);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/companyplan.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CompanyPlan> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<CompanyPlan> companyPlans = new ArrayList<>();
        CompanyPlan companyPlan;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("companyplan");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                companyPlan = new CompanyPlan();
                companyPlan.setId(Integer.parseInt(eElement.getAttribute("id")));
                companyPlan.setIdPlan(Integer.parseInt(eElement.getElementsByTagName("idplan").item(0).getTextContent()));
                companyPlan.setIdTravelCompany(Integer.parseInt(eElement.getElementsByTagName("idtravelcompany").item(0).getTextContent()));

                companyPlans.add(companyPlan);
            }
        }
        return companyPlans;
    }



}
