package by.bsu.zuevvlad.eighthlab.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MobileTariff extends Entity
{
    private String nameOfTariff;
    private String nameOfOperator;
    private BigDecimal payrollPerMonth;
    private final Map<MobileTariff.TypeOfCall, BigDecimal> typesOfCallsAndTheirPricesPerMinute;
    private BigDecimal priceForSms;

    public static enum TypeOfCall
    {
        INSIDE_NETWORK, OUTSIDE_NETWORK, LANDLINE_PHONE
    }

    public MobileTariff()
    {
        super();
        this.nameOfTariff = MobileTariff.VALUE_OF_NOT_DEFINED_NAME_OF_TARIFF;
        this.nameOfOperator = MobileTariff.VALUE_OF_NOT_DEFINED_NAME_OF_OPERATOR;
        this.payrollPerMonth = MobileTariff.VALUE_OF_NOT_DEFINED_PAYROLL_PER_MONTH;
        this.typesOfCallsAndTheirPricesPerMinute = MobileTariff.createMapOfTypesOfCallsAndTheirPricesPerMinute();
        this.priceForSms = MobileTariff.VALUE_OF_NOT_DEFINED_PRICE_FOR_SMS;
    }

    public MobileTariff(final long id)
    {
        super(id);
        this.nameOfTariff = MobileTariff.VALUE_OF_NOT_DEFINED_NAME_OF_TARIFF;
        this.nameOfOperator = MobileTariff.VALUE_OF_NOT_DEFINED_NAME_OF_OPERATOR;
        this.payrollPerMonth = MobileTariff.VALUE_OF_NOT_DEFINED_PAYROLL_PER_MONTH;
        this.typesOfCallsAndTheirPricesPerMinute = MobileTariff.createMapOfTypesOfCallsAndTheirPricesPerMinute();
        this.priceForSms = MobileTariff.VALUE_OF_NOT_DEFINED_PRICE_FOR_SMS;
    }

    private static final String VALUE_OF_NOT_DEFINED_NAME_OF_TARIFF = "not defined";
    private static final String VALUE_OF_NOT_DEFINED_NAME_OF_OPERATOR = "not defined";
    private static final BigDecimal VALUE_OF_NOT_DEFINED_PAYROLL_PER_MONTH = BigDecimal.ZERO;
    private static final BigDecimal VALUE_OF_NOT_DEFINED_PRICE_FOR_SMS = BigDecimal.ZERO;

    private static Map<MobileTariff.TypeOfCall, BigDecimal> createMapOfTypesOfCallsAndTheirPricesPerMinute()
    {
        final MobileTariff.TypeOfCall[] typesOfCalls = MobileTariff.TypeOfCall.values();
        final Map<MobileTariff.TypeOfCall, BigDecimal> createdMap
                = new HashMap<MobileTariff.TypeOfCall, BigDecimal>(typesOfCalls.length);
        for(final MobileTariff.TypeOfCall typeOfCall : typesOfCalls)
        {
            createdMap.put(typeOfCall, MobileTariff.VALUE_OF_NOT_DEFINED_PRICE_PER_MINUTE_OF_TYPE_OF_CALL);
        }
        return createdMap;
    }

    private static final BigDecimal VALUE_OF_NOT_DEFINED_PRICE_PER_MINUTE_OF_TYPE_OF_CALL = BigDecimal.ZERO;

    public MobileTariff(final long id, final String nameOfTariff, final String nameOfOperator,
                        final BigDecimal payrollPerMonth,
                        final Map<MobileTariff.TypeOfCall, BigDecimal> typesOfCallsAndTheirPricesPerMinute,
                        final BigDecimal priceForSms)
    {
        super(id);
        this.nameOfTariff = nameOfTariff;
        this.nameOfOperator = nameOfOperator;
        this.payrollPerMonth = payrollPerMonth;
        this.typesOfCallsAndTheirPricesPerMinute
                = MobileTariff.createMapOfTypesOfCallsAndTheirPricesPerMinute(typesOfCallsAndTheirPricesPerMinute);
        this.priceForSms = priceForSms;
    }

    private static Map<MobileTariff.TypeOfCall, BigDecimal> createMapOfTypesOfCallsAndTheirPricesPerMinute(
            final Map<MobileTariff.TypeOfCall, BigDecimal> typesOfCallsAndTheirPricesPerMinute)
    {
        final MobileTariff.TypeOfCall[] typesOfCalls = MobileTariff.TypeOfCall.values();
        final Map<MobileTariff.TypeOfCall, BigDecimal> createdMap
                = new HashMap<MobileTariff.TypeOfCall, BigDecimal>(typesOfCalls.length);
        BigDecimal pricePerMinuteForCurrentCall;
        for(final MobileTariff.TypeOfCall typeOfCall : typesOfCalls)
        {
            pricePerMinuteForCurrentCall = typesOfCallsAndTheirPricesPerMinute.get(typeOfCall);
            createdMap.put(typeOfCall, pricePerMinuteForCurrentCall);
        }
        return createdMap;
    }

    public final void setNameOfTariff(final String nameOfTariff)
    {
        this.nameOfTariff = nameOfTariff;
    }

    public final String getNameOfTariff()
    {
        return this.nameOfTariff;
    }

    public final void setNameOfOperator(final String nameOfOperator)
    {
        this.nameOfOperator = nameOfOperator;
    }

    public final String getNameOfOperator()
    {
        return this.nameOfOperator;
    }

    public final void setPayrollPerMonth(final BigDecimal payrollPerMonth)
    {
        this.payrollPerMonth = payrollPerMonth;
    }

    public final BigDecimal getPayrollPerMonth()
    {
        return payrollPerMonth;
    }

    public final void updatePricePerMinuteOfTypeOfCall(final MobileTariff.TypeOfCall typeOfCall,
                                                       final BigDecimal newPricePerMinute)
    {
        this.typesOfCallsAndTheirPricesPerMinute.put(typeOfCall, newPricePerMinute);
    }

    public final BigDecimal findPricePerMinuteOfTypeOfCall(final MobileTariff.TypeOfCall typeOfCall)
    {
        return this.typesOfCallsAndTheirPricesPerMinute.get(typeOfCall);
    }

    public final void setPriceForSms(final BigDecimal priceForSms)
    {
        this.priceForSms = priceForSms;
    }

    public final BigDecimal getPriceForSms()
    {
        return priceForSms;
    }

    @Override
    public final boolean equals(final Object otherObject)
    {
        if(!super.equals(otherObject))
        {
            return false;
        }
        final MobileTariff other = (MobileTariff)otherObject;
        return     Objects.equals(this.nameOfTariff, other.nameOfTariff)
                && Objects.equals(this.nameOfOperator, other.nameOfOperator)
                && Objects.equals(this.payrollPerMonth, other.payrollPerMonth)
                && Objects.equals(this.typesOfCallsAndTheirPricesPerMinute, other.typesOfCallsAndTheirPricesPerMinute)
                && Objects.equals(this.priceForSms, other.priceForSms);
    }

    @Override
    public final int hashCode()
    {
        return  super.hashCode() + Objects.hash(this.nameOfTariff, this.nameOfOperator, this.payrollPerMonth,
                this.typesOfCallsAndTheirPricesPerMinute, this.priceForSms);
    }

    @Override
    public final String toString()
    {
        return    super.toString() + "[nameOfTariff = " + this.nameOfTariff + ", nameOfOperator = "
                + this.nameOfOperator + ", payrollPerMonth = " + this.payrollPerMonth
                + ", typesOfCallsAndTheirPricesPerMinute = " + this.typesOfCallsAndTheirPricesPerMinute
                + ", priceForSms = " + this.priceForSms + "]";
    }
}
