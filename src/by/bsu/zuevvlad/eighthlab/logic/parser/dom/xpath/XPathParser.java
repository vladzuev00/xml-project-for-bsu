package by.bsu.zuevvlad.eighthlab.logic.parser.dom.xpath;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.AbstractDOMParser;
import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.xpath.exception.XPathParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.xpath.exception.XPathParserParsingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.entitybuilder.XMLEntityDOMBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class XPathParser<TypeOfParsedEntity extends Entity> extends AbstractDOMParser<TypeOfParsedEntity>
{
    private final XPath xPath;
    private String expressionToFindNodeList;

    private XPathParser(final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder,
                        final XPath xPath, final String expressionToFindNodeList)
            throws XMLParserCreatingException
    {
        super(xmlEntityBuilder);
        this.xPath = xPath;
        this.expressionToFindNodeList = expressionToFindNodeList;
    }

    public static <TypeOfParsedEntity extends Entity> XPathParser<TypeOfParsedEntity> createXPathParser(
            final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder, final String expressionFindNodeList)
            throws XPathParserCreatingException
    {
        try
        {
            final XPathFactory xPathFactory = XPathFactory.newInstance();
            final XPath xPath = xPathFactory.newXPath();
            return new XPathParser<TypeOfParsedEntity>(xmlEntityBuilder, xPath, expressionFindNodeList);
        }
        catch(final XMLParserCreatingException cause)
        {
            throw new XPathParserCreatingException(cause);
        }
    }

    public final void setExpressionToFindNodeList(final String expressionToFindNodeList)
    {
        this.expressionToFindNodeList = expressionToFindNodeList;
    }

    public final String getExpressionToFindNodeList()
    {
        return this.expressionToFindNodeList;
    }

    @Override
    public final List<TypeOfParsedEntity> parse(final File parsedFile) throws XPathParserParsingException
    {
        try
        {
            final DocumentBuilder documentBuilder = this.getDocumentBuilder();
            final Document document = documentBuilder.parse(parsedFile);
            final NodeList nodeList = (NodeList)this.xPath.evaluate(this.expressionToFindNodeList, document,
                    XPathConstants.NODESET);
            final List<TypeOfParsedEntity> parsedEntities = new ArrayList<TypeOfParsedEntity>(nodeList.getLength());
            Node currentNode;
            Element currentElement;
            TypeOfParsedEntity currentParsedEntity;
            final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder = this.getXmlEntityBuilder();
            for(int i = 0; i < nodeList.getLength(); i++)
            {
                currentNode = nodeList.item(i);
                currentElement = (Element)currentNode;
                currentParsedEntity = xmlEntityBuilder.buildEntity(currentElement);
                parsedEntities.add(currentParsedEntity);
            }
            return parsedEntities;
        }
        catch(final SAXException | IOException | XPathExpressionException cause)
        {
            throw new XPathParserParsingException(cause);
        }
    }
}
