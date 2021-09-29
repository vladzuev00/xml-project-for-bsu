package by.bsu.zuevvlad.eighthlab.logic.parser.dom;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.exception.DOMParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.exception.DOMParserParsingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.entitybuilder.XMLEntityDOMBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DOMParser<TypeOfParsedEntity extends Entity> extends AbstractDOMParser<TypeOfParsedEntity>
{
    private DOMParser(final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder)
            throws XMLParserCreatingException
    {
        super(xmlEntityBuilder);
    }

    public static <TypeOfParsedEntity extends Entity> DOMParser<TypeOfParsedEntity> createDOMParser(
            final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder)
            throws DOMParserCreatingException
    {
        try
        {
            return new DOMParser<TypeOfParsedEntity>(xmlEntityBuilder);
        }
        catch(final XMLParserCreatingException cause)
        {
            throw new DOMParserCreatingException(cause);
        }
    }

    @Override
    public final List<TypeOfParsedEntity> parse(final File parsedFile)
            throws DOMParserParsingException
    {
        try
        {
            final DocumentBuilder documentBuilder = this.getDocumentBuilder();
            final Document document = documentBuilder.parse(parsedFile);
            final Element rootElement = document.getDocumentElement();
            final NodeList children = rootElement.getChildNodes();
            final List<TypeOfParsedEntity> parsedEntities = new ArrayList<TypeOfParsedEntity>(children.getLength());
            Node currentNode;
            Element currentChildElement;
            final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder = this.getXmlEntityBuilder();
            for(int i = 0; i < children.getLength(); i++)
            {
                currentNode = children.item(i);
                currentChildElement = (Element)currentNode;
                parsedEntities.add(xmlEntityBuilder.buildEntity(currentChildElement));
            }
            return parsedEntities;
        }
        catch(final SAXException | IOException cause)
        {
            throw new DOMParserParsingException(cause);
        }
    }
}
