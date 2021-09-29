package by.bsu.zuevvlad.eighthlab.logic.parser.stax.entitybuilder;

import by.bsu.zuevvlad.eighthlab.entity.MobileTariff;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.exception.StAXParserParsingException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.math.BigDecimal;

public final class XMLStAXMobileTariffBuilder extends XMLStAXEntityBuilder<MobileTariff>
{
    public XMLStAXMobileTariffBuilder()
    {
        super(XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_MOBILE_TARIFF);
    }

    private static final String NAME_OF_TAG_OF_MOBILE_TARIFF = "mobile_tariff";

    @Override
    public final MobileTariff buildEntity(final XMLStreamReader xmlStreamReader)
            throws StAXParserParsingException
    {
        try
        {
            final MobileTariff builtMobileTariff = new MobileTariff();
            int currentParsingEvent;
            final String nameOfTagOfParsedEntity = this.getNameOfTagOfParsedEntity();
            while(xmlStreamReader.hasNext())
            {
                currentParsingEvent = xmlStreamReader.next();
                switch(currentParsingEvent)
                {
                    case XMLStreamReader.START_ELEMENT:
                        switch(xmlStreamReader.getLocalName())
                        {
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_ID:
                                final long id = Long.parseLong(XMLStAXMobileTariffBuilder.readContentOfCurrentTag(
                                        xmlStreamReader));
                                builtMobileTariff.setId(id);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_NAME_OF_TARIFF:
                                final String nameOfTariff = XMLStAXMobileTariffBuilder.readContentOfCurrentTag(
                                        xmlStreamReader);
                                builtMobileTariff.setNameOfTariff(nameOfTariff);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_NAME_OF_OPERATOR:
                                final String nameOfOperator = XMLStAXMobileTariffBuilder.readContentOfCurrentTag(
                                        xmlStreamReader);
                                builtMobileTariff.setNameOfOperator(nameOfOperator);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_PAYROLL_PER_MONTH:
                                final BigDecimal payrollPerMonth = new BigDecimal(
                                        XMLStAXMobileTariffBuilder.readContentOfCurrentTag(xmlStreamReader));
                                builtMobileTariff.setPayrollPerMonth(payrollPerMonth);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK:
                                final BigDecimal pricePerMinuteOfCallInsideNetwork = new BigDecimal(
                                        XMLStAXMobileTariffBuilder.readContentOfCurrentTag(xmlStreamReader));
                                builtMobileTariff.updatePricePerMinuteOfTypeOfCall(MobileTariff.TypeOfCall.INSIDE_NETWORK,
                                        pricePerMinuteOfCallInsideNetwork);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK:
                                final BigDecimal pricePerMinuteOfCallOutsideNetwork = new BigDecimal(
                                        XMLStAXMobileTariffBuilder.readContentOfCurrentTag(xmlStreamReader));
                                builtMobileTariff.updatePricePerMinuteOfTypeOfCall(MobileTariff.TypeOfCall.OUTSIDE_NETWORK,
                                        pricePerMinuteOfCallOutsideNetwork);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE:
                                final BigDecimal pricePerMinuteOfCallOnLandlinePhone = new BigDecimal(
                                        XMLStAXMobileTariffBuilder.readContentOfCurrentTag(xmlStreamReader));
                                builtMobileTariff.updatePricePerMinuteOfTypeOfCall(MobileTariff.TypeOfCall.LANDLINE_PHONE,
                                        pricePerMinuteOfCallOnLandlinePhone);
                                break;
                            case XMLStAXMobileTariffBuilder.NAME_OF_TAG_OF_PRICE_FOR_SMS:
                                final BigDecimal priceForSms = new BigDecimal(
                                        XMLStAXMobileTariffBuilder.readContentOfCurrentTag(xmlStreamReader));
                                builtMobileTariff.setPriceForSms(priceForSms);
                                break;
                        }
                        break;

                    case XMLStreamReader.END_ELEMENT:
                        if(xmlStreamReader.getLocalName().equals(nameOfTagOfParsedEntity))
                        {
                            return builtMobileTariff;
                        }
                        break;
                }
            }
        }
        catch(final XMLStreamException cause)
        {
            throw new StAXParserParsingException(cause);
        }
        throw new StAXParserParsingException("Impossible to finish parse entity. Close tag doesn't exist.");
    }

    private static final String NAME_OF_TAG_OF_ID = "id";
    private static final String NAME_OF_TAG_OF_NAME_OF_TARIFF = "name_of_tariff";
    private static final String NAME_OF_TAG_OF_NAME_OF_OPERATOR = "name_of_operator";
    private static final String NAME_OF_TAG_OF_PAYROLL_PER_MONTH = "payroll_per_month";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK = "inside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK = "outside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE = "landline_phone";
    private static final String NAME_OF_TAG_OF_PRICE_FOR_SMS = "price_for_sms";

    private static String readContentOfCurrentTag(final XMLStreamReader xmlStreamReader)
            throws StAXParserParsingException
    {
        try
        {
            xmlStreamReader.next();
            return xmlStreamReader.getText().trim();
        }
        catch(final XMLStreamException cause)
        {
            throw new StAXParserParsingException(cause);
        }
    }

}
