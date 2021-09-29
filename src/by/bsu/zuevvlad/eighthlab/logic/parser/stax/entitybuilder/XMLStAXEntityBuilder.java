package by.bsu.zuevvlad.eighthlab.logic.parser.stax.entitybuilder;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.exception.StAXParserParsingException;

import javax.xml.stream.XMLStreamReader;

public abstract class XMLStAXEntityBuilder<TypeOfBuildEntity extends Entity>
{
    private final String nameOfTagOfParsedEntity;

    public XMLStAXEntityBuilder(final String nameOfTagOfParsedEntity)
    {
        super();
        this.nameOfTagOfParsedEntity = nameOfTagOfParsedEntity;
    }

    public final String getNameOfTagOfParsedEntity()
    {
        return this.nameOfTagOfParsedEntity;
    }

    public abstract TypeOfBuildEntity buildEntity(final XMLStreamReader xmlStreamReader)
            throws StAXParserParsingException;
}
