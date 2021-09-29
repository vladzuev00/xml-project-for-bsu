package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.XMLFileWriter;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.StAXEntityInjector;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.exception.StAXEntityInjectionException;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.exception.StAXXMLFileWriterWritingException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public final class StAXXMLFileWriter<TypeOfWrittenEntity extends Entity> implements XMLFileWriter<TypeOfWrittenEntity>
{
    private final XMLOutputFactory xmlOutputFactory;
    private final StAXEntityInjector<TypeOfWrittenEntity> stAXEntityInjector;

    public StAXXMLFileWriter(final StAXEntityInjector<TypeOfWrittenEntity> stAXEntityInjector)
    {
        super();
        this.xmlOutputFactory = XMLOutputFactory.newInstance();
        this.stAXEntityInjector = stAXEntityInjector;
    }

    @Override
    public final void writeToXMLFile(final List<TypeOfWrittenEntity> writtenEntities, final File file)
            throws StAXXMLFileWriterWritingException
    {
        StAXXMLFileWriterWritingException mainException = null;
        XMLStreamWriter xmlStreamWriter = null;
        try(final FileOutputStream fileOutputStream = new FileOutputStream(file);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream))
        {
            xmlStreamWriter = this.xmlOutputFactory.createXMLStreamWriter(bufferedOutputStream);
            xmlStreamWriter.writeStartDocument();
            this.stAXEntityInjector.startRootElement(xmlStreamWriter);
            for(final TypeOfWrittenEntity writtenEntity : writtenEntities)
            {
                this.stAXEntityInjector.injectEntity(writtenEntity, xmlStreamWriter);
            }
            this.stAXEntityInjector.endRootElement(xmlStreamWriter);
            xmlStreamWriter.writeEndDocument();
        }
        catch(final IOException | XMLStreamException | StAXEntityInjectionException cause)
        {
            mainException = new StAXXMLFileWriterWritingException(cause);
            throw mainException;
        }
        finally
        {
            try
            {
                if(xmlStreamWriter != null)
                {
                    xmlStreamWriter.close();
                }
            }
            catch(final XMLStreamException exceptionOfClose)
            {
                if(mainException != null)
                {
                    mainException.addSuppressed(exceptionOfClose);
                }
                else
                {
                    throw new StAXXMLFileWriterWritingException(exceptionOfClose);
                }
            }
        }
    }
}
