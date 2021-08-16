package com.solvd.booking.parsers.xml;

import com.solvd.booking.main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class XmlParser<T> {

    protected File file;
    protected static final Logger log = LogManager.getLogger(Main.class);

    public XmlParser() {}

    public abstract void serializeFile(List<T> serializable);
    public abstract List<T> deserializeFile(File file) throws ParserConfigurationException, IOException, SAXException;
}
