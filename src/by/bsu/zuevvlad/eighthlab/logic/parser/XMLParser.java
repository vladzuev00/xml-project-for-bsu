package by.bsu.zuevvlad.eighthlab.logic.parser;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserParsingException;

import java.io.File;
import java.util.List;

@FunctionalInterface
public interface XMLParser<TypeOfParsedEntity extends Entity>
{
    public abstract List<TypeOfParsedEntity> parse(final File parsedFile) throws XMLParserParsingException;
}
