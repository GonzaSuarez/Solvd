package com.solvd.booking.parsers.xml;

import com.solvd.booking.places.City;
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

public class CityParser extends XmlParser<City> {

    public CityParser(){}


    @Override
    public void serializeFile(List<City> cities) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("cities");
            doc.appendChild(eRoot);

            for (City city: cities) {

                Element eCity = doc.createElement(city.getClass().getSimpleName());
                eRoot.appendChild(eCity);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(city.getId())));
                eCity.setAttributeNode(attr);

                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(city.getName()));
                eCity.appendChild(eName);

                Element ePostalCode = doc.createElement("postalcode");
                ePostalCode.appendChild(doc.createTextNode(city.getPostalCode()));
                eCity.appendChild(ePostalCode);

                Element eCountryId = doc.createElement("countryid");
                eCountryId.appendChild(doc.createTextNode(Integer.toString(city.getCountryId())));
                eCity.appendChild(eCountryId);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/city.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<City> cities = new ArrayList<>();
        City city;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("cities");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                city = new City();
                city.setId(Integer.parseInt(eElement.getAttribute("id")));
                city.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                city.setPostalCode(eElement.getElementsByTagName("postalcode").item(0).getTextContent());
                city.setCountryId(Integer.parseInt(eElement.getElementsByTagName("countryid").item(0).getTextContent()));

                cities.add(city);
            }
        }
        return cities;
    }


}
