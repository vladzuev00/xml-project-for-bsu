package by.bsu.zuevvlad.eighthlab.logic.parser.sax;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.XMLParser;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.exception.SAXParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.exception.SAXParserParsingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler.SAXHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class SAXParser<TypeOfParsedEntity extends Entity> implements XMLParser<TypeOfParsedEntity>
{
    private final javax.xml.parsers.SAXParser saxParser;
    private final SAXHandler<TypeOfParsedEntity> saxHandler;

    private SAXParser(final javax.xml.parsers.SAXParser saxParser, final SAXHandler<TypeOfParsedEntity> saxHandler)
    {
        super();
        this.saxParser = saxParser;
        this.saxHandler = saxHandler;
    }

    public static <TypeOfParsedEntity extends Entity> SAXParser<TypeOfParsedEntity> createSAXParser(
            final SAXHandler<TypeOfParsedEntity> saxHandler)
            throws SAXParserCreatingException
    {
        try
        {
            final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setNamespaceAware(true);
            final javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
            return new SAXParser<TypeOfParsedEntity>(saxParser, saxHandler);
        }
        catch(final ParserConfigurationException | SAXException cause)
        {
            throw new SAXParserCreatingException(cause);
        }
    }

    @Override
    public final List<TypeOfParsedEntity> parse(final File parsedFile) throws SAXParserParsingException
    {
        try
        {
            this.saxParser.parse(parsedFile, this.saxHandler);
            return this.saxHandler.getParsedEntities();
        }
        catch(final SAXException | IOException cause)
        {
            throw new SAXParserParsingException(cause);
        }
    }
}
