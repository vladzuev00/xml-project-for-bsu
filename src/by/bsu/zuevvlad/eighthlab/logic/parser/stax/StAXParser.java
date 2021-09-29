package by.bsu.zuevvlad.eighthlab.logic.parser.stax;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.XMLParser;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.entitybuilder.XMLStAXEntityBuilder;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.exception.StAXParserParsingException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class StAXParser<TypeOfParsedEntity extends Entity> implements XMLParser<TypeOfParsedEntity>
{
    private final XMLInputFactory xmlInputFactory;
    private final XMLStAXEntityBuilder<TypeOfParsedEntity> xmlStAXEntityBuilder;

    public StAXParser(final XMLStAXEntityBuilder<TypeOfParsedEntity> xmlStAXEntityBuilder)
    {
        super();
        this.xmlInputFactory = XMLInputFactory.newInstance();
        this.xmlStAXEntityBuilder = xmlStAXEntityBuilder;
    }

    @Override
    public final List<TypeOfParsedEntity> parse(final File parsedFile)
            throws StAXParserParsingException
    {
        StAXParserParsingException mainException = null;
        XMLStreamReader xmlStreamReader = null;
        try(final FileInputStream inputStream = new FileInputStream(parsedFile);
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream))
        {
            xmlStreamReader = this.xmlInputFactory.createXMLStreamReader(bufferedInputStream);
            int currentParsingEvent;
            final String nameOfTagOfParsedEntity = this.xmlStAXEntityBuilder.getNameOfTagOfParsedEntity();
            TypeOfParsedEntity currentParsedEntity;
            final List<TypeOfParsedEntity> parsedEntities = new ArrayList<TypeOfParsedEntity>();
            while(xmlStreamReader.hasNext())
            {
                currentParsingEvent = xmlStreamReader.next();
                if(currentParsingEvent == XMLStreamReader.START_ELEMENT && xmlStreamReader.getLocalName().equals(nameOfTagOfParsedEntity))
                {
                    currentParsedEntity = this.xmlStAXEntityBuilder.buildEntity(xmlStreamReader);
                    parsedEntities.add(currentParsedEntity);
                }
            }
            return parsedEntities;
        }
        catch(final IOException | XMLStreamException cause)
        {
            mainException = new StAXParserParsingException(cause);
            throw mainException;
        }
        finally
        {
            try
            {
                if(xmlStreamReader != null)
                {
                    xmlStreamReader.close();
                }
            }
            catch(final XMLStreamException exceptionOfClose)
            {
                if(mainException != null)
                {
                    mainException.addSuppressed(exceptionOfClose);
                    throw mainException;
                }
                else
                {
                    throw new StAXParserParsingException(exceptionOfClose);
                }
            }
        }
    }
}
