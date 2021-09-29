<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/mobile_tariffs">
        <table border="1"><tr><td>id</td> <td>name_of_tariff</td> <td>name_of_operator</td> <td>payroll_per_month</td>
            <td>inside_network</td> <td>outside_network</td> <td>landline_phone</td> <td>price_for_sms</td></tr><xsl:apply-templates/></table>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/id">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/name_of_tariff">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/name_of_operator">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/payroll_per_month">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/types_of_calls_and_their_prices_per_minute/inside_network">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/types_of_calls_and_their_prices_per_minute/outside_network">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/mobile_tariffs/mobile_tariff/types_of_calls_and_their_prices_per_minute/landline_phone">
        <td><xsl:apply-templates/></td>
    </xsl:template>


    <xsl:template match="/mobile_tariffs/mobile_tariff/price_for_sms">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>