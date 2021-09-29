package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception.XMLFileWriterWritingException;

import java.io.File;
import java.util.List;

public interface XMLFileWriter<TypeOfWrittenEntity extends Entity>
{
    public abstract void writeToXMLFile(final List<TypeOfWrittenEntity> writtenEntities, final File file)
            throws XMLFileWriterWritingException;
}
