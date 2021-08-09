package com.solvd.booking.xmlparser;

import com.solvd.booking.main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.util.List;

public abstract class XmlParser<T> {

    protected File file;
    protected Document doc;
    protected static final Logger log = LogManager.getLogger(Main.class);

    public XmlParser(File file) {
        this.file = file;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public abstract void serializeFile(T serializable);
    public abstract List<T> deserializeFile() throws ParserConfigurationException, IOException, SAXException;
}
