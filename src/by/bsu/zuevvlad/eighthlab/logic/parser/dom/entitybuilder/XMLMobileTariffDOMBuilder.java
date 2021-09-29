package by.bsu.zuevvlad.eighthlab.logic.parser.dom.entitybuilder;

import by.bsu.zuevvlad.eighthlab.entity.MobileTariff;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class XMLMobileTariffDOMBuilder implements XMLEntityDOMBuilder<MobileTariff>
{
    public XMLMobileTariffDOMBuilder()
    {
        super();
    }

    @Override
    public final MobileTariff buildEntity(final Element elementOfXML)
    {
        final long idOfBuiltEntity = XMLMobileTariffDOMBuilder.findId(elementOfXML);
        final String nameOfTariff = XMLMobileTariffDOMBuilder.findNameOfTariff(elementOfXML);
        final String nameOfOperator = XMLMobileTariffDOMBuilder.findNameOfOperator(elementOfXML);
        final BigDecimal payrollPerMonth = XMLMobileTariffDOMBuilder.findPayrollPerMonth(elementOfXML);
        final Map<MobileTariff.TypeOfCall, BigDecimal> typesOfCallsAndTheirPricesPerMinute = XMLMobileTariffDOMBuilder
                .findTypesOfCallsAndTheirPricesPerMinute(elementOfXML);
        final BigDecimal priceForSms = XMLMobileTariffDOMBuilder.findPriceForSms(elementOfXML);
        return new MobileTariff(idOfBuiltEntity, nameOfTariff, nameOfOperator, payrollPerMonth,
                typesOfCallsAndTheirPricesPerMinute, priceForSms);
    }

    private static long findId(final Element elementOfXML)
    {
        final NodeList nodeList = elementOfXML.getElementsByTagName(XMLMobileTariffDOMBuilder.NAME_OF_TAG_OF_ID);
        final Node nodeOfId = nodeList.item(XMLMobileTariffDOMBuilder.INDEX_OF_ID_IN_NODE_LIST_OF_TAG_OF_ID);
        final String descriptionOfId = nodeOfId.getTextContent().trim();
        return Long.parseLong(descriptionOfId);
    }

    private static final String NAME_OF_TAG_OF_ID = "id";
    private static final int INDEX_OF_ID_IN_NODE_LIST_OF_TAG_OF_ID = 0;

    private static String findNameOfTariff(final Element elementOfXML)
    {
        final NodeList nodeList = elementOfXML.getElementsByTagName(
                XMLMobileTariffDOMBuilder.NAME_OF_TAG_OF_NAME_OF_TARIFF);
        final Node nodeOfNameOfTariff = nodeList.item(XMLMobileTariffDOMBuilder
                .INDEX_OF_NAME_OF_TARIFF_IN_NODE_LIST_OF_TAG_OF_NAME_OF_TARIFF);
        return nodeOfNameOfTariff.getTextContent().trim();
    }

    private static final String NAME_OF_TAG_OF_NAME_OF_TARIFF = "name_of_tariff";
    private static final int INDEX_OF_NAME_OF_TARIFF_IN_NODE_LIST_OF_TAG_OF_NAME_OF_TARIFF = 0;

    private static String findNameOfOperator(final Element elementOfXML)
    {
        final NodeList nodeList = elementOfXML.getElementsByTagName(
                XMLMobileTariffDOMBuilder.NAME_OF_TAG_OF_NAME_OF_OPERATOR);
        final Node nodeOfNameOfOperator = nodeList.item(XMLMobileTariffDOMBuilder
                .INDEX_OF_NAME_OF_OPERATOR_IN_NODE_LIST_OF_TAG_OF_NAME_OF_OPERATOR);
        return nodeOfNameOfOperator.getTextContent().trim();
    }

    private static final String NAME_OF_TAG_OF_NAME_OF_OPERATOR = "name_of_operator";
    private static final int INDEX_OF_NAME_OF_OPERATOR_IN_NODE_LIST_OF_TAG_OF_NAME_OF_OPERATOR = 0;

    private static BigDecimal findPayrollPerMonth(final Element elementOfXML)
    {
        final NodeList nodeList = elementOfXML.getElementsByTagName(XMLMobileTariffDOMBuilder
                .NAME_OF_TAG_OF_PAYROLL_PER_MONTH);
        final Node nodeOfPayrollPerMonth = nodeList.item(XMLMobileTariffDOMBuilder
                .INDEX_OF_PAYROLL_PER_MONTH_IN_NODE_LIST_OF_TAG_OF_PAYROLL_PER_MONTH);
        final String descriptionOfPayrollPerMonth = nodeOfPayrollPerMonth.getTextContent().trim();
        return new BigDecimal(descriptionOfPayrollPerMonth);
    }

    private static final String NAME_OF_TAG_OF_PAYROLL_PER_MONTH = "payroll_per_month";
    private static final int INDEX_OF_PAYROLL_PER_MONTH_IN_NODE_LIST_OF_TAG_OF_PAYROLL_PER_MONTH = 0;

    private static Map<MobileTariff.TypeOfCall, BigDecimal> findTypesOfCallsAndTheirPricesPerMinute(
            final Element elementOfXML)
    {
        NodeList nodeList = elementOfXML.getElementsByTagName(XMLMobileTariffDOMBuilder
                .NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK);
        final Node nodeOfPricePerMinuteOfCallInsideNetwork = nodeList.item(0);
        final String descriptionOfPricePerMinuteOfCallInsideNetwork = nodeOfPricePerMinuteOfCallInsideNetwork
                .getTextContent().trim();
        final BigDecimal pricePerMinuteOfCallInsideNetwork = new BigDecimal(
                descriptionOfPricePerMinuteOfCallInsideNetwork);

        nodeList = elementOfXML.getElementsByTagName(XMLMobileTariffDOMBuilder
                .NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK);
        final Node nodeOfPricePerMinuteOfCallOutsideNetwork = nodeList.item(0);
        final String descriptionOfPricePerMinuteOfCallOutsideNetwork = nodeOfPricePerMinuteOfCallOutsideNetwork.
                getTextContent().trim();
        final BigDecimal pricePerMinuteOfCallOutsideNetwork = new BigDecimal(
                descriptionOfPricePerMinuteOfCallOutsideNetwork);

        nodeList = elementOfXML.getElementsByTagName(XMLMobileTariffDOMBuilder
                .NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE);
        final Node nodeOfPricePerMinuteOfCallOnLandlinePhone = nodeList.item(0);
        final String descriptionOfPricePerMinuteOfCallOnLandlinePhone
                = nodeOfPricePerMinuteOfCallOnLandlinePhone.getTextContent().trim();
        final BigDecimal pricePerMinuteOfCallOnLandlinePhone = new BigDecimal(
                descriptionOfPricePerMinuteOfCallOnLandlinePhone);

        final Map<MobileTariff.TypeOfCall, BigDecimal> typesOfCallsAndTheirPricesPerMinute
                = new HashMap<MobileTariff.TypeOfCall, BigDecimal>();
        typesOfCallsAndTheirPricesPerMinute.put(MobileTariff.TypeOfCall.INSIDE_NETWORK,
                pricePerMinuteOfCallInsideNetwork);
        typesOfCallsAndTheirPricesPerMinute.put(MobileTariff.TypeOfCall.OUTSIDE_NETWORK,
                pricePerMinuteOfCallOutsideNetwork);
        typesOfCallsAndTheirPricesPerMinute.put(MobileTariff.TypeOfCall.LANDLINE_PHONE,
                pricePerMinuteOfCallOnLandlinePhone);

        return typesOfCallsAndTheirPricesPerMinute;
    }

    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK = "inside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK = "outside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE = "landline_phone";

    private static BigDecimal findPriceForSms(final Element elementOfXML)
    {
        final NodeList nodeList = elementOfXML.getElementsByTagName(
                XMLMobileTariffDOMBuilder.NAME_OF_TAG_OF_PRICE_FOR_SMS);
        final Node nodeOfPriceForSms = nodeList.item(XMLMobileTariffDOMBuilder
                .INDEX_OF_PRICE_FOR_SMS_IN_NODE_LIST_OF_TAG_OF_PRICE_FOR_SMS);
        final String descriptionOfPriceForSms = nodeOfPriceForSms.getTextContent().trim();
        return new BigDecimal(descriptionOfPriceForSms);
    }

    private static final String NAME_OF_TAG_OF_PRICE_FOR_SMS = "price_for_sms";
    private static final int INDEX_OF_PRICE_FOR_SMS_IN_NODE_LIST_OF_TAG_OF_PRICE_FOR_SMS = 0;
}
