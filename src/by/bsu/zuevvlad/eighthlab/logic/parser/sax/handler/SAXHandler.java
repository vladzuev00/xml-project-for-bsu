package by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler.exception.UnknownTagException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class SAXHandler<TypeOfParsedEntity extends Entity> extends DefaultHandler
{
    private final List<TypeOfParsedEntity> parsedEntities;
    private TypeOfParsedEntity currentParsedEntity;
    private String currentContent;

    public SAXHandler()
    {
        super();
        this.parsedEntities = new ArrayList<TypeOfParsedEntity>();
        this.currentContent = "";
    }

    public final List<TypeOfParsedEntity> getParsedEntities()
    {
        return this.parsedEntities;
    }

    protected final void setCurrentParsedEntity(final TypeOfParsedEntity currentParsedEntity)
    {
        this.currentParsedEntity = currentParsedEntity;
    }

    protected final TypeOfParsedEntity getCurrentParsedEntity()
    {
        return this.currentParsedEntity;
    }

    protected final void setCurrentContent(final String currentContent)
    {
        this.currentContent = currentContent;
    }

    protected final String getCurrentContent()
    {
        return this.currentContent;
    }

    @Override
    public final void startDocument()
    {
        this.parsedEntities.clear();
    }

    @Override
    public abstract void startElement(final String uri, final String localName,
                                      final String qualifiedName, final Attributes attributes);

    @Override
    public final void characters(final char[] characters, final int startCharacter, final int length)
    {
        this.currentContent = String.copyValueOf(characters, startCharacter, length).trim();
    }

    @Override
    public abstract void endElement(final String uri, final String localName, final String qualifiedName)
            throws UnknownTagException;
}
