package by.bsu.zuevvlad.eighthlab.logic.parser.dom;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.XMLParser;
import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.entitybuilder.XMLEntityDOMBuilder;
import by.bsu.zuevvlad.eighthlab.logic.xmlsyntaxanalyzerrorhandler.XMLSyntaxAnalyzeErrorHandler;
import org.xml.sax.ErrorHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractDOMParser<TypeOfParsedEntity extends Entity> implements XMLParser<TypeOfParsedEntity>
{
    private final DocumentBuilder documentBuilder;
    private final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder;

    protected AbstractDOMParser(final XMLEntityDOMBuilder<TypeOfParsedEntity> xmlEntityBuilder)
            throws XMLParserCreatingException
    {
        super();
        this.documentBuilder = AbstractDOMParser.createDocumentBuilder();
        this.xmlEntityBuilder = xmlEntityBuilder;
    }

    private static DocumentBuilder createDocumentBuilder()
            throws XMLParserCreatingException
    {
        try
        {
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setAttribute(AbstractDOMParser.JAXP_SCHEMA_LANGUAGE, AbstractDOMParser.W3C_XML_SCHEMA);
            documentBuilderFactory.setIgnoringElementContentWhitespace(true);
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final ErrorHandler errorHandler = AbstractDOMParser.TYPE_OF_ERROR_HANDLER.getDeclaredConstructor().newInstance();
            documentBuilder.setErrorHandler(errorHandler);
            return documentBuilder;
        }
        catch(final ParserConfigurationException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException cause)
        {
            throw new XMLParserCreatingException("Exception of creating object of class '"
                    + DocumentBuilder.class.getSimpleName() + "'.", cause);
        }
    }

    private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static final Class<? extends ErrorHandler> TYPE_OF_ERROR_HANDLER = XMLSyntaxAnalyzeErrorHandler.class;

    public final DocumentBuilder getDocumentBuilder()
    {
        return this.documentBuilder;
    }

    public final XMLEntityDOMBuilder<TypeOfParsedEntity> getXmlEntityBuilder()
    {
        return this.xmlEntityBuilder;
    }
}
