package com.solvd.booking.parsers.xml;

import com.solvd.booking.places.City;
import com.solvd.booking.places.Country;
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

public class CountryParser extends XmlParser<Country>{

    public CountryParser(){}


    @Override
    public void serializeFile(List<Country> countries) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRoot = doc.createElement("countries");
            doc.appendChild(eRoot);

            for (Country country: countries) {

                Element eCountry = doc.createElement(country.getClass().getSimpleName());
                eRoot.appendChild(eCountry);

                Attr attr = doc.createAttribute("id");
                attr.setValue((Integer.toString(country.getId())));
                eCountry.setAttributeNode(attr);

                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(country.getName()));
                eCountry.appendChild(eName);

                for(City city: country.getCities()){
                    Element eCity = doc.createElement(city.getClass().getSimpleName());
                    eRoot.appendChild(eCity);

                    Attr attri = doc.createAttribute("id");
                    attri.setValue((Integer.toString(city.getId())));
                    eCity.setAttributeNode(attri);

                    Element eRoomName = doc.createElement("name");
                    eRoomName.appendChild(doc.createTextNode(city.getName()));
                    eCity.appendChild(eRoomName);

                    Element ePostalCode = doc.createElement("postalcode");
                    ePostalCode.appendChild(doc.createTextNode(city.getPostalCode()));
                    eCity.appendChild(ePostalCode);

                    Element eCountryId = doc.createElement("countryid");
                    eCountryId.appendChild(doc.createTextNode(Integer.toString(city.getCountryId())));
                    eCity.appendChild(eCountryId);
                }

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/country.xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Country> countries = new ArrayList<>();
        Country country;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("countries");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                country = new Country();
                country.setId(Integer.parseInt(eElement.getAttribute("id")));
                country.setName(eElement.getElementsByTagName("name").item(0).getTextContent());

                countries.add(country);
            }
        }
        return countries;
    }


}
