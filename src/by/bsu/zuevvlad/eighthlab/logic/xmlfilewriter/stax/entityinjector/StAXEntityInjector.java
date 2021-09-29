package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.exception.StAXEntityInjectionException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public abstract class StAXEntityInjector<TypeOfInjectedEntity extends Entity>
{
    private final String nameOfRootElement;

    public StAXEntityInjector(final String nameOfRootElement)
    {
        super();
        this.nameOfRootElement = nameOfRootElement;
    }

    public final void startRootElement(final XMLStreamWriter xmlStreamWriter)
            throws StAXEntityInjectionException
    {
        try
        {
            xmlStreamWriter.writeStartElement(this.nameOfRootElement);
        }
        catch(final XMLStreamException cause)
        {
            throw new StAXEntityInjectionException(cause);
        }
    }

    public abstract void injectEntity(final TypeOfInjectedEntity injectedEntity, final XMLStreamWriter xmlStreamWriter)
            throws StAXEntityInjectionException;

    public final void endRootElement(final XMLStreamWriter xmlStreamWriter)
            throws StAXEntityInjectionException
    {
        try
        {
            xmlStreamWriter.writeEndElement();
        }
        catch(final XMLStreamException cause)
        {
            throw new StAXEntityInjectionException(cause);
        }
    }
}
