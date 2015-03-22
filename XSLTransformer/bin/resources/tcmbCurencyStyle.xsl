<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" encoding="utf-8" indent="yes" />
	<xsl:template match="/">
<CurrencyRoot xmlns="http://openuri.org/currency">
    <xsl:for-each select="/Tarih_Date/Currency">
    <Currency>
     	<CurencyName> <xsl:value-of select="CurrencyName"/></CurencyName>
     	<BanknoteBuying> <xsl:value-of select="BanknoteBuying"/></BanknoteBuying>
     	<BanknoteSelling><xsl:value-of select="BanknoteSelling"/></BanknoteSelling>
     	<From> <xsl:value-of select="@Kod"/> </From>
     	<To>TRY</To>
     </Currency>
    </xsl:for-each>
  </CurrencyRoot>
</xsl:template>
</xsl:stylesheet>