package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.XMLFileWriter;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.entitydocumentinjector.EntityDocumentInjector;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.exception.DOMXMLFileWriterCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.exception.DOMXMLFileWriterWritingException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class DOMXMLFileWriter<TypeOfWrittenEntity extends Entity> implements XMLFileWriter<TypeOfWrittenEntity>
{
    private final Document document;
    private final EntityDocumentInjector<TypeOfWrittenEntity> entityDocumentInjector;

    private DOMXMLFileWriter(final Document document,
                             final EntityDocumentInjector<TypeOfWrittenEntity> entityDocumentInjector)
    {
        this.document = document;
        this.entityDocumentInjector = entityDocumentInjector;
    }

    public static <TypeOfWrittenEntity extends Entity> DOMXMLFileWriter<TypeOfWrittenEntity> createDOMXMLFileBuilder(
            final Class<? extends EntityDocumentInjector<TypeOfWrittenEntity>> typeOfEntityDocumentInjector)
            throws DOMXMLFileWriterCreatingException
    {
        try
        {
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.newDocument();
            final Constructor<? extends EntityDocumentInjector<TypeOfWrittenEntity>> constructorOfEntityDocumentInjector
                    = typeOfEntityDocumentInjector.getConstructor(Document.class);
            final EntityDocumentInjector<TypeOfWrittenEntity> entityDocumentInjector
                    = constructorOfEntityDocumentInjector.newInstance(document);
            return new DOMXMLFileWriter<TypeOfWrittenEntity>(document, entityDocumentInjector);
        }
        catch(final ParserConfigurationException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException cause)
        {
            throw new DOMXMLFileWriterCreatingException(cause);
        }
    }

    @Override
    public final void writeToXMLFile(final List<TypeOfWrittenEntity> writtenEntities, final File file)
            throws DOMXMLFileWriterWritingException
    {
        try(final FileOutputStream fileOutputStream = new FileOutputStream(file);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream))
        {
            for(final TypeOfWrittenEntity writtenEntity : writtenEntities)
            {
                this.entityDocumentInjector.injectEntity(writtenEntity);
            }
            final DOMImplementation domImplementation = this.document.getImplementation();
            final DOMImplementationLS domImplementationLS = (DOMImplementationLS)domImplementation.getFeature(
                    DOMXMLFileWriter.NAME_OF_FEATURE_REQUESTED, DOMXMLFileWriter.VERSION_NUMBER_OF_FEATURE_TO_TEST);
            final LSOutput lsOutput = domImplementationLS.createLSOutput();
            lsOutput.setEncoding(DOMXMLFileWriter.ENCODING_TO_SET);
            lsOutput.setByteStream(bufferedOutputStream);
            final LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
            lsSerializer.getDomConfig().setParameter(DOMXMLFileWriter.NAME_OF_PARAMETER_TO_SET_IN_DOM_CONFIGURATION,
                    DOMXMLFileWriter.VALUE_OF_PARAMETER_TO_SET_IN_DOM_CONFIGURATION);
            lsSerializer.write(this.document, lsOutput);
        }
        catch(final IOException cause)
        {
            throw new DOMXMLFileWriterWritingException(cause);
        }
    }

    private static final String NAME_OF_FEATURE_REQUESTED = "LS";
    private static final String VERSION_NUMBER_OF_FEATURE_TO_TEST = "3.0";
    private static final String ENCODING_TO_SET = "UTF-8";
    private static final String NAME_OF_PARAMETER_TO_SET_IN_DOM_CONFIGURATION = "format-pretty-print";
    private static final boolean VALUE_OF_PARAMETER_TO_SET_IN_DOM_CONFIGURATION = true;
}
