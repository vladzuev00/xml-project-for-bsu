package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.mobiletariff;

import by.bsu.zuevvlad.eighthlab.entity.MobileTariff;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.StAXEntityInjector;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.exception.StAXEntityInjectionException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public final class StAXMobileTariffInjector extends StAXEntityInjector<MobileTariff>
{
    public StAXMobileTariffInjector()
    {
        super(StAXMobileTariffInjector.NAME_OF_ROOT_ELEMENT);
    }

    private static final String NAME_OF_ROOT_ELEMENT = "mobile_tariffs";

    @Override
    public final void injectEntity(final MobileTariff injectedMobileTariff, final XMLStreamWriter xmlStreamWriter)
            throws StAXEntityInjectionException
    {
        try
        {
            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector.NAME_OF_TAG_OF_MOBILE_TARIFF);   //<mobile_tariff>

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector.NAME_OF_TAG_OF_ID);
            xmlStreamWriter.writeCharacters(Long.toString(injectedMobileTariff.getId()));
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector.NAME_OF_TAG_OF_NAME_OF_TARIFF);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.getNameOfTariff());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector.NAME_OF_TAG_OF_NAME_OF_OPERATOR);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.getNameOfOperator());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector.NAME_OF_TAG_OF_PAYROLL_PER_MONTH);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.getPayrollPerMonth().toString());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector
                    .NAME_OF_TAG_OF_TYPES_OF_CALLS_AND_THEIR_PRICES_PER_MINUTE);        //<types_of_calls_and_their_prices_per_minute>

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector
                    .NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.findPricePerMinuteOfTypeOfCall(
                    MobileTariff.TypeOfCall.INSIDE_NETWORK).toString());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector
                    .NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.findPricePerMinuteOfTypeOfCall(
                    MobileTariff.TypeOfCall.OUTSIDE_NETWORK).toString());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector
                    .NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.findPricePerMinuteOfTypeOfCall(
                    MobileTariff.TypeOfCall.LANDLINE_PHONE).toString());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement();         //</types_of_calls_and_their_prices_per_minute>

            xmlStreamWriter.writeStartElement(StAXMobileTariffInjector.NAME_OF_TAG_OF_PRICE_FOR_SMS);
            xmlStreamWriter.writeCharacters(injectedMobileTariff.getPriceForSms().toString());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement();         //</mobile_tariff>
        }
        catch(final XMLStreamException cause)
        {
            throw new StAXEntityInjectionException(cause);
        }
    }

    private static final String NAME_OF_TAG_OF_MOBILE_TARIFF = "mobile_tariff";
    private static final String NAME_OF_TAG_OF_ID = "id";
    private static final String NAME_OF_TAG_OF_NAME_OF_TARIFF = "name_of_tariff";
    private static final String NAME_OF_TAG_OF_NAME_OF_OPERATOR = "name_of_operator";
    private static final String NAME_OF_TAG_OF_PAYROLL_PER_MONTH = "payroll_per_month";
    private static final String NAME_OF_TAG_OF_TYPES_OF_CALLS_AND_THEIR_PRICES_PER_MINUTE
            = "types_of_calls_and_their_prices_per_minute";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK = "inside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK = "outside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE = "landline_phone";
    private static final String NAME_OF_TAG_OF_PRICE_FOR_SMS = "price_for_sms";
}
